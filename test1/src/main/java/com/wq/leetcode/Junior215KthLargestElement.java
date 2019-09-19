package com.wq.leetcode;

/**
 * Junior215KthLargestElement
 * Created by IntelliJ IDEA.
 *
 * @author Wang Qi
 * @version 1.0 2018/7/28 17:22
 * @see Junior215KthLargestElement
 * To change this template use File | Settings | File Templates.
 */

public class Junior215KthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        return QuickSort(nums, k, 0, nums.length - 1);
    }

    public int QuickSort(int[] nums, int k, int start, int end){
        int left = start, right = end;
        int num = nums[start];
        for (int i = end; i > start; i--){
            if (nums[i] >= num){
                swap(nums, end--, i);
            }
        }
        swap(nums, end, start);
        if (k == nums.length - end){
            return nums[end];
        } else if (k > nums.length - end){
            return QuickSort(nums, k, left, end - 1);
        } else {
            return QuickSort(nums, k, end + 1, right);
        }
    }
    public void swap(int[] nums, int a, int b){
        int num = nums[a];
        nums[a] = nums[b];
        nums[b] = num;
    }
}
