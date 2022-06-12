package com.wq.leetcode;

public class Junior剑指15二进制中1的个数LCOF {
    public int hammingWeight(int n) {
        int ret = 0;
        while (n != 0) {
            n &= n - 1;
            ret++;
        }
        return ret;
    }
}
