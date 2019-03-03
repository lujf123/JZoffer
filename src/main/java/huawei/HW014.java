package huawei;

import java.util.Scanner;
import java.util.TreeSet;

public class HW014 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            TreeSet<String> sets = new TreeSet<>();
            for (int i=0; i<num; i++) {
                sets.add(scanner.nextLine());
            }
            printSets(sets);
            break;
        }
        scanner.close();
    }

    private static void printSets(TreeSet<String> sets) {
        for (String s : sets) {
            System.out.println(s);
        }
    }
}
