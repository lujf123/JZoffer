package code;

/**
 * 解题思路
 * 要求的时间复杂度是 O(N)，空间复杂度是O(1)，因此不能使用排序的方法，也不能使用额外的标记数组
 * 对于这种数组元素[0, n-1]范围内的问题，可以将值为 i 的元素调整到第 i 个位置上进行求解
 *
 * 算法逻辑
 * 重排这个数组。从头到尾一次扫描这个数组中的每个数字。当扫描到下标为 i 的数字时，首先比较这个数字（用m表示）是不是等于i，如果是，则接着扫描下一个数字；
 * 如果不是，则再拿它和第 m 个数字进行比较。如果它和第 m 个数字相等，就找到了一个重复的数字（该数字在下标为 i 和 m 的位置都出现了）；
 * 如果它和第 m 个数字不相等，就把第 i 个数字和第 m 个数字交换，把 m 放到属于它的位置。
 * 接下来再重复这个比较、交换的过程，直到我们发现一个重复的数字。
 */

public class JZ03 {

    public boolean duplicate(int[] nums, int length, int[] duplication) {
        if (nums == null || length <= 0) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    duplication[0] = nums[i];
                    return true;
                }
                swap(nums, i, nums[i]);
            }
        }
        return false;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

}
