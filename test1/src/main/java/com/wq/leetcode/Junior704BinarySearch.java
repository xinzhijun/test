package com.wq.leetcode;

public class Junior704BinarySearch {
    public static int search(int[] s,int target){
        int l =0,r=s.length-1;
        while(l<=r){
            int mid = (r+l)/2;
            if(target==s[mid]){
                return mid;
            } else if(s[mid]>target){
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{1,2,3,5,8,19},8));
    }
}
