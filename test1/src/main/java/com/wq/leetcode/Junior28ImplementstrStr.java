package com.wq.leetcode;

/**
 * <Description>
 *
 * @author wangqi
 * @version 1.0
 * @see com.wq.leetcode
 * @since 2019/12/13 11:58
 */
public class Junior28ImplementstrStr {
    public static  int strStr(String haystack, String needle) {
        for(int i=0;i<=haystack.length()-needle.length(); i++){
            String ss =haystack.substring(i,i+needle.length());
            if(ss.equals(needle)){
                return i;
            }

        }
        return -1;
    }

    public static void main(String[] args){
//        System.out.println(strStr("mississippi","a") );
        System.out.println(strStr("hello","ll") );
    }
}
