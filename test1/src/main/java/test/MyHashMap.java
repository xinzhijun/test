package test;

/**
 * Created by Administrator on 2022/1/22.
 */
public class MyHashMap {
    /**
     * 默认容量为16
     */
    private static final int DEFAULT_CAPACITY = 1 << 4;
    /**
     * 内部存储结构
     */
    Node[] table = new Node[DEFAULT_CAPACITY];
    /**
     * 长度
     */
    private int size;

    static class Node {
       public  Node(int h,int k,int val){
            hash =h;
            key =k;
            value =val;
        }
        /**
         * hash值
         */
        int hash;
        /**
         * key
         */
        int key;
        /**
         * value
         */
        int value;
        /**
         * 指向下个节点（单链表）
         */
        Node next;


    }

    public Object get(int key) {
        int hashValue = key%DEFAULT_CAPACITY;
        for (Node node = table[hashValue]; node != null; node = node.next) {
            if (node.key ==key && hashValue == node.hash) {
                return node.value;
            }
        }
        return null;
    }

    public Object put(int key, int value) {
        /**通过key获取hash值
         * */
        int hashValue = key%DEFAULT_CAPACITY;
        Node pre = null;
        for (Node node = table[hashValue]; node != null; node = node.next) {
            pre = node;
            if (node.hash == hashValue && (node.key == key)) {
                int oldValue = node.value;
                node.value = value;
                return oldValue;
            }
        }
        /**
         * 如果i位置没有数据，或者i位置有数据但是key是新的key，新增节点
         */
        pre.next = new Node(hashValue, key, value);
        return null;
    }


}
