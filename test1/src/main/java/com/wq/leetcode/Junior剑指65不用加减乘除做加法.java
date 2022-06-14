package com.wq.leetcode;

public class Junior剑指65不用加减乘除做加法 {
    public static int add(int a, int b) {
        while (b!=0){
            int c = (a&b) <<1;
            a ^=b;
            b=c;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(Junior剑指65不用加减乘除做加法.add(-5,-3));
    }
}
