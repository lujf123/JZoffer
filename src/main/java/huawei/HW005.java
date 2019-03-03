package huawei;

import java.util.Scanner;

public class HW005 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            char[] chars = str.substring(2, str.length()).toCharArray();
            System.out.println(hexToDec(chars));
            //break;
        }
    }

    public static int hexToDec(char[] chars) {
        int len = chars.length;
        int result = 0;
        for (int i=len-1; i>=0; i--) {
            int tmp = 0;
            if (chars[i] >= '0' && chars[i] <= '9') {
                tmp = chars[i] - '0';
            } else {
                tmp = chars[i] - '0' - 7;
            }
            int c = len - 1 - i;
            while (c != 0) {
                c--;
                tmp *= 16;
            }
            result += tmp;
        }
        return result;
    }
}
