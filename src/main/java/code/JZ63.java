package code;

public class JZ63 {
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int min = prices[0];
        int maxDiff = prices[1] - min;
        // 在卖出价固定时，买入价约低利润越大
        for (int i = 2; i < prices.length; i++) {
            if (prices[i - 1] < min) {
                min = prices[i - 1]; // 最低买入价
            }
            int currentDiff = prices[i] - min;
            if (currentDiff > maxDiff) {
                maxDiff = currentDiff;
            }
        }
        return (maxDiff <= 0) ? 0 : maxDiff;
    }

    public static void main(String[] args) {
        int[] arr = {7, 6, 4, 3, 1};
        System.out.println(maxProfit(arr));
    }
}
