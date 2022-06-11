package com.wq.leetcode;

public class Junior剑指11旋转数组的最小数字LCOF {
    public int minArray(int[] numbers) {
        int l=0,r=numbers.length-1;
        while(l<r){
            int mid =(l+r)/2;
            if(numbers[mid]>numbers[r]){
                l = mid+1;
            }else if(numbers[mid]<numbers[r]){
                r =mid;
            }else{
                r--;
            }
        }
        return numbers[l];
    }
}
