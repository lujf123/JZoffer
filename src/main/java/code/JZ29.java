package code;

import java.util.ArrayList;

public class JZ29 {

    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (matrix == null) {
            return arrayList;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        boolean [][] isVisit = new boolean[row][col];
        int cnt = 1;
        int i=0, j = 0;
        isVisit[i][j] = true;
        arrayList.add(matrix[0][0]);
        int flag = 1;
        while (cnt < row * col) {
            if (flag == 1) {
                while (j+1 < col && isVisit[i][j+1] == false) {
                    j++;
                    isVisit[i][j] = true;
                    cnt++;
                    arrayList.add(matrix[i][j]);
                }
                flag = 2;
            }
            if (flag == 2) {
                while (i+1 < row && isVisit[i+1][j] == false) {
                    i++;
                    isVisit[i][j] = true;
                    cnt++;
                    arrayList.add(matrix[i][j]);
                }
                flag = 3;
            }
            if (flag == 3) {
                while (j-1 >= 0 && isVisit[i][j-1] == false) {
                    j--;
                    isVisit[i][j] = true;
                    cnt++;
                    arrayList.add(matrix[i][j]);
                }
                flag = 4;
            }
            if (flag == 4) {
                while (i-1 >= 0 && isVisit[i-1][j] == false) {
                    i--;
                    isVisit[i][j] =true;
                    cnt++;
                    arrayList.add(matrix[i][j]);
                }
                flag = 1;
            }
        }
        return arrayList;
    }


    public static void main(String[] args) {
        boolean [][] isVisit = new boolean[2][3];
        System.out.println(isVisit[0][0]);
        System.out.println(isVisit.length);
        System.out.println(isVisit[0].length);
    }
}
