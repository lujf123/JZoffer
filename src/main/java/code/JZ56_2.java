package code;

public class JZ56_2 {

    public static  int findNumberAppearingOnce(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }
        int[] bitSum = new int[32];
        for (int i = 0; i < nums.length; i++) {
            int bitMask = 1;
            for (int j = 31; j >= 0; j--) {
                int bit = nums[i] & bitMask;
                if (bit != 0) {
                    bitSum[j] += 1;
                }
                bitMask = bitMask << 1;
            }
        }
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = result << 2;
            result += bitSum[i] % 3;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2 , 2, 2, 3, 4, 4, 4};
        int[] nums1 = {2};
        System.out.println(findNumberAppearingOnce(nums1));
    }

}
