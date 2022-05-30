package com.wq.leetcode;

public class Junior152MaximumProductSubarray {
   static int get(int[] s){
        int max=Integer.MIN_VALUE;
        int imax = 1;
        int imin = 1;
        for(int i=0;i<s.length;i++){
            if(s[i]<0){
              int tmp = imax;
               imax = imin;
               imin =tmp;
            }
             imax = Math.max(imax*s[i],s[i]);
             imin = Math.min(imin*s[i],s[i]);
             max = Math.max(imax,max);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(get(new int[]{2,3,-2,4,-2}));
    }
}
