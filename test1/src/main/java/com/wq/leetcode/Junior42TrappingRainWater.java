package com.wq.leetcode;

/**
 * <Description>
 *
 * @author wangqi
 * @version 1.0
 * @see com.wq.leetcode
 * @since 2019/11/07 19:46
 */
public class Junior42TrappingRainWater {
    public static int trap(int[] height) {
        int l[] = new int[height.length];
        int r[] = new int[height.length];
        l[0] =height[0];
        r[height.length-1] =height[height.length-1];
        int area =0;
        for(int i=1;i<height.length;i++){
            l[i] = Math.max(height[i],l[i-1]);
        }
        for(int j=height.length-2;j>-1;j--){
            r[j] = Math.max(height[j],r[j+1]);
        }
        for(int k=0;k<height.length;k++){
            area +=Math.min(r[k],l[k])-height[k];
        }
        return area;
    }

    public static void main(String[] args){
        int[] a = new int[]{2,0,2};
        System.out.println(trap(a));
    }
}
