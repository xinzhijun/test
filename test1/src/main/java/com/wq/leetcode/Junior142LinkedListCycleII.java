package com.wq.leetcode;

/**
 * <Description>
 *
 * @author wangqi
 * @version 1.0
 * @see com.wq.leetcode
 * @since 2019/12/26 17:22
 */
public class Junior142LinkedListCycleII {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public static ListNode detectCycle(ListNode head) {
        if(head==null||head.next==null){
            return null;
        }
        ListNode f = head;
        ListNode s = head;
        while(f!=null&&f.next!=null&&s!=null){
            f = f.next.next;
            s = s.next;
            if(f==s){
                break;
            }
        }
        if(f==null||f.next==null){
            return null;
        }
        f = head;
        while(f!=s){
            f = f.next;
            s = s.next;
        }
        return f;
    }

    public static void main(String[] args){
        ListNode listNode = new ListNode(4);
//        listNode.next = listNode;
        listNode.next = new ListNode(1);
        listNode.next.next = new ListNode(8);
//        listNode.next.next.next = listNode.next;
        System.out.println(detectCycle(listNode).val);
    }
}
