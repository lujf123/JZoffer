package huawei;

import java.util.Scanner;

/**
 * 坐标移动
 */

public class HW016 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            System.out.println(move(input));

        }
        scanner.close();
    }

    private static String move(String input) {
        String[] steps = input.split(";");
        int[] result = new int[2];
        for (String step : steps) {
            move(step, result);
        }
        return result[0] + "," + result[1];
    }

    private static void move(String input, int[] result) {
        // 方向
        char direction = input.charAt(0);
        // 步数
        int step = Integer.parseInt(input.substring(1)); // 开始位置
        switch (direction) {
            case 'A':
                result[0] -= step;
                break;
            case 'D':
                result[0] += step;
                break;
            case 'W':
                result[1] += step;
                break;
            case 'S':
                result[1] -= step;
                break;
        }

    }

}
