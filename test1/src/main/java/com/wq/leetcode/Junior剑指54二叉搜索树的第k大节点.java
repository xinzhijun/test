package com.wq.leetcode;

public class Junior剑指54二叉搜索树的第k大节点 {
    int rs =0;
    public int kthLargest(BTree.Tree root, int k) {
        dnf(root,k);
        return rs;
    }

    void  dnf(BTree.Tree root, int k){
        if(root==null) return;
        dnf(root.right,k);
        k--;
        if(k==0) rs = root.data;
        dnf(root.left,k);
    }
}
