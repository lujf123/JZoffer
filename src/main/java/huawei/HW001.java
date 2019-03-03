package huawei;

import java.util.Scanner;

public class HW001 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 是否还有其它的行，一次可以测试多行
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            System.out.println(findLastWordLength(input));
        }
    }

    public static int findLastWordLength(String input) {

        if (input == null) {
            return 0;
        }

        int len = input.length();
        char[] chars = input.toCharArray();
        int cnt = 0;

        while (len-1 >=0 &&chars[len-1] != ' ') {
            cnt++;
            len--;
        }
        return cnt;
    }

}
