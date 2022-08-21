package com.wq.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Junor983MinimumCostForTickets {
//     static int[] costs;
//    static  Integer[] memo;
//    static  Set<Integer> dayset;

    public static int mincostTickets(int[] days, int[] cos) {
        costs = cos;
        memo = new Integer[366];
        dayset = new HashSet();
        for (int d: days) {
            dayset.add(d);
        }
        return dp(1);
    }

    public static int dp(int i) {
        if (i > 365) {
            return 0;
        }
        if (memo[i] != null) {
            return memo[i];
        }
        if (dayset.contains(i)) {
            memo[i] = Math.min(Math.min(dp(i + 1) + costs[0], dp(i + 7) + costs[1]), dp(i + 30) + costs[2]);
        } else {
            memo[i] = dp(i + 1);
        }
        return memo[i];
    }
    static int[] costs;
    static  Integer[] memo;
    static  Set<Integer> dayset;
    public static int getCost(int[] days,int[] cos){
        costs =cos;
        dayset = new HashSet<>();
        memo = new Integer[366];
        for(int d:days){
            dayset.add(d);
        }
        return  dp2(1);
    }

    public static int dp2(int i){
        if(i>365){
            return 0;
        }
        if(memo[i]!=null){
            return memo[i];
        }
        if(dayset.contains(i)){
            memo[i] = Math.min(Math.min(dp2(i+1)+costs[0],dp2(i+7)+costs[1]),dp2(i+30)+costs[2]);
        }else{
            memo[i] = dp2(i+1);
        }
        return memo[i];
    }

    public static void main(String[] args) {
        int[] da =new int[]{1,4,6,7,8,20};
        int[] co = new int[]{2,7,15};
        System.out.println(getCost(da,co));
    }

}
