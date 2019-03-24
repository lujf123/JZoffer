package code;

import java.util.Arrays;

public class JZ61 {
    public boolean isContinuous(int [] numbers) {
        int len = numbers.length;
        if (numbers == null || len < 1) {
            return false;
        }
        Arrays.sort(numbers);
        int numOfZero = 0;
        int numOfGap = 0;
        // 统计数组中 0 的个数
        for (int i = 0; i < len && numbers[i] == 0; i++) {
            ++numOfZero;
        }
        // 统计数组中的间隔数目
        int small = numOfZero;
        int big = small + 1;
        while (big < len) {
            // 两个数相等，有对子，不可能是顺子
            if (numbers[small] == numbers[big]) {
                return false;
            }
            numOfGap += numbers[big] - numbers[small] - 1;
            small = big;
            ++big;
        }
        return (numOfGap > numOfZero) ? false : true;
    }

    public static void main(String[] args) {

    }
}
