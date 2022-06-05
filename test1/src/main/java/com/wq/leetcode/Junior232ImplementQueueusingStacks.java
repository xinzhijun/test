package com.wq.leetcode;

import java.util.Stack;

public class Junior232ImplementQueueusingStacks {
    Stack<Integer> in =new Stack<>();
    Stack<Integer> out =new Stack<>();

    public void push(int x) {
        in.push(x);
    }

    public int pop() {
        if(out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop());
            }
        }
        return out.pop();
    }

    public int peek() {
        if(out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop());
            }
        }
        return out.peek();
    }

    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }
}
