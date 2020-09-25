package com.wq.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * <Description>
 *
 * @author wangqi
 * @version 1.0
 * @see com.wq.leetcode
 * @since 2020/09/25 15:14
 */
public class Junior144BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(Junior94BTreeInorder.TreeNode root) {
        LinkedList<Junior94BTreeInorder.TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }

        stack.add(root);
        while (!stack.isEmpty()) {
            Junior94BTreeInorder.TreeNode node = stack.pollLast();
            output.add(node.val);
            if (node.right != null) {
                stack.add(node.right);
            }
            if (node.left != null) {
                stack.add(node.left);
            }
        }
        return output;
    }
}
