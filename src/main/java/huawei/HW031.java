package huawei;

import java.util.Scanner;

/**
 * 求小球落地5次后所经历的路程和第5次反弹的高度
 */
public class HW031 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int high = scanner.nextInt();
            System.out.printf("%g\n", getJourney(high));
            System.out.printf("%g\n", getTenthHigh(high));
        }
        scanner.close();
    }

    private static double getJourney(int high) {
        double sum = 0;
        double h = high;
        sum += high;
        for (int i=1; i<5; i++) {
            sum += h;
            h /= 2;
        }
        return sum;
    }

    private static double getTenthHigh(int high) {
        double h = high;
//        for (int i=1; i<=5; i++) {
//            h /= 2;
//        }
        return h/32;
    }

}
