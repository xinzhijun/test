package com.wq.leetcode;

/**
 * <Description>
 *
 * @author wangqi
 * @version 1.0
 * @see com.wq.leetcode
 * @since 2019/11/20 12:42
 */
public class Junior19RemoveNthNodeFromEndofList {
     static class ListNode {
    int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }
    public static  ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first =head;
        ListNode h =head;
        int i=0;
        while(head.next!=null){
            head = head.next;
            if(i++>=n){
                h = h.next;
            }
        }
        if(i+1==n){
            return first.next;
        }
        h.next =h.next.next;
        return first;
    }
    public  static  void main(String[] args){
        ListNode head = new ListNode(1);
        head.next =new ListNode(2);
        head.next.next =new ListNode(3);
        head.next.next.next =new ListNode(4);
        head.next.next.next.next =new ListNode(5);
        ListNode s = removeNthFromEnd(head, 1);
        while (s!=null){
            System.out.println(s.val);
            s = s.next;
        }

    }
}
