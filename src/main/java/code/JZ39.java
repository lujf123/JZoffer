package code;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class JZ39 {

    public int MoreThanHalfNum_Solution(int [] array) {
        if (array.length == 0 || array == null) {
            return 0;
        }
        int len = array.length;
        Arrays.sort(array);
        int num = 0, cnt = 0;
        for (int i=0; i<len; i++) {
            if (num == array[i]) {
                cnt++;
                if (cnt > len/2) {
                    return num;
                }
            } else {
                num = array[i];
                cnt = 1;
            }
        }
        if (cnt > len / 2) {
            return num;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(1/2);
        Integer[] a = {9, 8, 7, 2, 3, 4, 1, 0, 6, 5};
        Comparator cmp = new MyComparator();
        Arrays.sort(a, cmp);
        for(int arr:a) {
            System.out.print(arr + " ");
        }
    }

    static class MyComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }

}
