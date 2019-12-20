package com.wq.leetcode;

import java.util.Stack;

/**
 * <Description>
 *
 * @author wangqi
 * @version 1.0
 * @see com.wq.leetcode
 * @since 2019/12/18 11:02
 */
public class Junior32LongestValidParentheses {
    public static  int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int num =0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=')'){
                stack.push(i);
                continue;
            }else{
                stack.pop();
                if(stack.empty()){
                    stack.push(i);
                }else{
                    num =Math.max(num,i-stack.peek());
                }
            }
        }
        return num;
    }
    public static void main(String[] args){
        System.out.println(longestValidParentheses("())((())"));
//        System.out.println(longestValidParentheses(")()())"));
    }
}
