package code;

public class JZ58_2 {

    public String LeftRotateString(String str,int n) {
        if (str == null || str.length() == 0 || n >= str.length()) {
            return str;
        }
        char[] chars = str.toCharArray();
        int len = chars.length - 1;
        reverse(chars, 0, len);
        reverse(chars, 0, len - n);
        reverse(chars, len - n + 1, len);
        return String.valueOf(chars);
    }

    private void reverse(char[] c, int i, int j) {
         while (i < j) {
             swap(c, i++, j--);
         }
    }

    private void swap(char[] c, int i, int j) {
        char t = c[i];
        c[i] = c[j];
        c[j] = t;
    }

}
