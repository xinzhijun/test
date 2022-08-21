package com.wq.leetcode;

public class Junior1262GreatestSumDivisiblebyThree {
    int maxSumDivThree(int[] nums) {
        int[][] dp = new int[nums.length][3];
        for(int i = 0;i<nums.length;i++){
            if(i==0){
                if(nums[i]%3==0){
                    dp[i][0] = nums[i];
                }
                else if(nums[i]%3==1){
                    dp[i][1] = nums[i];
                }
                else if(nums[i]%3==2){
                    dp[i][2] = nums[i];
                }
            }
            else if(nums[i]%3==0){
                dp[i][0]=dp[i-1][0]+nums[i];
                dp[i][1]=dp[i-1][1]+nums[i];
                dp[i][2]=dp[i-1][2]+nums[i];
            }
            else if(nums[i]%3==1){
                //当可以整除时，要么是之前就可以整除的时候收益高，要么是现在加上nums[i]可以整除收益高
                //以下思想均相同
                dp[i][0]=Math.max(dp[i-1][0],dp[i-1][2]+nums[i]);
                dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]+nums[i]);
                dp[i][2]=Math.max(dp[i-1][2],dp[i-1][1]+nums[i]);
            }
            else if(nums[i]%3==2){
                dp[i][0]=Math.max(dp[i-1][1]+nums[i],dp[i-1][0]);
                dp[i][1]=Math.max(dp[i-1][2]+nums[i],dp[i-1][1]);
                dp[i][2]=Math.max(dp[i-1][0]+nums[i],dp[i-1][2]);
            }
        }
        return dp[nums.length-1][0];
    }

}
