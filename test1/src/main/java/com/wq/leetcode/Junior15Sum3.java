package com.wq.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <Description>
 *
 * @author wangqi
 * @version 1.0
 * @see com.wq.leetcode
 * @since 2019/11/08 17:22
 */
public class Junior15Sum3 {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++) {
            if (nums[i] > 0) {
                return list;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                if (nums[i] + nums[l] + nums[r] > 0) {
                    r--;
                } else if (nums[i] + nums[l] + nums[r] < 0){
                    l++;
                }else{
                    List<Integer> ls = new ArrayList<>(3);
                    ls.add(nums[i]);
                    ls.add(nums[l]);
                    ls.add(nums[r]);
                    list.add(ls);
                    l++;
                    r--;
                    while (l < r && nums[l]==nums[l-1]) {
                        l++;
                    }
                    while (r > l && nums[r]==nums[r+1]) {
                        r--;
                    }
                }
            }

        }
        return list;
    }
    public static void main(String[] args){
//        int[] a = new int[]{-2,0,1,1,2};
        int[] a = new int[]{-2,0,0,2,2};
//        int[] a = new int[]{-1,0,1,2,-1,-4};
//        int[] a = new int[]{0,0,0,0};
        System.out.println(threeSum(a));
    }
}
