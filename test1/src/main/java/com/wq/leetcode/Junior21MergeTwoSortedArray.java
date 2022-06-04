package com.wq.leetcode;

import com.sun.jmx.remote.internal.ArrayQueue;

/**
 * <Description>
 *
 * @author wangqi
 * @version 1.0
 * @see com.wq.leetcode
 * @since 2019/11/15 16:59
 */
public class Junior21MergeTwoSortedArray {
    public static ArrayQueue merge(int[] a, int[] b){
        int len = a.length+b.length;
        ArrayQueue<Integer> rs = new ArrayQueue<>(len);
        for(int i=0,j=0;;){
            if((j>=b.length|| i<a.length &&a[i]<b[j])){
                rs.add(a[i]);
                i++;
            }
            if((i>=a.length ||j<b.length && a[i]>=b[j] )){
                rs.add(b[j]);
                j++;
            }
            if(j>=b.length && i>=a.length){
                break;
            }
        }
        return rs;
    }

    public static void main(String[] args) {
        //1->9->2->8->3->7
        System.out.println(merge(new int[]{3,5,6,9},new int []{4,6,10,13,17}));
    }
}
