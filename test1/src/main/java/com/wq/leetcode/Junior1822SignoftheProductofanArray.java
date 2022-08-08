package com.wq.leetcode;

public class Junior1822SignoftheProductofanArray {
    public static int sign(int[] s){
        int res =1;
        for(int ss:s){
            if(ss==0) return 0;
            if(ss<0) res *=-1;
        }
        return res;
    }
}
