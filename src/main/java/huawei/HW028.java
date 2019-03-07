package huawei;

import java.util.Scanner;

/**
 * 蛇形矩阵
 */

public class HW028 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            System.out.println(serpentineMatrix(n));
        }
        scanner.close();
    }

    private static String serpentineMatrix(int n) {
        StringBuilder builder = new StringBuilder();
        for(int i=1; i<=n; i++) {
            // 每一行的第一个元素是 (i-1)*i/2+1
            // 每一行的元素个数是 n-i
            // 初始间隔是 i+1，之后每一个间隔比上一个间隔多 1，之后的每个元素是前一个元素加上间隔
            for (int j=1, start = (i-1)*i/2+1, step = i+1; j<=n-i+1; j++, start += step, step++) {
                builder.append(start).append(' ');
            }

            // 设置换行符
            builder.setCharAt(builder.length()-1, '\n');
        }
        builder.deleteCharAt(builder.length()-1);
        return builder.toString();
    }

}
