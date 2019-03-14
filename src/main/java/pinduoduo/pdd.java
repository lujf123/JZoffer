package pinduoduo;

import java.util.ArrayList;
import java.util.Scanner;

public class pdd {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        while (scanner.hasNext()) {
            n = scanner.nextInt();
            for (int i=0; i<n; i++) {
                a.add(scanner.nextInt());
            }
            for (int i=0; i<n; i++) {
                b.add(scanner.nextInt());
            }
            System.out.println(func(a, b));
        }
        scanner.close();
    }

    private static int func(ArrayList<Integer> a, ArrayList<Integer> b) {
        a.sort((o1, o2) -> o1 - o2);
        b.sort((o1, o2) -> o2 - o1);
        int sum = 0;
        for (int i=0; i<a.size(); i++) {
            sum = sum + a.get(i) * b.get(i);
        }
        return sum;
    }

}
