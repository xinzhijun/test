package com.wq.leetcode;

public class Junior剑指39数组中出现次数超过一半的数字 {
    public static int majorityElement(int[] nums) {
        int x =0;int votes =0;
        for(int i=0;i<nums.length;i++){
            if(votes==0) x =nums[i];
            votes +=nums[i]==x?1:-1;
        }
        return x;
    }

    public static void main(String[] args) {
        System.out.println(Junior剑指39数组中出现次数超过一半的数字.majorityElement(new int[]{1,4,3,2,2,5,5,4,5}));
    }
}
