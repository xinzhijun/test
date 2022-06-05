package com.wq.leetcode;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

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

    public static void main(String[] args){
        BTree btree = new BTree();
        btree.insert(btree.root,8);
        btree.insert(btree.root,50);
        btree.insert(btree.root,45);


        System.out.print(search(btree.root));
    }
}
