package code;

import java.util.ArrayList;
import java.util.List;

public class JZ33 {

    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence.length == 0 || sequence == null) {
            return false;
        }
        return verfy(sequence);
    }

    private boolean verfy(int[] sequence) {
        if (sequence.length <= 2 || sequence == null) {
            return true;
        }
        int len = sequence.length;
        int root = sequence[len - 1];
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        boolean isFlag = false;
        for (int i=0; i<len-1; i++) {
            if (sequence[i] < root) {
                if (isFlag == false) {
                    left.add(sequence[i]);
                } else {
                    return false;
                }
            }
            if (sequence[i] > root) {
                isFlag = true;
                right.add(sequence[i]);
            }
        }
        return verfy(left.stream().mapToInt(Integer::intValue).toArray())
                && verfy(right.stream().mapToInt(Integer::intValue).toArray());
    }

}
