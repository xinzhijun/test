package com.wq.leetcode;

public class Junior链表m到n反转reverseBetween {
    public Junior141LinkedListCycle.ListNode reverseBetween(Junior141LinkedListCycle.ListNode head, int m, int n) {
        if (head == null || m >= n) {
            return head;
        }

        // 创建虚拟头结点，避免对原头结点特殊处理
        Junior141LinkedListCycle.ListNode dummy = new Junior141LinkedListCycle.ListNode(0);
        dummy.next = head;

        // 找到m节点的前一个节点
        Junior141LinkedListCycle.ListNode preM = dummy;
        for (int i = 1; i < m; i++) {
            if (preM == null) {
                return head;
            }
            preM = preM.next;
        }

        // 找到n节点
        Junior141LinkedListCycle.ListNode curN = preM.next;
        for (int i = m; i < n; i++) {
            if (curN == null) {
                return head;
            }
            curN = curN.next;
        }

        // 反转[m, n]区间的链表
        Junior141LinkedListCycle.ListNode prev = null, cur = preM.next;
        while (cur != curN) {
            Junior141LinkedListCycle.ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        // 把[m, n]区间反转后的链表拼接回去
        preM.next.next = cur;
        preM.next = prev;

        return dummy.next;
    }
}
