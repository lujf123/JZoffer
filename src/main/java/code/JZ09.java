package code;

import java.util.Stack;

/**
 * 完成在队列尾部插入节点和在队列头部删除节点（先进先出）
 *
 */

public class JZ09 {

    Stack<Integer> in = new Stack<Integer>();
    Stack<Integer> out = new Stack<Integer>();

    public void push(int node) {
        in.push(node);
    }

    public int pop() throws Exception {
       if (out.isEmpty()) {
           while (!in.isEmpty()) {
               out.push(in.pop());
           }
       }
       if (out.isEmpty()) {
           throw new Exception("queue is empty");
       }
       return out.pop();
    }


}
