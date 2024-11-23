package com.wq.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * <Description>
 *
 * @author wangqi
 * @version 1.0
 * @see com.wq.leetcode
 * @since 2019/12/26 19:42
 */
public class Junior986区间列表的交集 {

    public static int[][] sortArray(int[][] a,int[][] b) {
        List<int[]> ans = new ArrayList();
        int i=0,j=0;
        while(i<a.length && j<b.length){
            int l = Math.max(a[i][0],b[j][0]);
            int r = Math.min(a[i][1],b[j][1]);
            if(l<=r){
                ans.add(new int[]{l,r});
            }
            if(a[i][1]<b[j][1]){
                i++;
            }else{
                j++;
            }
        }
        return ans.toArray(new int[ans.size()][]);

    }

    public static void main(String[] args){
        int[][] a =new int[][]{{0,2},{5,10},{13,23},{24,25}}, b = new int[][] {{1,5},{8,12},{15,24},{25,26}};
        int[][] ss =sortArray(a,b);
        System.out.println(ss);
    }
}
