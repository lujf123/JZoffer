package huawei;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class HW009 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            System.out.println(extractNumber(input));
        }
        scanner.close();
    }

    private static String extractNumber(String input) {
        char[] chars = input.toCharArray();
        int len = chars.length - 1;
        Set<Integer> set = new HashSet<>();
        StringBuilder builder = new StringBuilder(128);
        while (len >= 0) {
            Integer tmp = Integer.valueOf(chars[len]);
            if (set.contains(tmp) == false) {
                builder.append(chars[len]);
                set.add(tmp);
                len--;
            } else {
                len--;
            }
        }
        return builder.toString();
    }
}
