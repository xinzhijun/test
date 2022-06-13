package com.wq.leetcode;

public class Junior剑指53在排序数组中查找数字出现次数 {
    public int search(int[] nums, int target) {
        int l =mid(nums,target,true);
        int r =mid(nums,target,false)-1;
        if(l<=r && r<nums.length && nums[l]==target && nums[r]==target ){
            return r-l+1;
        }
        return 0;
    }
    int mid(int[] nums,int target,boolean f){
        int l =0; int r =nums.length-1;
        int rs = nums.length;
        while(l<r){
            int mid = (l+r)/2;
            if(target<nums[mid] || f && target<=nums[mid]){
                r = mid-1;
                rs = mid;
            }else{
                l =mid+1;
            }
        }
        return rs;
    }
}
