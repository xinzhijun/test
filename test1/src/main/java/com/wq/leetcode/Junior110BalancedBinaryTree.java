package com.wq.leetcode;

public class Junior110BalancedBinaryTree {
    public boolean isBalance(Junior94BTreeInorder.TreeNode n){
        return height(n)>=0;
    }
    public int  height(Junior94BTreeInorder.TreeNode n){
        if(n==null){
            return 0;
        }
        int left = height(n.left);
        int right = height(n.right);
        if(left==-1||right==-1||Math.abs(left-right)>1){
            return -1;
        }else{
            return Math.max(left,right)+1;
        }
    }
}
