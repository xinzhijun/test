package com.wq.leetcode;

/**
 * Junior23mergeKLists
 * Created by IntelliJ IDEA.
 *
 * @author Wang Qi
 * @version 1.0 2018/8/21 17:51
 * @see Junior23mergeKLists
 * To change this template use File | Settings | File Templates.
 */

public class Junior23mergeKLists {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0) return null;
        ListNode tail = lists[0];
        ListNode head = lists[0];
        while(tail.val>lists[1].val){
            if(tail.val==head.val){
                ListNode temp = head;
                head = lists[1];
                head.next =temp;
            }
            lists[1] =lists[1].next;
        }
        return null;
    }
}
