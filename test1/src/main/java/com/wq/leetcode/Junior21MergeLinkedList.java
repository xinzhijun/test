package com.wq.leetcode;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.LinkedList;

/**
 * <Description>
 *
 * @author wangqi
 * @version 1.0
 * @see com.wq.leetcode
 * @since 2019/11/15 16:59
 */
public class Junior21MergeLinkedList {
    static class ListNode<T> {
        T val;
        ListNode next;

        ListNode(T x) {
            val = x;
        }
    }

    public static ListNode split(ListNode<Integer> head) {
        ListNode evenHead = head.next;
        ListNode odd = head, even = evenHead;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = null;
        evenHead = reverse(evenHead);
        return merge2(head, evenHead);
    }

    public static ListNode merge2(ListNode<Integer> l, ListNode<Integer> r) {
        if (l == null) {
            return r;
        }
        if (r == null) {
            return l;
        }
        if (l.val < r.val) {
            l.next = merge2(l.next, r);
            return l;
        } else {
            r.next = merge2(l, r.next);
            return r;
        }
    }

    public static ListNode reverse(ListNode<Integer> list) {
        ListNode<Integer> r = list;
        ListNode<Integer> pre = null;
        ListNode<Integer> nx;
        while (r != null) {
            nx = r.next;
            r.next = pre;
            pre = r;
            r = nx;
        }
        return pre;
    }

    public static void main(String[] args) {
        //1->9->2->8->3->7
        ListNode<Integer> l = new ListNode<>(1);
        l.next = new ListNode<>(9);
        l.next.next = new ListNode<>(2);
        l.next.next.next = new ListNode<>(8);
        l.next.next.next.next = new ListNode<>(3);
        l.next.next.next.next.next = new ListNode<>(7);
        ListNode odd = split(l);
        System.out.println(odd);
    }
}
