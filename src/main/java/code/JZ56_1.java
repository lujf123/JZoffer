package code;

//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果

public class JZ56_1 {
    public void FindNumsAppearOnce(int [] nums,int num1[] , int num2[]) {
        int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }
        diff &= -diff;  // 得出最右侧不为0的位
        for (int num : nums) {
            if ((num & diff) == 0) {
                num1[0] ^= num;
            } else {
                num2[0] ^= num;
            }
        }
    }
}
