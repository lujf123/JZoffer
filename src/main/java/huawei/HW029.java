package huawei;

import java.util.ArrayList;
import java.util.Scanner;


/**
 * 字符串加密
 */

public class HW029 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String mask = scanner.nextLine();
            String s = scanner.nextLine();
            System.out.println(encrypt(mask, s));
        }
        scanner.close();
    }

    private static String encrypt(String mask, String s) {
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        char[] cs = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        for (int i=0; i<cs.length; i++) {
            list2.add(String.valueOf(cs[i]));
        }

        char[] chars = mask.toCharArray();
        for (int i = 0; i<chars.length; i++) {
            String tmp = String.valueOf(chars[i]).toUpperCase();
            if (!list1.contains(tmp)) {
                list1.add(tmp);
                if (list2.contains(tmp)) {
                    list2.remove(tmp);
                }
            }
        }
        chars = new char[26];
        for (int i = 0; i<list1.size(); i++) {
            chars[i] = list1.get(i).charAt(0);
        }
        for (int i = list1.size(); i<26; i++) {
            chars[i] = list2.get(i-list1.size()).charAt(0);
        }
        StringBuilder builder = new StringBuilder();
        for (int i=0; i<s.length(); i++) {
            char tmp = s.charAt(i);
            if (tmp >= 'a' && tmp <= 'z') {
                int index = tmp - 'a';
                builder.append(String.valueOf(chars[index]).toLowerCase());
            } else if (tmp >= 'A' && tmp <= 'Z') {
                int index = tmp - 'A';
                builder.append(String.valueOf(chars[index]));
            }
        }
        return builder.toString();
    }

}
