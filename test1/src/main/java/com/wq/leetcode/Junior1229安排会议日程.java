package com.wq.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class Junior1229安排会议日程 {
    public static int[] sign(int[][] a,int[][] b,int duration){
        Arrays.sort(a, (o1, o2) -> o1[0]-o2[0]);
        Arrays.sort(b, (o1, o2) -> o1[0]-o2[0]);
        int i = 0, j = 0;
        while (i < a.length && j<b.length)
        {
            int l = Math.max(a[i][0], b[j][0]);
            int r = Math.min(a[i][1], b[j][1]);
            if (l + duration <= r) return new int[]{l, l + duration};
            if (a[i][1] < b[j][1]) ++i;
            else ++j;
        }
        return null;
    }

    public static void main(String[] args) {
        int[][] a =new int[][]{{10,50},{60,120},{140,210}}, b = new int[][] {{0,15},{60,70}};

        int duration = 8;
        int[] ss =sign(a,b,duration);
        System.out.println(ss);
    }
}
