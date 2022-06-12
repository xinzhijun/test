package com.wq.leetcode;

public class Junior剑指18删除链表的节点LCOF {
    public Junior21MergeLinkedList.ListNode<Integer> deleteNode(Junior21MergeLinkedList.ListNode<Integer> head, int val) {
        if(head.val == val) return head.next;
        Junior21MergeLinkedList.ListNode<Integer> pre = head;
        Junior21MergeLinkedList.ListNode<Integer> cur = head.next;
        while(cur!=null && cur.val!=val){
            pre = cur;
            cur = cur.next;
        }
        pre.next = cur.next;
        return head;
    }
}
