package huawei;

import java.util.Scanner;

/**
 * 整数与 IP 地址间的转换
 */

public class HW026 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str1 = scanner.nextLine();
            String str2 = scanner.nextLine();
            System.out.println(ipToInt(str1));
            System.out.println(intToIp(str2));
        }
        //System.out.println(((0 << 8) + 10) << 24);
    }

    private static String intToIp(String str) {
        String result = "";
        Long input = Long.parseLong(str);
        for (int i = 3; i >= 0; i--) {
            result = (input & 0x000000FF) + "." + result;
            input >>= 8;
        }
        return result.substring(0, result.length() - 1);
    }

    private static long ipToInt(String str) {
        String[] array;
        long result = 0;
        array = str.split("[.]");
        for (String s : array) {
            result = (result << 8) + Integer.parseInt(s);
        }
        return result;
    }

}
