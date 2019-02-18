package code;

public class JZ13 {

    private final static int[][] next = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    private int rows;
    private int cols;
    private int threshold;

    public int movingCount(int threshold, int rows, int cols)
    {
        boolean[][] marked = new boolean[rows][cols];
        this.rows = rows;
        this.cols = cols;
        this.threshold = threshold;
        backtracing(0, 0, marked);
        int sum = 0;
        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                if (marked[i][j] == true) {
                    sum++;
                }
            }
        }
        return sum;
    }

    private void backtracing(int r, int c, boolean[][] marked) {
        if (r < 0 || r >= rows || c < 0 || c >= cols || !judge(r, c)) {
            return;
        }
        if (marked[r][c] == true) {
            return;
        }
        marked[r][c] = true;
        for (int[] n : next) {
            backtracing(r + n[0], c + n[1], marked);
        }
    }

    private boolean judge(int r, int c) {
        char[] char_r = String.valueOf(r).toCharArray();
        char[] char_c = String.valueOf(c).toCharArray();
        int total = 0;
        for (int i = 0; i < char_r.length; i++) {
            total += char_r[i] - '0';
        }
        for (int i = 0; i < char_c.length; i++) {
            total += char_c[i] - '0';
        }
        if (total <= threshold)  {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        char c1 = '9';
        int a = c1 - '0';
        System.out.println(a);
    }

}
