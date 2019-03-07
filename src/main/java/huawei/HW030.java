package huawei;

import java.util.Scanner;

/**
 * 统计每个月兔子的总数
 */
public class HW030 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int month = scanner.nextInt();
            System.out.println(getTotalCount(month));
            //System.out.println(countRabbit(month));
        }
        scanner.close();
    }

    private static int countRabbit(int input) {

        if (input <= 0) {
            return 0;
        } else if (input <= 2) {
            return 1;
        } else {

            int prev1 = 1;
            int prev2 = 1;
            int result = 0;
            for (int i = 3; i <= input; i++) {
                result = prev1 + prev2;
                prev1 = prev2;
                prev2 = result;
            }
            return result;
        }
    }

    private static int getTotalCount(int month) {
        int m1 = 1;
        int m2 = 0;
        int m3 = 0;

        for (int i=1; i<month; i++) {
            m3 += m2;
            m2 = m1;
            m1 = m3;
        }
        return m1+m2+m3;
    }

}
