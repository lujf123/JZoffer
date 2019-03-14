package pinduoduo;

import java.util.ArrayList;
import java.util.Scanner;

public class p1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            System.out.println(func(input));
        }
        scanner.close();
    }

    private static String func(String str) {
        char[] chars = str.toCharArray();
        ArrayList<String> list = new ArrayList<>();
        for (int i=0; i<chars.length; i++) {
            String tmp = String.valueOf(chars[i]).toLowerCase();
            if (list.contains(tmp)) {
                int next = list.indexOf(tmp) + 1;
                if (next < list.size() && tmp.charAt(0) > list.get(next).charAt(0)) {
                    list.remove(tmp);
                    list.add(tmp);
                }
            } else {
                list.add(tmp);
            }
        }
        return list.get(0);
    }
}
