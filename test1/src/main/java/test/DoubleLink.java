package test;

public class DoubleLink {
    private int value;
    private DoubleLink next;
    static DoubleLink first;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public DoubleLink getNext() {
        return next;
    }

    public void setNext(DoubleLink next) {
        this.next = next;
    }

    private static DoubleLink insert(DoubleLink root, int val) {
        if(root==null){
            root = new DoubleLink();
            root.value = val;
            first = root;
            return root;
        }
        while (root.next!= null) {
            root = root.next;
        }
        root.next = new DoubleLink();
        root.next.value = val;
        return  root;
    }

    private static void getList(DoubleLink root) {
        while (root != null) {
            System.out.println(root.value);
            root = root.next;
        }
    }

    private static DoubleLink reverseList(DoubleLink root) {
        DoubleLink rt = root;
        DoubleLink pre = null;
        DoubleLink nx;
        while (rt != null) {
            nx = rt.next;
            rt.next = pre;
            pre = rt;
            rt = nx;
        }
        return pre;
    }
    @org.junit.Test
    public  void test() {
        DoubleLink root;
       insert(first, 2);
        insert(first, 3);
        insert(first, 4);
        getList(first);
        root = reverseList(first);
        getList(root);
    }
}
