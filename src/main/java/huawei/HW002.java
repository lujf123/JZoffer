package huawei;

import java.util.Scanner;

public class HW002 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.next().toLowerCase();
            String chStr = scanner.next().toLowerCase();
            char ch = chStr.charAt(0);
            System.out.println(countCharNumber(input, ch));

        }
    }

    public static int countCharNumber(String string, char ch) {
        int len = string.length();
        int cnt = 0;

        for (int i=0; i<len; i++) {
            if (string.charAt(i) == ch) {
                cnt++;
            }
        }
        return cnt;
    }


}
