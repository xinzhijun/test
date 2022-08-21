package com.wq.leetcode;

public class Junior2139MinimumMovestoReachTargetScore {
    public static void main(String[] args) {
        System.out.println("Hello, world!");
        //5,20  5,21  4  18  0  18
        System.out.println(GetMinSteps(1,1,2,6,18));
    }
    static int[] rss;
    public static int[]  GetMinSteps(int a, int b, int c, int s, int t){
        rss = new int[t];
        getMethod(a,b,c,s,t,0);
        for(int ss:rss){
            if(ss==0) continue;
            System.out.println(ss+"====");
        }
        return rss;
    }
    static int rs = 0;
    public static void  getMethod(int a, int b, int c, int s, int t,int index){
        if(rs==t){
            return;
        }
        if(index==0){
            rs =s;
            rss[index++] = rs;
            getMethod(a,b,c,s,t,index);
        }
        else if(rs>0 && (rs*c <t+2*a && t%rs*c<=rs && t%(rs+1)*c>rs ||t%(rs*c)==0)){
            rs = rs*c;
            System.out.println(rs+"*");
            rss[index++] = rs;
            getMethod(a,b,c,s,t,index);
        }else if(Math.abs(rs+a-t)<=a || Math.abs((rs+a)*c-t)<=a||s==0){
            rs =rs+a;
            System.out.println(rs+"+");
            rss[index++] = rs;
            getMethod(a,b,c,s,t,index);
        }else {
            rs =rs-b;
            System.out.println(rs+"-");
            rss[index++] = rs;
            getMethod(a,b,c,s,t,index);
        }


        return;

    }
}
