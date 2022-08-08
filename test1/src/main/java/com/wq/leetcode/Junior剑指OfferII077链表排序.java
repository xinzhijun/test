package com.wq.leetcode;

public class Junior剑指OfferII077链表排序 {
    static class ListNode{
        private int val;
        private ListNode next;
        public ListNode(int v){
            val = v;
        }
    }
    public static ListNode sort(ListNode head){
        if(head == null || head.next==null){
            return head;
        }
        ListNode slow = head,fast = head.next;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode head2 =slow.next;
        slow.next =null;
        ListNode l = sort(head);
        ListNode r = sort(head2);
        return merge(l,r);
    }

    public static ListNode merge(ListNode l,ListNode r){
        ListNode head = new ListNode(-1);
        ListNode tmp = head;
        while(l!=null && r !=null){
            if(l.val< r.val){
                tmp.next = l;
                l = l.next;
            }else{
                tmp.next = r;
                r = r.next;
            }
            tmp = tmp.next;
        }
        if(l!=null){
            tmp.next = l;
        }
        if(r!=null){
            tmp.next = r;
        }
        return  head.next;
    }

    public static void main(String[] args) {
        ListNode o = new ListNode(5);
         o.next = new ListNode(4);
        o.next.next = new ListNode(3);
        o.next.next.next = new ListNode(2);
        ListNode rs = sort(o);
        System.out.println(rs);
    }
}
