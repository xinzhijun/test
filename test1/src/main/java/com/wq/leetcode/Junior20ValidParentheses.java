package com.wq.leetcode;

import javax.xml.stream.events.Characters;
import java.util.HashMap;

/**
 * <Description>
 *
 * @author wangqi
 * @version 1.0
 * @see com.wq.leetcode
 * @since 2019/11/12 17:24
 */
public class Junior20ValidParentheses {
    public static boolean isValid(String s) {
        if(s.length()%2!=0){
            return false;
        }
        HashMap<Character,Character> hashMap = new HashMap<>();
        hashMap.put('(',')');
        hashMap.put('[',']');
        hashMap.put('{','}');
        hashMap.put(')','a');
        hashMap.put(']','b');
        hashMap.put('}','c');
        int r =s.length()/2;
        int l =r-1;
        while(l>-1&&r<s.length()){
            if(hashMap.get(s.charAt(l))==s.charAt(r)){
                l--;
                r++;
            }else if(l>0&&r<s.length()&& hashMap.get(s.charAt(l-1))==s.charAt(l)&&hashMap.get(s.charAt(r))==s.charAt(r+1)){
                l-=2;
                r+=2;
            }else{
                return false;
            }
        }
        return true;
    }

    public static  void main(String[] args){
        System.out.println(isValid("(([]){})"));
    }
}
