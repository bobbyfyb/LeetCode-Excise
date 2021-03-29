package algoritm.codinginterview;

import java.util.Queue;
import java.util.Stack;

/*
* 剑指offer 31. 栈的压入，弹出序列
* https://leetcode-cn.com/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof/
 */
public class StackPushPop {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> supStack = new Stack<>();
        int i = 0;
        for(int num:popped){
            if(!stack.isEmpty() && stack.peek()==num)
                stack.pop();
            else{
                while(i<pushed.length && pushed[i]!=num){
                    stack.push(pushed[i++]);
                }
                if(i==pushed.length)
                    return false;
                else
                    ++i;
            }
        }
        return true;
    }
}