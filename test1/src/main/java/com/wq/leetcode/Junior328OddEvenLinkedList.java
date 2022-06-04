package com.wq.leetcode;

public class Junior328OddEvenLinkedList {
    static class ListNode<T> {
        T val;
        ListNode next;

        ListNode(T x) {
            val = x;
        }
    }

    public static ListNode<Integer> split(ListNode<Integer> head){
        if(head==null || head.next==null){
            return head;
        }
        ListNode<Integer> evenStart = head.next;
        ListNode<Integer> event =evenStart,odd=head;
        while(event!=null && event.next!=null){
            odd.next = event.next;
            odd = odd.next;
            event.next = odd.next;
            event = event.next;
        }
        odd.next = evenStart;
        return head;
    }

    public static void main(String[] args) {
        //1->9->2->8->3->7
        ListNode<Integer> l = new ListNode<>(1);
        l.next = new ListNode<>(9);
        l.next.next = new ListNode<>(2);
        l.next.next.next = new ListNode<>(8);
        l.next.next.next.next = new ListNode<>(3);
        l.next.next.next.next.next = new ListNode<>(7);
        ListNode odd = split(l);
        System.out.println(odd);
    }
}
