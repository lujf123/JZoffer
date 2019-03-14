package pinduoduo;


import java.util.ArrayList;
import java.util.Scanner;

public class pdd01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, m;
        ArrayList<Integer> h = new ArrayList<>();
        ArrayList<Integer> w = new ArrayList<>();
        while (scanner.hasNext()) {
            n = scanner.nextInt();
            while (n > 0) {
                h.add(scanner.nextInt());
                n--;
            }
            m = scanner.nextInt();
            while (m > 0) {
                w.add(scanner.nextInt());
                m--;
            }
            System.out.println(countMaxNum(h, w));
        }
        scanner.close();

    }

    /**
     * w[i] 表示第 i 颗巧克力分别的大小
     * h[j] 表示第 j 个同学要求的巧克力大小，当 w[i]>=h[j] 时才会上台表演
     * 对 w[i],h[j] 由小到大排序后比较
     */
    private static int countMaxNum(ArrayList<Integer> h, ArrayList<Integer> w) {
        h.sort((o1, o2) -> o1 - o2);
        w.sort((o1, o2) -> o1 - o2);
        int count = 0;
        for(int i=0, j=0; j<h.size() && i<w.size(); i++) {
            if(w.get(i) >= h.get(j)) {
                count++;
                j++;
            }
        }
        return count;
    }

}