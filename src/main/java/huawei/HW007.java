package huawei;

import java.util.Scanner;

public class HW007 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            double input = scanner.nextDouble();
            System.out.println(floatToNearInt(input));
        }
        scanner.close();
    }

    private static int floatToNearInt(double num) {
        return (int) (num * 10 + 5) / 10;
    }
}
