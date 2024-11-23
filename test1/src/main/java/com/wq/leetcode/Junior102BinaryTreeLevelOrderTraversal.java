package com.wq.leetcode;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

public class Junior102BinaryTreeLevelOrderTraversal {
    public static ArrayList<List<Integer>> search(BTree.Tree tree){
        Queue<BTree.Tree> queue = new ArrayDeque();
        if(tree!=null){
            queue.add(tree);
        }
        ArrayList<List<Integer>> list = new ArrayList<>();
        while(!queue.isEmpty()){
            ArrayList<Integer> list1 = new ArrayList<>();
            for(int i=0;i<queue.size();i++){
                BTree.Tree  tree1 = queue.poll();
                list1.add(tree1.data);
                if(tree1.left!=null){
                    queue.add(tree1.left);
                }
                if(tree1.right!=null){
                    queue.add(tree1.right);
                }
            }
            list.add(list1);
        }

      return   list;
    }

    public static List<List<Integer>> search2(BTree.Tree tree){
        Queue<BTree.Tree> arrayDeque = new LinkedBlockingQueue<>();
        arrayDeque.add(tree);
        ArrayList<List<Integer>> list2 = new ArrayList<>();
        while(!arrayDeque.isEmpty()){
            int size = arrayDeque.size();
            ArrayList<Integer> list = new ArrayList<>();
            for(int i=0;i<size;i++){
                BTree.Tree t = arrayDeque.poll();
                list.add(t.data);
                if(t.left!=null){
                    arrayDeque.offer(t.left);
                }
                if(t.right!=null){
                    arrayDeque.offer(t.right);
                }

            }
            list2.add(list);
        }
        return list2;
    }

    class Tree{
        int data;
        Tree left;
        Tree right;
    }

    public static List<List> bfs(BTree.Tree tree){
        ArrayDeque<BTree.Tree> q = new ArrayDeque<>();
        q.add(tree);
        List<List> rs = new ArrayList<>();
        while(q.size()>0){
            int size = q.size();
            ArrayList<Integer> list =new ArrayList<>();
            for(int i=0;i<size;i++){
                BTree.Tree t;
                if(rs.size()%2==0 && rs.size()!=0){
                    t = q.pollLast();
                }else{
                    t = q.poll();
                }

                list.add(t.data);
                if(t.left!=null){
                    q.add(t.left);
                }
                if(t.right!=null){
                    q.add(t.right);
                }
            }
            rs.add(list);

        }
        return rs;
    }

    public static void main(String[] args){
        BTree b = new BTree();
        BTree.Tree tree = new BTree.Tree(3);
        b.insert(tree,1);
        b.insert(tree,4);
        b.insert(tree,3);
        b.insert(tree,1);
        b.insert(tree,5);
        System.out.print(bfs(tree));
    }
}
