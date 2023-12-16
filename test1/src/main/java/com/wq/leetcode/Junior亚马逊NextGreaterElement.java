package com.wq.leetcode;

import java.util.Stack;

public class Junior亚马逊NextGreaterElement {
    public int[] vertArray(int[] list){
        int[] rs = new int[list.length];
        rs[list.length-1] =-1;
        Stack stack = new Stack();
        stack.push(list[list.length-1]);
        for(int i=list.length-2;i>=0;i--){
            boolean find =false;
            int j = i+2;
            while(!stack.isEmpty()){
                int p = (int) stack.peek();
                if(p>list[i]){
                    rs[i] = list[j];
                    find =true;
                }else{
                    stack.pop();
                }

            }
            if(!find){
                rs[i] = -1;
            }
            stack.push(list[i]);
        }
        return rs;
    }
}
