package com.wq.leetcode;

import java.util.Comparator;

/**
 * AvlTree
 * Created by IntelliJ IDEA.
 *
 * @author Wang Qi
 * @version 1.0 2018/6/20 10:26
 * @see AvlTree
 * To change this template use File | Settings | File Templates.
 */

public class AvlTree<T extends Comparable> {
    private AvlNode<T> root;
    private Comparator<? super T> cmp;
    /*********  AVL树节点数据结构定义   **********/
    private static class AvlNode<T>{
        T element;
        AvlNode<T> left;
        AvlNode<T> right;
        int height;
        AvlNode(T theElement){
            this(theElement, null, null);
        }
        AvlNode(T theElement, AvlNode<T> lt, AvlNode<T> rt){
            element = theElement;
            left = lt;
            right = rt;
            height = 0;
        }
    }
    public AvlTree(){
        root = null;
    }
    public void makeEmpty(){
        root = null;
    }
    public boolean isEmpty(){
        return root == null;
    }
    public void insert(T element){
        root = insert(element, root);
    }
    public boolean contains(T x){
        return contains(x, root);
    }
    public void remove(T element){
        root = remove(element, root);
    }
    private int myCompare(T lhs, T rhs){
        if(cmp != null) {
            return cmp.compare(lhs, rhs);
        } else {
            return ((Comparable) lhs).compareTo(rhs);
        }
    }
    private boolean contains(T x, AvlNode<T> t){
        //空树处理
        if(t == null){
            return false;
        }

        //正常情况处理
        //@方式一：对Comparable型的对象进行比较
        //int compareResult = x.compareTo(t.element);
        //@方式二：使用一个函数对象而不是要求这些项是Comparable的
        int compareResult = myCompare(x, t.element);
        if(compareResult < 0) {
            return contains(x, t.left);
        }else if(compareResult > 0) {
            return contains(x, t.right);
        }else {
            return true;
        }
    }
    private int height(AvlNode<T> t){
        return t == null ? -1 : t.height;
    }
    private AvlNode<T> findMin(AvlNode<T> t){
        if(t == null) {
            return null;
        }
        if(t.left == null) {
            return t;
        }
        return findMin(t.left);
    }
    private AvlNode<T> findMax(AvlNode<T> t){
        if(t == null) {
            return null;
        }
        if(t.right == null) {
            return t;
        }
        return findMax(t.right);
    }
    private AvlNode<T> insert(T x, AvlNode<T> t){
        if(t == null) {
            return new AvlNode<T>(x, null, null);
        }
        int compareResult = myCompare(x, t.element);
        if(compareResult < 0){
            t.left = insert(x, t.left);
            if(height(t.left)-height(t.right) == 2){
                if(myCompare(x, t.left.element) < 0) {    //左左情况
                    t = rotateWithLeftChild(t);
                }else {                                  //左右情况
                    t = doubleWithLeftChild(t);
                }
            }
        }else if(compareResult > 0){
            t.right = insert(x, t.right);
            if(height(t.right)-height(t.left) == 2){
                if(myCompare(x, t.right.element) < 0) {     //右左情况
                    t = doubleWithRightChild(t);
                }else {                                        //右右情况
                    t = rotateWithRightChild(t);
                }
            }
        }
        //完了之后更新height值
        t.height = Math.max(height(t.left), height(t.right))+1;
        return t;
    }
    private AvlNode<T> remove(T x, AvlNode<T> t){
        if(t == null) {
            return null;
        }
        int compareResult = myCompare(x, t.element);
        if(compareResult < 0){
            t.left = remove(x, t.left);
            //完了之后验证该子树是否平衡
            if(t.right != null){        //若右子树为空，则一定是平衡的，此时左子树相当对父节点深度最多为1, 所以只考虑右子树非空情况
                if(t.left == null){     //若左子树删除后为空，则需要判断右子树
                    if(height(t.right)-t.height == 2){
                        AvlNode<T> k = t.right;
                        if(k.right != null){        //右子树存在，按正常情况单旋转
                            System.out.println("-----------------------------------------------------------------------------11111");
                            t = rotateWithRightChild(t);
                        }else{                      //否则是右左情况，双旋转
                            System.out.println("-----------------------------------------------------------------------------22222");
                            t = doubleWithRightChild(t);
                        }
                    }
                }else{                  //否则判断左右子树的高度差
                    //左子树自身也可能不平衡，故先平衡左子树，再考虑整体
                    AvlNode<T> k = t.left;
                    //删除操作默认用右子树上最小节点补删除的节点
                    //k的左子树高度不低于k的右子树
                    if(k.right != null){
                        if(height(k.left)-height(k.right) == 2){
                            AvlNode<T> m = k.left;
                            if(m.left != null){     //左子树存在，按正常情况单旋转
                                System.out.println("-----------------------------------------------------------------------------33333");
                                k = rotateWithLeftChild(k);
                            }else{                      //否则是左右情况，双旋转
                                System.out.println("-----------------------------------------------------------------------------44444");
                                k = doubleWithLeftChild(k);
                            }
                        }
                    }else{
                        if(height(k.left) - k.height ==2){
                            AvlNode<T> m = k.left;
                            if(m.left != null){     //左子树存在，按正常情况单旋转
                                System.out.println("-----------------------------------------------------------------------------hhhhh");
                                k = rotateWithLeftChild(k);
                            }else{                      //否则是左右情况，双旋转
                                System.out.println("-----------------------------------------------------------------------------iiiii");
                                k = doubleWithLeftChild(k);
                            }
                        }
                    }
                    if(height(t.right)-height(t.left) == 2){
                        //右子树自身一定是平衡的，左右失衡的话单旋转可以解决问题
                        System.out.println("-----------------------------------------------------------------------------55555");
                        t = rotateWithRightChild(t);
                    }
                }
            }
            //完了之后更新height值
            t.height = Math.max(height(t.left), height(t.right))+1;
        }else if(compareResult > 0){
            t.right = remove(x, t.right);
            //下面验证子树是否平衡
            if(t.left != null){         //若左子树为空，则一定是平衡的，此时右子树相当对父节点深度最多为1
                if(t.right == null){        //若右子树删除后为空，则只需判断左子树
                    if(height(t.left)-t.height ==2){
                        AvlNode<T> k = t.left;
                        if(k.left != null){
                            System.out.println("-----------------------------------------------------------------------------66666");
                            t = rotateWithLeftChild(t);
                        }else{
                            System.out.println("-----------------------------------------------------------------------------77777");
                            t = doubleWithLeftChild(t);
                        }
                    }
                }else{              //若右子树删除后非空，则判断左右子树的高度差
                    //右子树自身也可能不平衡，故先平衡右子树，再考虑整体
                    AvlNode<T> k = t.right;
                    //删除操作默认用右子树上最小节点（靠左）补删除的节点
                    //k的右子树高度不低于k的左子树
                    if(k.left != null){
                        if(height(k.right)-height(k.left) == 2){
                            AvlNode<T> m = k.right;
                            if(m.right != null){        //右子树存在，按正常情况单旋转
                                System.out.println("-----------------------------------------------------------------------------88888");
                                k = rotateWithRightChild(k);
                            }else{                      //否则是右左情况，双旋转
                                System.out.println("-----------------------------------------------------------------------------99999");
                                k = doubleWithRightChild(k);
                            }
                        }
                    }else{
                        if(height(k.right)-k.height == 2){
                            AvlNode<T> m = k.right;
                            if(m.right != null){        //右子树存在，按正常情况单旋转
                                System.out.println("-----------------------------------------------------------------------------aaaaa");
                                k = rotateWithRightChild(k);
                            }else{                      //否则是右左情况，双旋转
                                System.out.println("-----------------------------------------------------------------------------bbbbb");
                                k = doubleWithRightChild(k);
                            }
                        }
                    }
                    if(height(t.left) - height(t.right) == 2){
                        //左子树自身一定是平衡的，左右失衡的话单旋转可以解决问题
                        System.out.println("-----------------------------------------------------------------------------ccccc");
                        t = rotateWithLeftChild(t);
                    }
                }
            }
            //完了之后更新height值
            t.height = Math.max(height(t.left), height(t.right))+1;
        }else if(t.left != null && t.right != null){
            //默认用其右子树的最小数据代替该节点的数据并递归的删除那个节点
            t.element = findMin(t.right).element;
            t.right = remove(t.element, t.right);
            if(t.right == null){        //若右子树删除后为空，则只需判断左子树与根的高度差
                if(height(t.left)-t.height ==2){
                    AvlNode<T> k = t.left;
                    if(k.left != null){
                        System.out.println("-----------------------------------------------------------------------------ddddd");
                        t = rotateWithLeftChild(t);
                    }else{
                        System.out.println("-----------------------------------------------------------------------------eeeee");
                        t = doubleWithLeftChild(t);
                    }
                }
            }else{              //若右子树删除后非空，则判断左右子树的高度差
                //右子树自身也可能不平衡，故先平衡右子树，再考虑整体
                AvlNode<T> k = t.right;
                //删除操作默认用右子树上最小节点（靠左）补删除的节点

                if(k.left != null){
                    if(height(k.right)-height(k.left) == 2){
                        AvlNode<T> m = k.right;
                        if(m.right != null){        //右子树存在，按正常情况单旋转
                            System.out.println("-----------------------------------------------------------------------------fffff");
                            k = rotateWithRightChild(k);
                        }else{                      //否则是右左情况，双旋转
                            System.out.println("-----------------------------------------------------------------------------ggggg");
                            k = doubleWithRightChild(k);
                        }
                    }
                }else{
                    if(height(k.right)-k.height == 2){
                        AvlNode<T> m = k.right;
                        if(m.right != null){        //右子树存在，按正常情况单旋转
                            System.out.println("-----------------------------------------------------------------------------hhhhh");
                            k = rotateWithRightChild(k);
                        }else{                      //否则是右左情况，双旋转
                            System.out.println("-----------------------------------------------------------------------------iiiii");
                            k = doubleWithRightChild(k);
                        }
                    }
                }
                //左子树自身一定是平衡的，左右失衡的话单旋转可以解决问题
                if(height(t.left) - height(t.right) == 2){
                    System.out.println("-----------------------------------------------------------------------------jjjjj");
                    t = rotateWithLeftChild(t);
                }
            }
            //完了之后更新height值
            t.height = Math.max(height(t.left), height(t.right))+1;
        }else{
            System.out.println("-----------------------------------------------------------------------------kkkkk");
            t = (t.left != null)?t.left:t.right;
        }
        return t;
    }
    //左左情况单旋转
    private AvlNode<T> rotateWithLeftChild(AvlNode<T> k2){
        AvlNode<T> k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
        k1.height = Math.max(height(k1.left), k2.height) + 1;
        return k1;      //返回新的根
    }
    //右右情况单旋转
    private AvlNode<T> rotateWithRightChild(AvlNode<T> k2){
        AvlNode<T> k1 = k2.right;
        k2.right = k1.left;
        k1.left = k2;
        k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
        k1.height = Math.max(height(k1.right), k2.height) + 1;
        return k1;      //返回新的根
    }
    //左右情况
    private AvlNode<T> doubleWithLeftChild(AvlNode<T> k3){
        try{
            k3.left = rotateWithRightChild(k3.left);
        }catch(NullPointerException e){
            System.out.println("k.left.right为："+k3.left.right);
            throw e;
        }
        return rotateWithLeftChild(k3);
    }
    //右左情况
    private AvlNode<T> doubleWithRightChild(AvlNode<T> k3){
        try{
            k3.right = rotateWithLeftChild(k3.right);
        }catch(NullPointerException e){
            System.out.println("k.right.left为："+k3.right.left);
            throw e;
        }
        return rotateWithRightChild(k3);
    }
}
