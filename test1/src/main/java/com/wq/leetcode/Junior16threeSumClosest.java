package com.wq.leetcode;

import java.util.Arrays;

/**
 * <Description>
 *
 * @author wangqi
 * @version 1.0
 * @see com.wq.leetcode
 * @since 2019/11/19 15:18
 */
public class Junior16threeSumClosest {
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int dv = Integer.MAX_VALUE;
        int rs = Integer.MAX_VALUE;
        for(int i=0;i<nums.length-2;i++){
            int l =i+1;
            int r =nums.length-1;
            while(l<r){
                int ss =nums[i]+nums[l]+nums[r];
                if(ss>target){
                    r--;
                }else if(ss<target){

                    l++;
                }else{
                    return target;
                }
                //结果
                if(Math.abs(ss-target)<rs){
                    dv = ss;
                }
                //最小差值
                rs = Math.min(Math.abs(ss-target),rs);
            }

        }
        return dv;
    }

    public static  int threeSumClosest2(int[] nums, int target) {
        Arrays.sort(nums);

        int res = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int newSum = nums[l] + nums[r] + nums[i];
                if (Math.abs(newSum - target) < Math.abs(res - target)) {
                    res = newSum;
                }
                if (newSum > target) {
                    r--;
                } else if (newSum < target) {
                    l++;
                } else {
                    return target;
                }
            }
        }
        return res;
    }

    public static void main(String[] args){
        int[] nums = new int[]{-1, 2, 1, -4};
        System.out.println(threeSumClosest(nums,1));
    }
}
