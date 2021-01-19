package boot.spring.suanfa;

import java.util.Stack;

/**
 * @program: SSM
 * @description:
 * @author: Hatake
 * @create: 2020-12-28 21:17
 **/
public class StackToQueue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(stack2.empty()){
            while(!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
