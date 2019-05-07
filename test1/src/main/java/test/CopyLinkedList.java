package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CopyLinkedList {
    private Node head;
    private Node last;
    class Node{
        private int value;
        private Node next;
        private Node pre;
        Node(int val,Node n,Node p){
            value =val;
            next = n;
            pre = p;
        }
    }
    public void add(int value) {
        if(head==null){
            head = new Node(value,null,null);
            last = head;
        }else{
            last.next = new Node(value,null,last);
            last = last.next;
        }
    }

    public void remove(int value) {
        Node conti = head;
        while (conti.value!=value){
            conti = conti.next;
        }
        conti.pre.next =conti.next;
        conti.next.pre = conti.pre;
        conti.pre = null;
        conti.next = null;
        conti.value =0;

    }
}
