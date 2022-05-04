package com.wq.leetcode;

public class Junior53MaximumSubarray {
    public static int maxSubArray(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int max = -10000;
        int sum =0;
        for(int i=0;i<nums.length;i++){
            if(sum>0){
                sum += nums[i];
            }else{
                sum =nums[i];
            }
            max = Math.max(sum,max);

        }
        return max;
    }

    public static void main(String[] args) {
       int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        nums = new int[]{-2,-1};
        System.out.println(maxSubArray(nums));
    }
}
