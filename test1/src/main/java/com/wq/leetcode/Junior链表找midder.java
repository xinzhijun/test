package com.wq.leetcode;

import java.util.Stack;

public class Junior链表找midder {
    public static Junior21MergeLinkedList.ListNode<Integer> reversePrint(Junior21MergeLinkedList.ListNode<Integer> head) {
        Junior21MergeLinkedList.ListNode fast =head;
        Junior21MergeLinkedList.ListNode slow =head;
        while(fast.next!=null && fast.next.next !=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        Junior21MergeLinkedList.ListNode<Integer> head = new Junior21MergeLinkedList.ListNode<>(1);
        head.next = new Junior21MergeLinkedList.ListNode<>(2);
        head.next.next = new Junior21MergeLinkedList.ListNode<>(3);
       System.out.println(reversePrint(head));
    }
}
