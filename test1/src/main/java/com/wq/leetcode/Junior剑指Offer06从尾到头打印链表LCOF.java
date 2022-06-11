package com.wq.leetcode;

import java.util.Stack;

public class Junior剑指Offer06从尾到头打印链表LCOF {
    public int[] reversePrint(Junior21MergeLinkedList.ListNode<Integer> head) {
        Stack<Junior21MergeLinkedList.ListNode> stack = new Stack<>();
        Junior21MergeLinkedList.ListNode temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        int size = stack.size();
        int[] print = new int[size];
        for (int i = 0; i < size; i++) {
            print[i] = (int) stack.pop().val;
        }
        return print;
    }

}
