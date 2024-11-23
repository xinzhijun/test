public class Test {
    static class LinkNode{
        private int val;
        private LinkNode next;
    }


    public static  LinkNode verseLinkNode(LinkNode root){
        LinkNode r = root;
        LinkNode pre =null;
        LinkNode nt;
        while(r!=null){
            nt  =r.next;
            r.next = pre;
            pre = r;
            r = nt;
        }
        return pre;
    }
    public static LinkNode remove(int k,LinkNode root){
        LinkNode fast = root;
        LinkNode slow = root;
        for(int i=0;i<k;i++){
            fast =fast.next;
        }
        while(fast!=null){
            fast =fast.next;
            slow  =slow.next;
        }
        slow.next = slow.next.next;
        return root;
    }

    public static void main(String[] args) {
        LinkNode r = new LinkNode();
        r.val=1;
        r.next = new LinkNode();
        r.next.val =2;
        r.next.next = new LinkNode();
        r.next.next.val =3;
        r.next.next.next = new LinkNode();
        r.next.next.next .val =4;
//        LinkNode rs = verseLinkNode(r);
//        while(rs!=null){
//            System.out.println(rs.val);
//            rs =rs.next;
//        }

        LinkNode rs2 =  remove(2,r);
        while(rs2!=null){
            System.out.println(rs2.val);
            rs2 =rs2.next;
        }
    }
}
