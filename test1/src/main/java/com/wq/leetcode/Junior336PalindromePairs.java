package com.wq.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Junior336PalindromePairs {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> rs = new ArrayList<>();
        for(int i=0;i<words.length;i++)
            for (int j=0;j<words.length;j++){
                if(i==j) continue;
                if(!check(words[i]+words[j])) continue;
                List list = new ArrayList();
                list.add(i);list.add(j);
                rs.add(list);
            }
        return rs;
    }

    public boolean check(String w){
        int l=0,r=w.length()-1;
        while(l<r){
            if(w.charAt(l)!=w.charAt(r)) return false;
            l++;r--;
        }
        return true;
    }
}
