package huawei;

import java.util.Scanner;

public class HW013 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            System.out.println(reverseSentence(input));
        }
        scanner.close();
    }

    private static String reverseSentence(String input) {
        String[] strings = input.split(" ");
        StringBuilder builder = new StringBuilder(256);
        for (int i=strings.length-1; i>=0; i--) {
            builder.append(strings[i]);
            builder.append(" ");
        }
        builder.deleteCharAt(builder.length()-1);
        return builder.toString();
    }

}
