package com.wq.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Junior剑指32从上到下打印二叉树II {
    public static ArrayList<List<Integer>> search(BTree.Tree tree) {
        ArrayDeque<BTree.Tree> queue = new ArrayDeque<>();
        if (tree != null) {
            queue.add(tree);
        }
        ArrayList<List<Integer>> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            ArrayList<Integer> list1 = new ArrayList<>();
            for (int i = 0; i < queue.size(); i++) {
                BTree.Tree tree1 = queue.poll();
                list1.add(tree1.data);
                if (tree1.left != null) {
                    queue.add(tree1.left);
                }
                if (tree1.right != null) {
                    queue.add(tree1.right);
                }
            }
            list.add(list1);
        }

        return list;
    }

}
