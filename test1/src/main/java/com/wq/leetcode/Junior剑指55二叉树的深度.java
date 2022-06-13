package com.wq.leetcode;

public class Junior剑指55二叉树的深度 {
    public int maxDepth(BTree.Tree root) {
        if(root==null) return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
}
