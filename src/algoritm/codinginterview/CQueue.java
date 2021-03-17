package algoritm.codinginterview;
/*
* 剑指offer 09. 用两个栈实现一个队列
* https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
 */
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class CQueue {

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    public CQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        stack1.push(value);

    }

    public int deleteHead() {
        if (stack1.isEmpty())
                return -1;
        else{
            while(!stack1.isEmpty())
                stack2.push(stack1.pop());
        }
        int n=stack2.pop();
        while(!stack2.isEmpty())
            stack1.push(stack2.pop());
        return n;
    }
}
