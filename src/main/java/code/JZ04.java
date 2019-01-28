package code;

/**
 * 规律：
 * 首先选取数组中右上角的数字。如果该数字等于要查找的数字，则查找过程结束；
 * 如果该数字大于要查找的数字，则剔除这个数字所在的列；
 * 如果该数字小于要查找的数字，则剔除这个数字所在的行
 */

public class JZ04 {

    public boolean Find(int target, int [][] array) {
        if (array == null || array.length == 0 || array[0].length == 0) {
            return false;
        }
        int rows = array.length;
        int cols = array[0].length;
        int r = 0, c = cols - 1; // 从右上角开始
        while (r <= rows - 1 && c >= 0) {
            if (target == array[r][c]) {
                return true;
            } else if (target > array[r][c]) {
                r++;
            } else {
                c--;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        int [][] arr = {{1,2,8,9}, {2,4,9,12}, {4,7,10,13}, {6,8,11,15}};
        System.out.println(new JZ04().Find(7,arr));
        System.out.println(arr.length);
        System.out.println(arr[0].length);
    }

}