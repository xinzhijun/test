package com.wq.leetcode;

public class Junior34FindFirstandLastPositionofElementinSortedArray {
    public static int[] searchRange(int[] nums, int target) {
        int l =midsearch(nums,target,true);
        int r =midsearch(nums,target,false)-1;
        if(l<=r && r<nums.length && nums[l]==target&& nums[r]==target){
            return new int[]{l,r};
        }
        return  new int[]{-1,-1};
    }

    public static int midsearch(int[] nums,int target,boolean low){
        int start =0,end = nums.length-1;
        int rs = nums.length-1;
        while(start<=end){
            int mid = (start+end)/2;
            if(nums[mid]>target || (low && nums[mid]>=target)){
                end = mid-1;
                rs = mid;
            }else{
                start =mid+1;
            }
        }
        return rs;
    }

    public static void main(String[] args) {
        System.out.println(searchRange(new int[]{5,7,7,8,8,10},8));
    }
}
