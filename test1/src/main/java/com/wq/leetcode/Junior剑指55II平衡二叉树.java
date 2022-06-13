package com.wq.leetcode;

public class Junior剑指55II平衡二叉树 {
    public boolean isBalanced(BTree.Tree root) {
        return height(root)>=0;
    }
    int height(BTree.Tree root){
        if(root==null) return 0;
        int l = height(root.left);
        int r = height(root.right);
        if(l==-1||r==-1|| Math.abs(l-r)>1){
            return -1;
        }else{
          return   Math.max(l,r)+1;
        }
    }
}
