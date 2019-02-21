package code;

public class JZ21 {

    public void reOrderArray(int [] array) {
        if (array == null || array.length == 0) {
            return;
        }
        int p1 = 0, p2 = array.length-1;
        int tmp;
        while (p1 < p2) {
            if (array[p1] % 2 == 1 && array[p2] % 2 == 0) {
                p1++;
                p2--;
            } else if (array[p1] % 2 == 1 && array[p2] % 2 == 1) {
                p1++;
            } else if (array[p1] % 2 == 0 && array[p2] % 2 == 1) {
                tmp = array[p1];
                array[p1] = array[p2];
                array[p2] = tmp;
                p1++;
                p2--;
            } else if (array[p1] % 2 == 0 && array[p2] % 2 == 0) {
                p2--;
            }
        }
    }

}
