package com.wq.leetcode;

/**
 * <Description>
 *
 * @author wangqi
 * @version 1.0
 * @see com.wq.leetcode
 * @since 2019/09/19 14:39
 */
public class Junior4MedianofTwoSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int len = m + n;
        int left = -1, right = -1;
        int aStart = 0, bStart = 0;
        for (int i = 0; i <= len / 2; i++) {
            left = right;
            if (aStart < m && (bStart >= n || nums1[aStart] < nums2[bStart])) {
                right = nums1[aStart++];
            } else {
                right = nums2[bStart++];
            }
        }
        if ((len & 1) == 0)
            return (left + right) / 2.0;
        else
            return right;
    }

    public static void main(String[] args){
        int[] nums1 = new int[]{1,2};
        int[] nums2 = new int[]{-1,3};
        findMedianSortedArrays(nums1,nums2);
    }
}
