package com.wq.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * <Description>
 *
 * @author wangqi
 * @version 1.0
 * @see com.wq.leetcode
 * @since 2019/12/26 19:42
 */
public class Junior252会议室 {

    public static int sortArray(int[][] a) {
        Arrays.sort(a,(o1,o2)->o1[0]-o2[0]);
        Stack<Integer> stack = new Stack();
        stack.push(a[0][1]);
        int i=1;
        while(i<a.length ){
            if(stack.peek()<=a[i][0]){
                stack.pop();
            }
            stack.push(a[i][1]);
            i++;
        }
        return stack.size();

    }

    public static void main(String[] args){
        int[][] a =new int[][]{{0,30},{5,10},{15,20}}, b = new int[][] {{7,10},{2,4}};
        int ss =sortArray(b);
        System.out.println(ss);
    }
}
