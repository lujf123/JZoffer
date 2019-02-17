package code;

public class JZ10_1 {

    /**
     * 递归
     * 存在重复计算的问题
     * @param n
     * @return
     */
    public int Fibonacci1(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return Fibonacci1(n-1) + Fibonacci1(n-2);
    }

    /**
     * 动态规划
     * 把子问题缓存起来，从而避免重复求解子问题
     * @param n
     * @return
     */
    public int Fibonacci2(int n) {
        if (n <= 1) {
            return n;
        }
        int[] fib = new int[n + 1];
        fib[1] = 1;
        for (int i=2; i<=n; i++) {
            fib[i] = fib[i-1] + fib[i-2];
        }
        return fib[n];
    }

    /***
     * 考虑到第 i 项只与第 i-1 和第 i-2 项有关，因此只需要存储前两项的值就能求解第 i 项，
     * 从而将空间复杂度由 O(N) 降低为 O(1)。
     * @param n
     * @return
     */
    public int Fibonacci3(int n) {
        if (n <=1) {
            return n;
        }
        int pre2 = 0, pre1 = 1;
        int fib = 0;
        for (int i=2; i<=n; i++) {
            fib = pre2 + pre1;
            pre2 = pre1;
            pre1 = fib;
        }
        return fib;
    }

    public static void main(String[] args) {
        System.out.println(new JZ10_1().Fibonacci1(10));
        System.out.println(new JZ10_1().Fibonacci2(10));
        System.out.println(new JZ10_1().Fibonacci3(10));
    }

}
