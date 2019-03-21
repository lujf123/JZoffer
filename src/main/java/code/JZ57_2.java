package code;

import java.util.ArrayList;

public class JZ57_2 {
    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        if (sum < 3) {
            return lists;
        }
        int start = 1, end = 2;
        int tmp =  start + end;
        while (start < end) {
            if (tmp == sum) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = start; i <= end; i++) {
                    list.add(i);
                }
                lists.add(list);
                end++;
                tmp += end;
            } else if (tmp < sum) {
                end++;
                tmp += end;
            } else if(tmp > sum) {
                tmp -= start;
                start++;
            }
        }
        return lists;
    }

    public static void main(String[] args) {

        System.out.println(FindContinuousSequence(9));
    }
}
