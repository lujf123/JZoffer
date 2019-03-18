package code;

public class JZ53_2 {
    public static int getMissingNumber(int[] arr) {
        if (arr == null || arr.length <= 0) {
            return -1;
        }
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] != mid) {
                // 判断条件
                if (mid == 0 || arr[mid-1] == mid - 1) {
                    return mid;
                }
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (left == arr.length) {
            return arr.length;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 4, 5, 6, 7};
        System.out.println(getMissingNumber(arr));
    }
}
