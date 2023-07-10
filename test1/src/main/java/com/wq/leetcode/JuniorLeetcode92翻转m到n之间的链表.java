package com.wq.leetcode;

public class JuniorLeetcode92翻转m到n之间的链表 {
    public Junior141LinkedListCycle.ListNode reverseBetween(Junior141LinkedListCycle.ListNode head, int m, int n) {
        Junior141LinkedListCycle.ListNode dummpy = new Junior141LinkedListCycle.ListNode(-1);
        dummpy.next = head;
        Junior141LinkedListCycle.ListNode pre = dummpy;
        //输入: 1->2->3->4->5->NULL, m = 2, n = 4
        //第一轮：1->3->2->4->5->NULL
        //第二轮输出最终结果: 1->4->3->2->5->NULL
        for (int i = 0; i < m - 1; i++) {
            pre = pre.next; //pre指向节点1
        }

        Junior141LinkedListCycle.ListNode cur = pre.next;//cur指向节点2
        for (int i = m; i < n; i++) {
            Junior141LinkedListCycle.ListNode t = cur.next;//第一轮t为节点3，第二轮 t为节点4
            cur.next = t.next;//第一轮 2指向4，第二轮 2指向5
            t.next = pre.next;//第一轮 3指向2，第二轮 4指向3
            pre.next = t; //第一轮 1指向3，第二轮 1指向4
        }
        return dummpy.next;

    }


    /**
     * 翻转链表的前 n 个节点：
     * @param head
     */
    public Junior141LinkedListCycle.ListNode reverseListNode(Junior141LinkedListCycle.ListNode head,int n) {

        Junior141LinkedListCycle.ListNode dummy = new Junior141LinkedListCycle.ListNode(-1);
        dummy.next = head;
        Junior141LinkedListCycle.ListNode pre = dummy;
        Junior141LinkedListCycle.ListNode cur = pre.next;
        for (int i = 0; i < n; i++) {
            Junior141LinkedListCycle.ListNode post = cur.next;
            cur.next = post.next;
            post.next = pre.next;
            pre.next = post;
        }
        return dummy.next;
    }
}
