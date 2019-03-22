package code;

public class JZ58_1 {

    public String ReverseSentence(String str) {
        int len = str.length();
        char[] chars = str.toCharArray();
        reverse(chars, 0, len - 1);
        for (int i = 0, j = 0; j < len; j++) {
            if (chars[j] == ' ') {
                reverse(chars, i, j-1);
                i = j + 1;
            } else if (j == len - 1) {
                reverse(chars, i, j);
            }
        }
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
