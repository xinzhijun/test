package com.wq.leetcode;

public class Junior1448CountGoodNodesinBinaryTree {
   static int rs =0;
    public static int longNode(BTree.Tree tree){
        if(tree==null){
            return 0;
        }
        dfs(tree,tree.data);
        return rs;
    }

    static void dfs(BTree.Tree t,int max){
        if(t==null) return;
        if(t.data>=max){
            rs++;
            max = t.data;
        }
        dfs(t.left,max);
        dfs(t.right,max);
    }

    public static void main(String[] args) {
        BTree b = new BTree();
        BTree.Tree tree = new BTree.Tree(3);
        b.insert(tree,1);
        b.insert(tree,4);
        b.insert(tree,3);
        b.insert(tree,1);
        b.insert(tree,5);
        longNode(tree);
    }
}
