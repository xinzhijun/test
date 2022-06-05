package com.wq.leetcode;

public class Junior206ReverseLinkedList {
    public Junior21MergeTwoSortedLists.ListNode revers(Junior21MergeTwoSortedLists.ListNode root){
        Junior21MergeTwoSortedLists.ListNode r =root;
        Junior21MergeTwoSortedLists.ListNode pre =null;
        Junior21MergeTwoSortedLists.ListNode nx;
        while (r!=null){
            nx= r.next;
            r.next =pre;
            pre =r;
            r= nx;
        }
        return pre;
    }
}
