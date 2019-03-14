package algorithm;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(Fibonacci3(7));
    }

    public static int Fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return Fibonacci(n-1) + Fibonacci(n-2);
    }

    public static int Fibonacci1(int n) {
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

    public static int Fibonacci2(int n) {
        if (n <= 0) {
            return n;
        }
        int[] memory = new int[n+1];
        for (int i = 0; i <= n; i++) {
            memory[i] = -1;
        }
        return fib(n, memory);
    }

    public static int fib(int n, int[] memory) {
        if (memory[n] != -1) {
            return memory[n];
        }
        // 如果已经求出了 fib(n) 的值则直接返回，否则将求出的值保存在memory中
        if (n <= 2) {
            memory[n] = 1;
        } else {
            memory[n] = fib(n-1, memory) + fib(n-2, memory);
        }
        return memory[n];
    }

    public static int Fibonacci3(int n) {
        if (n <= 1) {
            return n;
        }
        int pre1 = 1; // fib(i-1)
        int pre2 = 0; // fib(i-2)
        int result = 0; // fib(i)
        for (int i = 2; i <= n; i++) {
            result = pre1 + pre2;
            pre2 = pre1;
            pre1 = result;
        }
        return result;
    }

}
