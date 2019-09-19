package com.wq.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * JuniorWithoutRepeatingCharacters
 * Created by IntelliJ IDEA.
 *
 * @author Wang Qi
 * @version 1.0 2018/7/18 17:28
 * @see Junior3WithoutRepeatingCharacters
 * To change this template use File | Settings | File Templates.
 */

public class Junior3WithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }

    public static int lengthOfLongestSubstring2(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    public static int ass(String s){
        int ans =0;
        int[] ss = new int[128];
        for(int i=0,j=0;i<s.length();i++){
            j = Math.max(ss[s.charAt(i)],j);
            ans = Math.max(ans,i-j+1);
            ss[s.charAt(i)]=i+1;
        }
        return ans;
    }

    public static int ass2(String s){
        int ans =0;
        HashMap<Character,Integer> ss = new HashMap();
        for(int i=0,j=0;i<s.length();i++){
            if(ss.containsKey(s.charAt(i))){
                j = Math.max(ss.get(s.charAt(i)),j);
            }
            ans = Math.max(ans,i-j+1);
            ss.put(s.charAt(i),i+1);
        }
        return ans;
    }

    public static void main(String[] args){
        String ss = "dvdf";
        System.out.println(ass2(ss));
    }

}
