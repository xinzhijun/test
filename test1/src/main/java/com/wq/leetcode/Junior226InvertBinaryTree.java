package com.wq.leetcode;

public class Junior226InvertBinaryTree {
    public void invertTree(BTree.Tree tree){
        if(tree==null){
            return;
        }
        BTree.Tree tmp = tree.left;
        tree.left = tree.right;
        tree.right = tmp;
        invertTree(tree.left);
        invertTree(tree.right);
    }

    //左右互换
    private void changeLeftRight(BTree.Tree tree){
        if(tree.left!=null&&tree.right!=null){
            BTree.Tree temp = tree.right;
            tree.right = tree.left;
            tree.left = temp;
        }

        if(tree.left!=null){
            changeLeftRight(tree.left);
        }
        if(tree.right!=null){
            changeLeftRight(tree.right);
        }
    }
}
