package com.wq.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Junior94BTreeInorder
 * Created by IntelliJ IDEA.
 *
 * @author Wang Qi
 * @version 1.0 2018/7/28 17:22
 * @see Junior94BTreeInorder
 * To change this template use File | Settings | File Templates.
 */

public class Junior94BTreeInorder {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                list.add(cur.val);
                cur = cur.right;
            }
        }
        return list;
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        get(root,list);
        return list;
    }

    void get(TreeNode treeNode,List list){
        if(treeNode!=null){
            if(treeNode.left!=null){
                get(treeNode.left,list);
            }
            list.add(treeNode.val);
            if(treeNode.right!=null){
                get(treeNode.right,list);
            }
        }
    }

    public class TreeNode{
        public TreeNode left;
        public TreeNode right;
        public int val;
    }
}
