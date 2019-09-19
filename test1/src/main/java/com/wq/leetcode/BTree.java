package com.wq.leetcode;

/**
 * Tree
 * Created by IntelliJ IDEA.
 *
 * @Author Wang Qi
 * @Date 2018/5/23
 * @Time: 9:36
 * @description: Tree
 * To change this template use File | Settings | File Templates.
 */

public class BTree {
    class Tree{
        int data;
        Tree left;
        Tree right;
        public Tree(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public Tree root;

    public BTree() {
        root = null;
    }



    public void insert(Tree node,int data){
        if(root ==null){
            root= new Tree(data);
        }else if(data>node.data){
            if(node.right==null){
                node.right = new Tree(data);
            }else{
                insert(node.right,data);
            }
        }else{
            if(node.left == null){
                node.left = new Tree(data);
            }else{
                insert(node.left,data);
            }
        }
    }

    public void preOrder(Tree root){
        if(root !=null){
            System.out.print(root.data+"---");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public void milOrder(Tree root){
        if(root !=null){
            preOrder(root.left);
            System.out.print(root.data+"---");
            preOrder(root.right);
        }
    }

    public void remove(int data){
        Tree current = root;
        Tree parent = root;
        //查找删除节点位置
        boolean isLeft  = false;
        while (data!=current.data){
            parent = current;
            if(data<current.data){
                isLeft =true;
                current = current.left;
            }else{
                isLeft = false;
                current = current.right;
            }
            if(current==null){
                return;
            }
        }
        //叶子节点
        if(current.left==null && current.right == null){
            if(current == root){
                root=null;
            }else if(isLeft){
                parent.left = null;
            }else{
                parent.right = null;
            }
        } //无左叶子
        else if(current.left==null){
            if(current==root){
                root = root.right;
            }else if(isLeft){
                parent.left = current.right;
            }else{
                parent.right = current.right;
            }
        }//无右叶子
        else if(current.right==null){
            if(current==root){
                root = root.left;
            }else if(isLeft){
                parent.left = current.left;
            }else{
                parent.right = current.left;
            }
        }else{//左右叶子节点都有
            Tree successor = getSuccessor(current);
            if(current == root){
                root = successor;
            }else if(isLeft){
                parent.left = successor;
            }else{
                parent.right = successor;
            }
            successor.left = current.left;
        }
    }

    private Tree getSuccessor(Tree delTree){
        Tree sucParent = null;
        Tree successor = delTree;
        Tree current = delTree.right;
        //找到右树上，最左叶子
        while(current!=null){
            sucParent = successor;
            successor = current;
            current = current.left;
        }
        //循环停止，中级后续节点被找出
        if(successor!=delTree.right){
            sucParent.left = successor.right;
            successor.right = delTree.right;
        }
        return successor;
    }

    //左右互换
    private void changeLeftRight(Tree tree){
        if(tree.left!=null&&tree.right!=null){
            Tree temp = tree.right;
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

        System.out.print("PreOrder : ");
        btree.preOrder(btree.root);
        System.out.println();

//        btree.remove(50);
        btree.changeLeftRight(btree.root);

        System.out.print("PreOrder : ");
        btree.preOrder(btree.root);
        System.out.println();

        Float f = 12.32f;
        Float f1 = 12.32f;
        System.out.println(f==f1);
    }
}
