package huawei;

import java.util.Scanner;

public class HW006 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            long input = scanner.nextLong();
            System.out.println(findPrimes(input));
        }
    }

    private static String findPrimes(long num) {
        StringBuilder builder = new StringBuilder(128);
        long i = 2;
        while (i <= num) {
            // 每次的 i 一定是质数时才会满足
            // 因为如果是一个合数，那它一定是由更小的质数相乘得来的
            // 而在 i 前的质数已经全部被使用过了，不能再整除 num 了
            while (num % i == 0) {
                builder.append(i).append(' ');
                num /= i;
            }
            i++;
        }
        return builder.toString();
    }

}
