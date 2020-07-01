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
        fast2(nums,0,nums.length-1);
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
        if(nums[r] < nums[start]){
            nums[r] = nums[start];
            nums[start]=temp;
        }

        if(start>l){
            fast(nums,l,start-1);
        }
        if(start<r){
            fast(nums,start+1,r);
        }

    }

   static void  fast2(int[] list,int left,int right){
        int start=left,end =right;
        int temp = list[right];
        while(start<end){
            while(list[start]<temp && start<end){
                start++;
            }
            while(list[end]>temp && start<end){
                end--;
            }
            if(start<end){
                swap(list,start,end);
            }
        }
        if(list[right] < list[start]){
            list[right] = list[start];
            list[start] = temp;
        }

        if(start>left){
            fast2(list,left,start-1);
        }
        if(start<right){
            fast2(list,start+1,right);
        }
    }
   static void swap(int[] list,int l,int r){
         int temp = list[l];
         list[l] =list[r];
         list[r] = temp;
    }

    public static void main(String[] args){
        int[] nums = new int[]{1,7,3,6,4,5};
        List list = sortArray(nums);
        System.out.println(list);
    }
}
