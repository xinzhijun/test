package com.wq.leetcode;

import java.util.Arrays;

/**
 * <Description>
 *
 * @author wangqi
 * @version 1.0
 * @see com.wq.leetcode
 * @since 2019/12/17 10:36
 */
public class Junior31NextPermutation {
    public static  void nextPermutation(int[] nums) {
        int i=nums.length-2;
        boolean ss =false;
        for(;i>=0;i--){
            //todo find min
            if(nums[i]<nums[i+1]){
                if(i==nums.length-2){
                    change(nums,i,i+1);
                    ss =true;
                    break;
                }else {
                    int tag = i+1;
                    int min = nums[i+1];
                    //todo find min large value
                    for(int j=i+2;j<nums.length;j++){
                        if(nums[j]>nums[i]){
                            min = Math.min(min,nums[j]);
                            if(nums[j]==min){
                                tag = j;
                            }
                        }
                    }
                    if(nums[i]<min){
                        change(nums,i,tag);
                        ss =true;
                    }
                }
                break;
            }
        }
        if(!ss&&i==0&&nums[0]<nums[1]){
            change(nums,0,1);
        }
        for(i=i+1;i<nums.length;i++){
            for(int k=i+1;k<nums.length;k++){
                if(nums[i]>nums[k]){
                    change(nums,i,k);
                }
            }
        }
    }

    static void change(int[] nums,int a,int b){
        int tmp = nums[b];
        nums[b] = nums[a];
        nums[a] = tmp;
    }

    public static void main(String[] args){
//        int[] nums = new int[]{2,3,1};
        int[] nums = new int[]{5,4,7,5,3,2};
        nextPermutation(nums);
        System.out.println(nums);
    }
    static  void a(){
        a();
    }
}
