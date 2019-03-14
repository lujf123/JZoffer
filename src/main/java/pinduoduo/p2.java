package pinduoduo;

import java.util.*;

public class p2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Node> list = new ArrayList<>();
        int n, d;
        while (scanner.hasNext()) {
            n = scanner.nextInt();
            d = scanner.nextInt();
            int a, b;
            for (int i=0; i<n; i++) {
                a = scanner.nextInt();
                b = scanner.nextInt();
                list.add(new Node(a, b));
            }
            System.out.println(func(list, n, d));
        }
        scanner.close();
    }

    private static int func(ArrayList<Node> list, int n, int d) {
        int max = -1;
        for (int i=0; i<n; i++) {
            for (int j = i+1; j<n; j++) {
                if (Math.abs(list.get(i).a - list.get(j).a) >= d) {
                    int sum = list.get(i).b + list.get(j).b;
                    if (sum > max) {
                        max = sum;
                    }
                }
            }
        }

        return max;
    }

    static class Node {
        public int a;
        public int b;

        public Node(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

}
