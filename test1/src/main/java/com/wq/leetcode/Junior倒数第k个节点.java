package com.wq.leetcode;

public class Junior倒数第k个节点 {
    public Junior19RemoveNthNodeFromEndofList.ListNode getKthFromEnd(Junior19RemoveNthNodeFromEndofList.ListNode head, int k) {
        Junior19RemoveNthNodeFromEndofList.ListNode former = head, latter = head;
        for(int i = 0; i < k; i++)
            former = former.next;
        while(former != null) {
            former = former.next;
            latter = latter.next;
        }
        return latter;
    }
}
