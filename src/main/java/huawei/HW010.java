package huawei;

import java.util.Scanner;

public class HW010 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            System.out.println(countChar(input));
        }
        scanner.close();
    }

    private static int countChar(String str) {
        int cnt = 0;
        int[] array = new int[127];
        for (int i=0; i<str.length(); i++) {
            if (str.charAt(i) >=0 && str.charAt(i) < 127) {
                array[str.charAt(i)]++;
            }
        }
        for (int i=0; i<array.length; i++) {
            if (array[i] > 0) {
                cnt++;
            }
        }
        return cnt;
    }
}
