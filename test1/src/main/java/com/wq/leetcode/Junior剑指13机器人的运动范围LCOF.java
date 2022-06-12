package com.wq.leetcode;

import java.util.Stack;

public class Junior剑指13机器人的运动范围LCOF {
    public static int movingCount(int m, int n, int k) {
        if(k==0){
            return 1;
        }
        int[] dx = new int[]{0,1};
        int[] dy = new int[]{1,0};
        boolean[][] vis = new boolean[m][n];
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{0,0});
        vis[0][0] =true;
        int rs =1;
        while (!stack.isEmpty()){
            int[] cell = stack.pop();
            int x= cell[0],y=cell[1];
            for(int i=0;i<2;i++){
                int tx =dx[i]+x;
                int ty= dy[i]+y;
                if(tx<0||tx>=m||ty<0||ty>=n||vis[tx][ty]||get(tx)+get(ty)>k){
                    continue;
                }
                vis[tx][ty] = true;
                stack.push(new int[]{tx,ty});
                rs++;
            }
        }
        return rs;
    }

   static int get(int x){
        int rs =0;
        while(x!=0){
            rs+=x%10;
            x = x/10;
        }
        return rs;
    }

    public static void main(String[] args) {
        System.out.println(Junior剑指13机器人的运动范围LCOF.movingCount(5,4,3));
    }
}
