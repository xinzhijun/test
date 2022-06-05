package com.wq.leetcode;

public class Junior136SingleNumber {
    public int singleNumber(int[] nums) {
        int s =0;
        for(int v:nums){
            s ^=v;
        }
        return s;
    }
}
