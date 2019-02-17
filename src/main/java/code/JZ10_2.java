package code;


/**
 * 如果只有 1 级台阶，只有一种跳法；如果有 2 级台阶，那就有两种跳法。
 * 把 n 级台阶时的跳法看成是 n 的函数，记为 f(n)
 * 当 n>2 时，第一次跳的时候就有两种不同的选择，一次是第一次跳 1 级。此时跳法数目等于后面剩下的 n-1 级台阶的跳法数目，即为 f(n-1)；
 * 二是第一次跳 2 级，此时跳法数目等于后面剩下的 n-2 级台阶的跳法数目，即为 f(n-2)
 * 转换成 斐波那契数列 f(n) = f(n-1) + f(n-2)
 */

public class JZ10_2 {

    public int JumpFloor(int target) {
        int[] arr = new int[target+1];
        if (target == 1) {
            arr[target] = 1;
        }
        if (target == 2) {
            arr[target] = 2;
        }
        if (target >= 3) {
            arr[1] = 1;
            arr[2] = 2;
        }
        for (int i=3; i<=target; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }
        return arr[target];
    }


    public static void main(String[] args) {
        int result = new JZ10_2().JumpFloor(3);
        System.out.println(result);
    }

}
