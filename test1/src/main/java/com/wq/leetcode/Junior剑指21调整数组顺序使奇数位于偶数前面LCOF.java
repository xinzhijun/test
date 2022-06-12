package com.wq.leetcode;

public class Junior剑指21调整数组顺序使奇数位于偶数前面LCOF {
    public static int[] exchange(int[] nums) {
        int slow=0,tmp= 0;
        for(int fast=0;fast<nums.length;fast++){
            if(nums[fast]%2 ==1){
                tmp = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = tmp;
                slow++;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        System.out.println(Junior剑指21调整数组顺序使奇数位于偶数前面LCOF.exchange(new int[]{1,2,3,4,5,6,7}));
    }
}
