package com.wq.leetcode;

import java.util.HashSet;

public class Junior03数组中重复的数字 {
    public int findRepeatNumber(int[] nums) {
        HashSet<Integer> h = new HashSet<>();
        int rs =-1;
        for(int i:nums){
            if(!h.add(i)){
                rs = i;
                break;
            }
        }
        return rs;
    }
}
