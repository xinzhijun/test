package com.wq.leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * <Description>
 *
 * @author wangqi
 * @version 1.0
 * @see com.wq.leetcode
 * @since 2020/09/25 11:50
 */
public class Junior94BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(Junior94BTreeInorder.TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        inorder(root, res);
        return res;
    }

    public void inorder(Junior94BTreeInorder.TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }

    public List<Integer> inorderTraversal2(Junior94BTreeInorder.TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Deque<Junior94BTreeInorder.TreeNode> stk = new LinkedList<Junior94BTreeInorder.TreeNode>();
        while (root != null || !stk.isEmpty()) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }

    public static void main(String[] args){
        System.out.println(-1 & 3);
    }


}
