package code;

public class JZ41_2 {

    public int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int greatestSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int val : array) {
            //sum = sum <= 0 ? val : sum + val;
            if (sum <= 0) {
                sum = val;
            } else {
                sum = sum + val;
            }
            greatestSum = Math.max(greatestSum, sum);
        }
        return greatestSum;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE);
    }
}
