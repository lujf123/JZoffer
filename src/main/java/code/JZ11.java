package code;

/**
 * 类似二分查找
 * 如果中间元素位于前面的递增子数组，那么它应该大于或者等于第一个指针指向的元素，此时数组中最小的元素应该位于该中间元素后面；
 * 如果中间元素位于后面的递增子数组，那么它应该小于或等于第二个指针指向的元素，此时该数组中最小的元素应该位于该中间元素的前面；
 * 按照上述思路，第一个指针总数指向前面递增数组的元素，而第二个指针总是指向后面递增数组的元素。
 * 最终第一个指针将指向前面子数组的最后一个元素，而第二个指针会指向后面子数组的第一个元素，这也是结束循环的条件。
 */

public class JZ11 {

    public int minNumberInRotateArray(int [] array) {
        if (array.length == 0) {
            return 0;
        }
        int l = 0;
        int r = array.length - 1;
        int m = (l + r) / 2;
        while (l != r -1) {
            if (array[l] == array[m] && array[m] == array[r]) {
                return minNumber(array, l, r);
            }
            if (array[m] >= array[l]) {
                l = m;
            } else if (array[m] <= array[r]) {
                r = m;
            }
            m = (l + r) / 2;
        }
        return array[r];
    }

    private int minNumber(int[] array, int l, int r) {
        for (int i = l; i < r; i++)
            if (array[i] > array[i + 1])
                return array[i + 1];
        return array[l];
    }

    public static void main(String[] args) {
        int[] arr = {1};
        System.out.println(new JZ11().minNumberInRotateArray(arr));
    }

}
