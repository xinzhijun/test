package com.wq.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * <Description>
 *
 * @author wangqi
 * @version 1.0
 * @see com.wq.leetcode
 * @since 2019/12/13 11:58
 */
public class Junior27RemoveElement {
    public static int removeElement(int[] nums, int val) {
        int i=0;
        for(int j=0;j<nums.length;j++){
            if(nums[j]!=val){
                nums[i] =nums[j];
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args){
        int[] nums =new int[]{3,2,2,3};
        System.out.println(removeElement(nums, 3) );
    }
}
