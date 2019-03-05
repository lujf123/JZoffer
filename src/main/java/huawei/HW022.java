package huawei;

import java.util.Scanner;

public class HW022 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
            System.out.println(countPrimePairs(arr));
        }

        scanner.close();
    }

    /**
     * 从后向前看
     * 利用动态规划解题，dp[i] 表示(n-1)~i 最多有的伴侣数；
     * 当 v[i] + v[j] 为素数。dp[i] + dp[j+1] = dp[i+1] + dp[j+1] + 1;
     * 由于伴侣数成对出现，必然只能在 i-1 和 j-1 的基础上出现一对。
     * 当 v[i] + v[j] 不为素数。dp[i] = dp[i+1]
     * @param arr
     * @return
     */
    private static int countPrimePairs(int[] arr) {
        int[] dp = new int[arr.length + 1];
        for (int i = arr.length-2; i>-1; i--) {
            for (int j = arr.length-1; j>i; j--) {
                int cnt = isPrime(arr[i] + arr[j]) ? (dp[i + 1] - dp[j - 1] + dp[j + 1] + 1) : dp[i + 1];
                dp[i] = (cnt > dp[i] ? cnt : dp[i]);
            }
        }
        return dp[0];
    }

    private static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        int sqrt = (int) Math.sqrt(n);
        for (int i=2; i<=sqrt; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
