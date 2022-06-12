package com.wq.leetcode;

import javax.swing.tree.TreeNode;

public class Junior剑指27二叉树的镜像 {
    public BTree.Tree mirrorTree(BTree.Tree root) {
            if(root==null){
                return null;
            }
            BTree.Tree left = mirrorTree(root.left);
            BTree.Tree right = mirrorTree(root.right);
            root.left =right;
            root.right  =left;
            return root;
    }
}
