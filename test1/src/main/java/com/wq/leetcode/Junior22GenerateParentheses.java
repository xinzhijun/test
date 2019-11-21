package com.wq.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * <Description>
 *
 * @author wangqi
 * @version 1.0
 * @see com.wq.leetcode
 * @since 2019/11/21 17:24
 */
public class Junior22GenerateParentheses {
    public static  List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        recursion(list,"",0,0,n);
        return list;
    }

    public static void recursion(List list, String ss, int l, int r, int n){
        if(ss.length()==n*2){
            list.add(ss);
        }
        if(l<n){
            recursion(list,ss+"(",l+1,r,n);
        }
        if(r<l){
            recursion(list,ss+")",l,r+1,n);
        }
    }

    public static void main(String[] args){
        List<String> list = generateParenthesis(3);
        list.forEach(System.out::println);
    }
}
