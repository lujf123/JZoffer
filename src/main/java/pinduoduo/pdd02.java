package pinduoduo;

import java.util.ArrayList;
import java.util.Scanner;

public class pdd02 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<>();
        while (scanner.hasNextInt()) {
            arr.add(scanner.nextInt());
        }
        System.out.println(getMax(arr));
        scanner.close();
    }

    private static int getMax(ArrayList<Integer> arr) {
        arr.sort((o1, o2) -> o2 - o1);
        int sum = 1;
        if (arr.size() >= 3) {
            sum = sum * arr.get(0) * arr.get(1) * arr.get(2);
        }
        return sum;
    }

}
