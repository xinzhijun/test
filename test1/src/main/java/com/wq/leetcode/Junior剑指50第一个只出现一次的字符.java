package com.wq.leetcode;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.HashMap;

public class Junior剑指50第一个只出现一次的字符 {
    public char firstUniqChar(String s) {
        char[] cs = s.toCharArray();
        HashMap<Character, Boolean> map = new HashMap<>();
        for(char c:cs){
            map.put(c,!map.containsKey(c));
        }
        for(char c:cs){
            if(map.get(c)){
                return c;
            }
        }
        return ' ';

    }
}
