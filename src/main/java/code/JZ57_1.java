package code;

import java.util.ArrayList;

public class JZ57_1 {

    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        if (array == null || array.length == 0) {
            return list;
        }
        int left = 0, right = array.length-1;
        while (left < right) {
            if (array[left] + array[right] == sum) {
                break;
            } else if (array[left] + array[right] < sum) {
                left++;
            } else if (array[left] + array[right] > sum) {
                right--;
            }
        }
        if (array[left] + array[right] == sum) {
            list.add(array[left]);
            list.add(array[right]);
        }
        return list;
    }
}
