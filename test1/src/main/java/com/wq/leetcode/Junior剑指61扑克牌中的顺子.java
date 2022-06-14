package com.wq.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Junior剑指61扑克牌中的顺子 {
    public boolean isStraight(int[] nums) {
        Set<Integer> s = new HashSet<>();
        int max=0,min=14;
        for(int n:nums){
            if(n==0) continue;
            if(s.contains(n)) return false;
            max = Math.max(max,n);
            min = Math.min(min,n);
            s.add(n);
        }
        return max-min<5;
    }
}
