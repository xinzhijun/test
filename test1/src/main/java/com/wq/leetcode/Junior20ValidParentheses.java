package com.wq.leetcode;

import javax.xml.stream.events.Characters;
import java.util.HashMap;
import java.util.Stack;

/**
 * <Description>
 *
 * @author wangqi
 * @version 1.0
 * @see com.wq.leetcode
 * @since 2019/11/12 17:24
 */
public class Junior20ValidParentheses {
    public static boolean isValid(String s) {
        if(s.length()%2!=0){
            return false;
        }
        HashMap<Character,Character> hashMap = new HashMap<>();
        hashMap.put(')','(');
        hashMap.put(']','[');
        hashMap.put('}','{');
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(hashMap.containsKey(c)){
                Character  st  = stack.empty()?'-':stack.pop();
                if(!st.equals(hashMap.get(c))){
                    return false;
                }
            }else{
                stack.push(c);
            }
        }
        if(stack.empty()){
            return true;
        }else{
            return  false;
        }

    }

    public static  void main(String[] args){
        System.out.println(isValid("(]"));
    }
}
