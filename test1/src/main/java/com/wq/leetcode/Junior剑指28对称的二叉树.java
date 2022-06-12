package com.wq.leetcode;

public class Junior剑指28对称的二叉树 {
    public boolean isSymmetric(BTree.Tree root) {
        return  check(root,root);
    }
    boolean check(BTree.Tree l, BTree.Tree r){
        if(l==null&& r==null){
            return true;
        }
        if(l==null || r==null){
            return false;
        }
        return  l.data==r.data&& check(l.left,r.right) && check(l.right , r.left);
    }
}
