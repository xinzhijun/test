package com.wq.leetcode;

public class Junior68二叉树的最近公共祖先LCOF {
    public static BTree.Tree lowestCommonAncestor(BTree.Tree root, BTree.Tree p, BTree.Tree q) {
        if(root == null || root == p || root == q) return root;
        BTree.Tree left = lowestCommonAncestor(root.left, p, q);
        BTree.Tree right = lowestCommonAncestor(root.right, p, q);
        if(left == null) return right;
        if(right == null) return left;
        return root;
    }

    public static void main(String[] args){
        BTree btree = new BTree();
        btree.insert(btree.root,8);
        btree.insert(btree.root,50);
        btree.insert(btree.root,45);
        btree.insert(btree.root,21);
        btree.insert(btree.root,32);
        btree.insert(btree.root,18);
        btree.insert(btree.root,37);
        btree.insert(btree.root,64);
        btree.insert(btree.root,88);
        btree.insert(btree.root,5);
        btree.insert(btree.root,4);
        btree.insert(btree.root,7);
        btree.insert(btree.root,55);
        btree.insert(btree.root,51);
        btree.insert(btree.root,56);
        btree.insert(btree.root,54);

        BTree.Tree b = new BTree.Tree(5);
        BTree.Tree c = new BTree.Tree(4);
        BTree.Tree t =lowestCommonAncestor(btree.root,b,c);
        System.out.println(t);

    }

}
