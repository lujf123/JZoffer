package huawei;

import java.util.Scanner;

public class HW015 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            System.out.println(countOnes(num));
        }
        scanner.close();
    }

    private static int countOnes(int num) {
        int cnt = 0;
        while (num / 2 != 0) {
            if (num % 2 == 1) {
                num = num>>1;
                cnt++;
            } else {
                num = num>>1;
            }
        }
        if (num == 1) {
            cnt++;
        }
        return cnt;
    }
}
