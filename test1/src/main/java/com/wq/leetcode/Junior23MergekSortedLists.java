package com.wq.leetcode;

/**
 * <Description>
 *
 * @author wangqi
 * @version 1.0
 * @see com.wq.leetcode
 * @since 2019/11/21 18:11
 */
public class Junior23MergekSortedLists {
    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode[] l = new ListNode[1];
        int length = lists.length;
        compare(l,lists,length);
        return l[0];
    }

    public  static void compare(ListNode[] l,ListNode[] lists,int length){
        if(length>0){
            int num =0;
            for(int i=1;i<lists.length;i++){
                if(lists[i].val<lists[0].val){
                    num =i;
                }
            }
            if(l[0]==null){
                l[0] = new ListNode(lists[num].val);
            }else{
                l[0].next =  lists[num];
            }
            if(lists[num].next!=null){
                lists[num] = lists[num].next;
            } else{
                length--;
            }
            compare(l,lists,length);
        }
    }

    public static void main(String[] args){
        ListNode[] ll = new ListNode[10];
        ListNode listNode = new ListNode(1);
        listNode.next =new ListNode(4);
        listNode.next =new ListNode(5);
        ll[0] =listNode;
        ListNode s = mergeKLists(ll);
    }
}
