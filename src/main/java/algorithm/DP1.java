package algorithm;

public class DP1 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 1, 7, 8, 3};
        System.out.println(rec_opt(arr, arr.length-1));
        System.out.println(dp_opt(arr, arr.length-1));
    }



    private static int rec_opt(int[] arr, int n) {
        if (n == 0) {
            return arr[0];
        } else if (n == 1) {
            return Math.max(arr[0], arr[1]);
        } else {
            int chose = rec_opt(arr, n-2) + arr[n];
            int notChose = rec_opt(arr, n-1);
            return Math.max(chose, notChose);
        }
    }

    private static int dp_opt(int[] arr, int n) {
        int[] opt = new int[arr.length];
        opt[0] = arr[0];
        opt[1] = Math.max(arr[0], arr[1]);
        for (int i = 2; i <= n; i++) {
            opt[i] = Math.max(opt[i-2] + arr[i], opt[i-1]);
        }
        return opt[n];
    }

}
