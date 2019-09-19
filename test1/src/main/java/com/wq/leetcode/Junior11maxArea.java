package com.wq.leetcode;

/**
 * Junior11maxArea
 * Created by IntelliJ IDEA.
 *
 * @author Wang Qi
 * @version 1.0 2018/8/6 14:41
 * @see Junior11maxArea
 * To change this template use File | Settings | File Templates.
 */

public class Junior11maxArea {
    public static int maxArea(int[] height) {
        int maxarea = 0;
        for (int i = 0; i < height.length; i++)
            for (int j = i + 1; j < height.length; j++)
                maxarea = Math.max(maxarea, Math.min(height[i], height[j]) * (j - i));
        return maxarea;
    }

    public  static  int maxArea2(int[] height) {
        int maxarea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r])
                l++;
            else
                r--;
        }
        return maxarea;
    }

    public static void main(String[] args){
        System.out.println(maxArea2(new int[]{1,8,6,2,5,4,8,3,7}));

    }
}
