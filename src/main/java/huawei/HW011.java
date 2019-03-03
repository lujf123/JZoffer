package huawei;

import java.util.Scanner;

public class HW011 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            System.out.println(reverseNumber(input));
        }
        scanner.close();
    }

    private static String reverseNumber(String num) {
        StringBuilder builder = new StringBuilder(128);
        for (int i=num.length()-1; i>=0; i--) {
            builder.append(num.charAt(i));
        }
        return builder.toString();
    }
}
