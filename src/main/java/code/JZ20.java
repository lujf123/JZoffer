package code;

public class JZ20 {
    public boolean isNumeric(char[] str) {
        if (str == null || str.length == 0) {
            return false;
        }
        int start = 0;
        if (str[0] == '+' || str[0] == '-') {
            start++;
        }
        boolean flag = true;
        boolean eflag = false;
        int i = start;
        for (; i < str.length; i++) {
            if (str[i] >= '0' && str[i] <= '9') {
                continue;
            }
            if (str[i] == 'e' || str[i] == 'E') {
                eflag = true;
                i++;
                if (i == str.length) {
                    return false;
                }
                break;
            }
            if (str[i] == '.') {
                i++;
                break;
            }
            flag = false;
            break;
        }
        return false;
    }
}
