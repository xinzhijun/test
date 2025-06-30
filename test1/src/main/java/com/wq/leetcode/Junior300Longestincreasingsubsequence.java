package com.wq.leetcode;

/**
 * @author cristiano
 * @create 2025/6/30
 */
public class Junior300Longestincreasingsubsequence {
    public static int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }
    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{10,9,2,5,3,7,101,18})); // 输出 4
        System.out.println(lengthOfLIS(new int[]{0,1,0,3,2,3}));         // 输出 4
        System.out.println(lengthOfLIS(new int[]{7,7,7,7,7,7,7}));       // 输出 1
    }

}
