package com.wq.leetcode;

public class Junior剑指58左旋转字符串 {
    public String reverseLeftWords(String s, int n) {
        return s.substring(n)+s.substring(0,n);
    }
}
