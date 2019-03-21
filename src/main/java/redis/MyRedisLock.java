package redis;

import redis.clients.jedis.Jedis;

import java.util.Collections;
import java.util.UUID;

public class MyRedisLock {
    private static final Long RELEASE_SUCCESS = 1L;

    private Jedis jedis;

    private String lockKey;

    private String value;

    private static final Integer DEFAULT_TIMEOUT = 30;

    private static final String SUFFIX = ":lock";

    public MyRedisLock(Jedis jedis) {
        this.jedis = jedis;
    }

    public boolean acquire(String key, long time) throws InterruptedException {
        Long outdatedTime = System.currentTimeMillis() + time;
        lockKey = key + SUFFIX;
        System.out.println(lockKey);
        while (true) {
            if (System.currentTimeMillis() >= outdatedTime) {
                return false;
            }
            value = UUID.randomUUID().toString(); // 1
            return "OK".equals(jedis.set(lockKey, value, "nx", "ex", DEFAULT_TIMEOUT)); // 2
        }
    }

    public boolean check() {
        return value != null && value.equals(jedis.get(lockKey)); // 3
    }

    public boolean release() {
        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
        Object result = jedis.eval(script, Collections.singletonList(lockKey), Collections.singletonList(value));
        if (RELEASE_SUCCESS.equals(result)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyRedisLock redisLock = new MyRedisLock(new Jedis());
        //System.out.println(redisLock.acquire("ljf", 10000));
        //System.out.println(redisLock.check());
        System.out.println(redisLock.release());
    }
}
