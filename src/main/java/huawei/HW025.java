package huawei;

import java.util.Scanner;

public class HW025 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNext()) {
            String str = scanner.nextLine();
            System.out.println(reverse(str));
        }
        scanner.close();
    }

    private static String reverse(String str) {
        char[] chars = str.toCharArray();
        StringBuilder builder = new StringBuilder(256);
        boolean flag = false;
        for (int i=0; i<chars.length; i++) {
            if (isLetter(chars[i])) {
                builder.append(chars[i]);
                flag = false;
                continue;
            } else {
                if (flag == false) {
                    builder.append(" ");
                    flag = true;
                }
            }
        }
        String[] strings = builder.toString().split(" ");
        StringBuilder result = new StringBuilder(256);
        for (int i=strings.length-1; i>=0; i--) {
            result.append(strings[i]);
            result.append(" ");
        }
        result.deleteCharAt(result.length()-1);
        return result.toString();
    }

    private static boolean isLetter(char c) {
        return c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z';
    }

}
