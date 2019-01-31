package redis;

import java.util.HashMap;
import java.util.Map;

public class FunnelRateLimiter {

    static class Funnel {
        int capacity;
        float leakingRate;
        int leftQuota;
        long leakingTs;

        public Funnel(int capacity, float leakingRate) {
            this.capacity = capacity;  // 漏斗容量
            this.leakingRate = leakingRate;  // 漏嘴流水速率
            this.leftQuota = capacity; // 漏斗剩余空间
            this.leakingTs = System.currentTimeMillis(); // 上一次漏水时间
        }

        void makeSpace() {
            long nowTs = System.currentTimeMillis();
            long deltaTs = nowTs - leakingTs;  // 距离上一次漏水过去了多久
            int deltaQuota = (int) (deltaTs * leakingRate);  // 又可以腾出多少空间
            if (deltaQuota < 0) { // 间隔时间太长，整数数字过大溢出
                this.leftQuota = capacity;
                this.leakingTs = nowTs;
                return;
            }
            if (deltaQuota < 1) { // 腾出空间太小，最小单位是 1，等待下一次
                return;
            }
            this.leftQuota += deltaQuota; // 增加剩余空间
            this.leakingTs = nowTs; // 记录漏水时间
            if (this.leftQuota > this.capacity) { // 剩余空间不得高于容量
                this.leftQuota = this.capacity;
            }
        }

        boolean watering(int quota) {
            makeSpace();
            if (this.leftQuota >= quota) {
                this.leftQuota -= quota;
                return true;
            }
            return false;
        }
    }

    private Map<String, Funnel> funnels = new HashMap<String, Funnel>();

    public boolean isActionAllowed(String userId, String actionKey, int capacity, float leakingRate) {
        String key = String.format("%s:%s", userId, actionKey);
        Funnel funnel = funnels.get(key);
        if (funnel == null) {
            funnel = new Funnel(capacity, leakingRate);
            funnels.put(key, funnel);
        }
        return funnel.watering(1); // 需要1个 quota
    }

}
