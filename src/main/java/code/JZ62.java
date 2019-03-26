package code;

import java.util.LinkedList;

public class JZ62 {

    public static int LastRemaining_Solution(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }
        int[] arr = new int[n];
        int cnt = n, c = 1, index = 0;
        while (cnt != 1) {
            if (arr[index] == 0) {
                // 删除
                if (c == m) {
                    arr[index] = 1;
                    cnt--;
                    // 下一个 index
                    if (index == n) {
                        for (int i = 0; i < n; i++) {
                            if (arr[i] == 0) {
                                index = i;
                                c = 1;
                                break;
                            }
                        }
                    } else {
                        c = 1;
                        if (++index == n) {
                            index = 0;
                        }
                    }
                } else {
                    c++;
                    if (++index == n) {
                        index = 0;
                    }
                }
            } else {
                if (++index == n) {
                    index = 0;
                }
                continue;
            }
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                index = i;
                break;
            }
        }
        return index;
    }

    public static int LastRemaining_Solution1(int n, int m) {
        if (n < 1 ||  m < 1) {
            return -1;
        }
        int last = 0;
        for (int i = 2; i <= n; i++) {
            last = (last + m) % i;
        }
        return last;
    }
    public static void main(String[] args) {
        System.out.println(LastRemaining_Solution1(5, 3));
    }
}
