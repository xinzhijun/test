package com.wq.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * <Description>
 *
 * @author wangqi
 * @version 1.0
 * @see com.wq.leetcode
 * @since 2019/12/26 19:42
 */
public class Junior912SortanArray {

    public static List<Integer> sortArray(int[] nums) {
        fast(nums,0,nums.length-1);
        List<Integer> list = new ArrayList<>();
        for(int s:nums){
            list.add(s);
        }
        return list;
    }

    static  void fast(int[] nums,int l,int r){
        int start=l;
        int end=r;
        int temp = nums[r];
        while(start<end){
            while (nums[start]<=temp&&start<end){
                start++;
            }
            while(nums[end]>=temp&&start<end){
                end--;
            }
            if(start<end){
                int tmp = nums[start];
                nums[start]=nums[end];
                nums[end]=tmp;
            }
        }
        nums[r] = nums[start];
        nums[start]=temp;
        if(start>l){
            fast(nums,l,start-1);
        }
        if(start<r){
            fast(nums,start+1,r);
        }

    }

    public static void main(String[] args){
        int[] nums = new int[]{4,5};
        List list = sortArray(nums);
        System.out.println(list);
    }
}
