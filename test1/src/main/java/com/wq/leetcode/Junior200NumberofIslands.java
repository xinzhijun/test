package com.wq.leetcode;

public class Junior200NumberofIslands {
    public static  int addIsland(char[][] nums){
        int rs =0;
        int line =nums.length;
        int column = nums[0].length;
        for(int i=0;i<line;i++)
            for(int j=0;j<column;j++){
                if(nums[i][j]=='1'){
                    rs++;
                    dfs(nums,i,j);
                }
            }
        return rs;
    }

    public static void dfs(char[][] nums,int rr,int co){
        int line =nums.length;
        int column = nums[0].length;
        if(rr<0||co<0||rr>=line||co>=column||nums[rr][co]=='0'){
            return;
        }
        nums[rr][co]='0';
        dfs(nums,rr-1,co);
        dfs(nums,rr+1,co);
        dfs(nums,rr,co-1);
        dfs(nums,rr,co+1);

    }
}
