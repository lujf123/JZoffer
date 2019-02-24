package code;

import java.util.Stack;

public class JZ31 {

    public boolean IsPopOrder(int [] pushA,int [] popA) {
        int n = pushA.length;
        Stack<Integer> stack = new Stack<>();
        for (int pushIndex = 0, popIndex = 0; pushIndex < n; pushIndex++) {
            stack.push(pushA[pushIndex]);
            while (popIndex < n && !stack.isEmpty() && stack.peek() == popA[popIndex]) {
                stack.pop();
                popIndex++;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Stack stack1 = new Stack();
        stack1.push(999);
        System.out.println(Integer.valueOf(999) == stack1.peek());
        System.out.println(5 == 5);
    }

}
