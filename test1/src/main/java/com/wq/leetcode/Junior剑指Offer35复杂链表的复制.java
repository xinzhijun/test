package com.wq.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Junior剑指Offer35复杂链表的复制 {
    static class Node{
        private int val;
        private Node next;
        private Node random;
        public Node(int va){
            val =va;
        }
    }
    static Map<Node,Node> map = new HashMap<>();
    public static  Node copy(Node head){
        if(head == null){
            return null;
        }
        if(!map.containsKey(head)){
            Node newN = new Node(head.val);
            map.put(head,newN);
            newN.next = copy(head.next);
            newN.random = copy(head.random);
        }
        return map.get(head);
    }

    public static void main(String[] args) {
        Node o = new Node(1);
        o.random = new Node(3);
        o.next = new Node(2);
        o.next.random = new Node(1);
        o.next.next = new Node(3);
        o.next.next.random = new Node(2);

        Node ss =copy(o);
        System.out.println(ss);
    }
}
