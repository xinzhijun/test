package com.wq.leetcode;

/**
 * <Description>
 *
 * @author wangqi
 * @version 1.0
 * @see com.wq.leetcode
 * @since 2019/12/26 11:50
 */
public class Junior160IntersectionofTwoLinkedLists {
     static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
     }
  }
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode l = headA;
        ListNode r = headB;
        int a =0;
        int b =0;
        while(headA!=null){
            headA = headA.next;
            a++;
        }
        while(headB!=null){
            headB = headB.next;
            b++;
        }
        headA = l;
        headB = r;
        if(a>b){
            int n =a-b;
            while(n>0){
                headA = headA.next;
                n--;
            }
        }else{
            int n =b-a;
            while(n>0){
                headB = headB.next;
                n--;
            }
        }
        while(headA!=null&&headB!=null&&headA!=headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    public static ListNode merge(ListNode a, ListNode b){
        ListNode aa = a;
        ListNode bb =b;
        while(aa!=bb){
            aa = aa!=null?aa.next:b;
            bb = bb!=null?bb.next:a;
        }
        return aa;
    }

    public static void main(String[] args){
        ListNode listNode = new ListNode(4);
        listNode.next = new ListNode(1);
        listNode.next.next = new ListNode(8);
        ListNode  listNode2 = new ListNode(1);
        listNode2.next =new ListNode(4);
        listNode2.next.next = listNode.next.next;
        System.out.println(merge(listNode,listNode2));
    }
}
