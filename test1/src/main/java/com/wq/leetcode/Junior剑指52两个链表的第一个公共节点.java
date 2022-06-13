package com.wq.leetcode;

public class Junior剑指52两个链表的第一个公共节点 {
    public Junior141LinkedListCycle.ListNode getIntersectionNode(Junior141LinkedListCycle.ListNode headA, Junior141LinkedListCycle.ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        Junior141LinkedListCycle.ListNode l =headA,r=headB;
        while(l!=r){
            l = l==null?headB:l.next;
            r = r==null?headA:r.next;
        }
        return l;
    }
}
