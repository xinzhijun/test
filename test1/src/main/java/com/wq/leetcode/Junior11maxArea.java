package com.wq.leetcode;

/**
 * Junior11maxArea
 * 方法二：双指针法
 * 算法
 *
 * 这种方法背后的思路在于，两线段之间形成的区域总是会受到其中较短那条长度的限制。此外，两线段距离越远，得到的面积就越大。
 *
 * 我们在由线段长度构成的数组中使用两个指针，一个放在开始，一个置于末尾。 此外，我们会使用变量 maxareamaxarea 来持续存储到目前为止所获得的最大面积。 在每一步中，我们会找出指针所指向的两条线段形成的区域，更新 maxareamaxarea，并将指向较短线段的指针向较长线段那端移动一步。
 *
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
