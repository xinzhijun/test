package com.wq.leetcode;

import java.util.HashMap;

/**
 * description :
 *
 * @author : wangqi
 * @version :1.0
 * @date : 2023/1/29 10:56
 */
public class Junior返回前项比本项大 {
    public static int[] getMaxArray(int[] s){
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] rs = new int[s.length];
        for(int i=s.length-1;i>=0;i--){
            map.put(i,s[i]);
            int j =i+1;
            boolean meet = false;
            while(map.get(j)!=null) {
                if(map.get(j)>s[i]){
                   rs[i] = map.get(j);
                   meet =true;
                   break;
                }
                j++;
            }
            if(!meet){
                rs[i] = -1;
            }
        }
        return rs;
    }

    public static void main(String[] args) {
        System.out.println(getMaxArray(new int[]{2,1,2,4,3}));
    }
}
