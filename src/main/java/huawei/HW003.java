package huawei;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class HW003 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            Set<Integer> set = new TreeSet<>();
            while ((--num) >= 0) {
                set.add(scanner.nextInt());
            }
            System.out.println(setToString(set));
        }

    }

    public static String setToString(Set<Integer> set) {
        StringBuilder builder = new StringBuilder(128);
        int len = set.size();
        int cnt = 0;
        for (Integer i : set) {
            cnt++;
            if (cnt != len) {
                builder.append(i).append("\n");
            } else {
                builder.append(i);
            }
        }
        return builder.toString();
    }

}
