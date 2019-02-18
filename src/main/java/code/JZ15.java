package code;

/**
 * 除法的效率比移位运算要低得多，在实际编程中应尽可能地用移位运算符代替乘除法
 */

public class JZ15 {
    public int NumberOf1(int n) {
        int cnt = 0;
        while (n != 0) {
            cnt++;
            n &= (n - 1);
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(new JZ15().NumberOf1(8));
    }
}
