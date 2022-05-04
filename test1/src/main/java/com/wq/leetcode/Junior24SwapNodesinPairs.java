package com.wq.leetcode;

/**
 * <Description>
 *
 * @author wangqi
 * @version 1.0
 * @see com.wq.leetcode
 * @since 2019/12/13 11:58
 */
public class Junior24SwapNodesinPairs {
    static class ListNode {
     int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
    public  static  ListNode swapPairs(ListNode head) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode temp = pre;
        while(temp.next != null && temp.next.next != null) {
            ListNode start = temp.next;
            ListNode end = temp.next.next;
            temp.next = end;
            start.next = end.next;
            end.next = start;
            temp = start;
        }
        return pre.next;
    }

    public  static  ListNode swapPairs2(ListNode head) {
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode tmp = pre;
        while(tmp.next!=null && tmp.next.next!=null){
            ListNode start = tmp.next;
            ListNode end = tmp.next.next;
            tmp.next = end;
            start.next = end.next;
            end.next = start;
            tmp = start;
        }
        return pre.next;
    }

    public static void main(String[] args){
        ListNode s = new ListNode(1);
        s.next =new ListNode(2);
        s.next.next =new ListNode(3);
        s.next.next.next =new ListNode(4);
        ListNode  x =swapPairs2(s);
        System.out.println(x);
    }
}
