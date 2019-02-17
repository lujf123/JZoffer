package code;

/**
 * 转换成斐波那契数列
 */

public class JZ10_3 {

    public int RectCover(int target) {
        int[] arr = new int[target + 1];
        if (target <= 2) {
            return target;
        }
        arr[1] = 1;
        arr[2] = 2;
        for (int i=3; i<=target; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }
        return arr[target];
    }

}
