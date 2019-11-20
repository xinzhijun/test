package com.wq.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * <Description>
 *
 * @author wangqi
 * @version 1.0
 * @see com.wq.leetcode
 * @since 2019/11/20 10:21
 */
public class Junior17LetterCombinationsofaPhoneNumber {
    static HashMap<String,String> hm = new HashMap<>();

    static  List<String> list = null;
    static int  length =0;
    public static List<String> letterCombinations(String digits) {
        list = new ArrayList<>();
        hm.put("0","");
        hm.put("1","");
        hm.put("2","abc");
        hm.put("3","def");
        hm.put("4","ghi");
        hm.put("5","jkl");
        hm.put("6","mno");
        hm.put("7","pqrs");
        hm.put("8","tuv");
        hm.put("9","wxyz");
        if(digits==null||digits.trim().equals("")){
            return list;
        }else{
            length = digits.length();
            get("",digits);
        }
        return list;


    }

    static void get(String before,String next){
        for(int i=0;i<next.length();i++){
            String ss = hm.get(Character.toString(next.charAt(i)));
            for(int j=0;j<ss.length();j++){
                if(i==next.length()-1){
                    if(length==(before.length()+1)){
                        list.add(before+Character.toString(ss.charAt(j)));
                    }

                }else{
                    get(before+Character.toString(ss.charAt(j)),next.substring(i+1));
                }
            }

        }
    }

    public static void main(String[] args){
        System.out.println(letterCombinations("234"));
    }
}
