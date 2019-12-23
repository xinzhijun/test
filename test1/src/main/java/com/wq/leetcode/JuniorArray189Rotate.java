package com.wq.leetcode;

/**
 * JuniorArray3_Rotate
 * Created by IntelliJ IDEA.
 *
 * @author Wang Qi
 * @version 1.0 2018/6/4 19:16
 * @see JuniorArray189Rotate
 * To change this template use File | Settings | File Templates.
 */

public class JuniorArray189Rotate {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        rotate2(nums, k);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
        }
    }

    public static void rotate(int[] nums, int k) {
        if (k >= nums.length) {
            k = k - nums.length;
        }
        for (int j = 0; j < k; j++) {
            int temp = nums[nums.length - 1];
            for (int i = nums.length - 1; i > 0; i--) {
                nums[i] = nums[i - 1];
            }
            nums[0] = temp;
        }
    }

    public static void rotate2(int[] nums, int k) {
        k= k%nums.length;
        if(nums.length>1){
            reverse(nums,0,nums.length-1);
            reverse(nums,0,k-1);
            reverse(nums,k,nums.length-1);
        }

    }

    static void reverse(int[] nums,int start,int end){
        while(start<end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

}
