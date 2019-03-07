package huawei;

import java.util.Arrays;
import java.util.Scanner;

public class HW027 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            System.out.println(sortCards(input));
        }
        scanner.close();
    }

    private static String sortCards(String input) {
        char[] chars = input.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
