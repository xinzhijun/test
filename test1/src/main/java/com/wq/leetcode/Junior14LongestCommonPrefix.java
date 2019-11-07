package com.wq.leetcode;

public class Junior14LongestCommonPrefix {
    public static String  longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String res = strs[0];
        int i = 1;
        while (i < strs.length) {
            while (strs[i].indexOf(res) != 0) {
                res = res.substring(0, res.length() - 1);
            }
            i++;
        }
        return res;
    }

    public static void main(String[] args){
        String[] a = new String[]{"flower","flow","flight"};
        System.out.println(longestCommonPrefix(a));
    }
}
