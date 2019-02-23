package code;

import java.util.Stack;

public class JZ30 {

    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();

    public void push(int node) {
        s1.push(node);
        if (s2.isEmpty()) {
            s2.push(node);
        } else {
            int tmp = s2.pop();
            if (tmp <= node) {
                s2.push(tmp);
                s2.push(tmp);
            } else {
                s2.push(tmp);
                s2.push(node);
            }
        }
    }

    public void pop() {
        s1.pop();
        s2.pop();
    }

    public int top() {
        return s1.peek();
    }

    public int min() {
        return s2.peek();
    }

}
