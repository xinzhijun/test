package com.wq.leetcode;

import java.util.Stack;

/**
 * <Description>
 *
 * @author wangqi
 * @version 1.0
 * @see com.wq.leetcode
 * @since 2019/12/18 11:02
 */
public class Junior33SearchinRotatedSortedArray {
    public int search(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        int mid =0;
        while (i < j) {
            mid = (i + j) / 2;
            if ((nums[0] > target) ^ (nums[0] > nums[mid]) ^ (target > nums[mid]))
                i = mid + 1;
            else
                j = mid;
        }
        return i == j && nums[i] == target ? i : -1;
    }

    public int search2(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            //前半部分有序,注意此处用小于等于
            if (nums[start] <= nums[mid]) {
                //target在前半部分
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target <= nums[end] && target > nums[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

        }
        return -1;

    }
    public static void main(String[] args){
//        System.out.println(longestValidParentheses("())((())"));
//        System.out.println(longestValidParentheses(")()())"));
    }
}
