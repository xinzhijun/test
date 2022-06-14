package com.wq.leetcode;

public class Junior剑指62圆圈中最后剩下的数字 {
    public static int lastRemaining(int n, int m) {
        int rs =0;
        for(int i=2;i<=n;i++){
            rs = (m+rs)%i;
        }
        return rs;
    }

    public static void main(String[] args) {
        System.out.println(Junior剑指62圆圈中最后剩下的数字.lastRemaining(5,3));
    }
}
