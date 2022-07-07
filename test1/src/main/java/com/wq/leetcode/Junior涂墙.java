package com.wq.leetcode;

public class Junior涂墙 {
    // 3 种颜料
    public static int getColor(int wall){
        if(wall==1){
            return 3;
        }
        if(wall==2 || wall==3){
            return 6;
        }
        return getColor(wall-1)+2*getColor(wall-2);
    }

    public static void main(String[] args) {
       System.out.println(Junior涂墙.getColor(5));
    }
}
