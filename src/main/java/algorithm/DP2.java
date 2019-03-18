package algorithm;

/**
 * 钢条切割问题
 */
public class DP2 {
    public static void main(String[] args) {
        int[] p = {1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
        System.out.println(rec_cutBar(p, 5));
        System.out.println(dp_cut(p, 5));
        System.out.println(memory_cut(p, 5));
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
        int[] opt = new int[p.length+1];
        for (int i = 1; i <= p.length; i++) {
            int maxValue = Integer.MIN_VALUE;
            for (int j = 1; j <= i; j++) {
                maxValue = Math.max(maxValue, p[j-1] + opt[i-j]);
                opt[i] = maxValue;
            }
        }
        return opt[n];
    }

    public static int memory_cut(int[] p, int n) {
        int[] memory = new int[p.length+1];
        for (int i = 0; i <= p.length; i++) {
            memory[i] = -1;
        }
        return cut(p, n, memory);
    }
    public static int cut(int[] p, int n, int[] memory) {
        if (n == 0) {
            return 0;
        }
        if (memory[n] != -1) {
            return memory[n];
        }
        int maxValue = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            maxValue = Math.max(maxValue, p[i-1] + cut(p,n-i, memory));
        }
        memory[n] = maxValue;
        return memory[n];
    }


}
