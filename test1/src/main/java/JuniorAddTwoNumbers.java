/**
 * JuniorAddTwoNumbers
 * Created by IntelliJ IDEA.
 *
 * @author Wang Qi
 * @version 1.0 2018/7/16 18:08
 * @see JuniorAddTwoNumbers
 * To change this template use File | Settings | File Templates.
 */

public class JuniorAddTwoNumbers {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newList = null;
        ListNode nextList = null;
        int mod = 0;
        while (l1 != null || l2 != null || mod > 0) {
            boolean l1Status = l1 == null ? false : true;
            boolean l2Status = l2 == null ? false : true;
            int i = (!l1Status ? 0 : l1.val) + (!l2Status ? 0 : l2.val) + mod;
            int j = i % 10;
            if (newList == null) {
                newList = new ListNode(j);
                nextList = newList;
            } else {
                nextList.next = new ListNode(j);
                nextList = nextList.next;
            }
            mod = i / 10;
            l1 = l1Status ? l1.next : null;
            l2 = l2Status ? l2.next : null;
        }
        return newList;

    }

    public static void main(String[] args) {
        int i = 1;
        int j = 90;
        System.out.println(i & j);
    }
}
