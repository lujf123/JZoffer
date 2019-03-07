package huawei;

import java.util.Scanner;

public class HW033 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            System.out.println(count(input));
        }
        scanner.close();
    }

    private static String count(String input) {
        int blank = 0, num = 0, ch = 0, other = 0;

        for (int i=0; i<input.length(); i++) {
            char tmp = input.charAt(i);
            if (tmp == ' ') {
                blank++;
            } else if ((tmp >= 'a' && tmp <= 'z') || tmp >= 'A' && tmp <= 'Z') {
                ch++;
            } else if (tmp >= '0' && tmp <= '9') {
                num++;
            } else {
                other++;
            }
        }
        StringBuilder builder = new StringBuilder();
        builder.append(ch).append("\n");
        builder.append(blank).append("\n");
        builder.append(num).append("\n");
        builder.append(other);
        return builder.toString();
    }

}
