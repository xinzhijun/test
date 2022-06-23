package com.wq.leetcode;

public class Junior数字互换 {
    public static  void change(int a,int b){
        a =a^b;
        b=a^b;
        a= a^b;
        System.out.println(a+"==="+b);
    }

    public static void main(String[] args) {
        Junior数字互换.change(5,9);
    }
}
