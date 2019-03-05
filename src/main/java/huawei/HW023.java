package huawei;

import java.util.Scanner;

public class HW023 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            String encryptStr = scanner.nextLine();
            String unencryptStr = scanner.nextLine();
            System.out.println(encrypt(encryptStr));
            System.out.println(unencrypt(unencryptStr));
        }
        scanner.close();
    }

    private static String encrypt(String encryptStr) {
        StringBuilder builder = new StringBuilder(128);
        for (int i=0; i<encryptStr.length(); i++) {
            char c = encryptStr.charAt(i);
            if (c >= 'a' && c <= 'z') {
                if (c == 'z') {
                    c = 'a';
                } else {
                    c += 1;
                }
                builder.append(String.valueOf(c).toUpperCase());
            } else if (c >= 'A' && c <= 'Z') {
                if (c == 'Z') {
                    c = 'A';
                } else {
                    c += 1;
                }
                builder.append(String.valueOf(c).toLowerCase());
            } else if (c >= '0' && c <= '9') {
                if (c == '9') {
                    c = '0';
                } else {
                    c += 1;
                }
                builder.append(String.valueOf(c));
            } else {
                builder.append(String.valueOf(c));
            }
        }
        return builder.toString();
    }

    private static String unencrypt(String unencryptStr) {
        StringBuilder builder = new StringBuilder(128);
        for (int i=0; i<unencryptStr.length(); i++) {
            char c = unencryptStr.charAt(i);
            if (c >= 'a' && c <= 'z') {
                if (c == 'a') {
                    c = 'z';
                } else {
                    c -= 1;
                }
                builder.append(String.valueOf(c).toUpperCase());
            } else if (c >= 'A' && c <= 'Z') {
                if (c == 'A') {
                    c = 'Z';
                } else {
                    c -= 1;
                }
                builder.append(String.valueOf(c).toLowerCase());
            } else if (c >= '0' && c <= '9') {
                if (c == '0') {
                    c = '9';
                } else {
                    c -= 1;
                }
                builder.append(String.valueOf(c));
            } else {
                builder.append(String.valueOf(c));
            }
        }
        return builder.toString();
    }
}
