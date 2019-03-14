package algorithm;

/**
 * 钢条切割
 */
public class DP2 {
    public static void main(String[] args) {
        int[] p = {1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
        System.out.println(rec_cutBar(p, 4));
    }

    public static int rec_cutBar(int[] p, int n) {
        if (n == 0) {
            return 0;
        }
        int maxValue = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            maxValue = Math.max(maxValue, p[i-1] + rec_cutBar(p, n-i));
        }
        return maxValue;
    }

    public static int dp_cut(int[] p, int n) {
        return 0;
    }


}
