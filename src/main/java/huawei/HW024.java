package huawei;

import java.util.Scanner;

public class HW024 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            String str1 = scanner.next();
            String str2 = scanner.next();
            System.out.println(mergeStr(str1, str2));
        }
        scanner.close();
    }

    private static String mergeStr(String str1, String str2) {
        String str = str1 + str2;
        char[] chars = str.toCharArray();
        // 排序数组
        for (int i = 0; i < chars.length; i += 2) {
            //char min = chars[i];
            int min = i;
            for (int j = i+2; j < chars.length; j += 2) {
                if (chars[min] > chars[j]) {
                    min = j;
                }
            }
            char tmp = chars[i];
            chars[i] = chars[min];
            chars[min] = tmp;
        }

        for (int i = 1; i < chars.length; i += 2) {
            //char min = chars[i];
            int min = i;
            for (int j = i+2; j < chars.length; j += 2) {
                if (chars[min] > chars[j]) {
                    min = j;
                }
            }
            char tmp = chars[i];
            chars[i] = chars[min];
            chars[min] = tmp;
        }
        for (int i=0; i<chars.length; i++) {
            char tmp = chars[i];
            chars[i] = convert(tmp);
        }
        return new String(chars);
    }

    private static char convert(char c) {
        // 手工转换
        char[] mask = {'0', '8', '4', 'C', '2', 'A', '6', 'E', '1', '9', '5', 'D', '3', 'B', '7', 'F'};
        if (c >= '0' && c <='9') {
            return mask[c - '0'];
        } else if (c >= 'a' && c <= 'f') {
            return mask[c - 'a' + 10];
        } else if (c >= 'A' && c <= 'F') {
            return mask[c - 'A' + 10];
        }
        return c;
    }

}
