package com.wq.leetcode;


/**
 * JuniorMyAtoi
 * Created by IntelliJ IDEA.
 *
 * @author Wang Qi
 * @version 1.0 2018/8/1 14:48
 * @see Junior8MyAtoi
 * To change this template use File | Settings | File Templates.
 */

public class Junior8MyAtoi {
    public static int myAtoi(String str) {
        str = str.trim();
        if (str == null || str.length() == 0)
            return 0;

        char firstChar = str.charAt(0);
        int sign = 1;
        int start = 0;
        long res = 0;
        if (firstChar == '+') {
            sign = 1;
            start++;
        } else if (firstChar == '-') {
            sign = -1;
            start++;
        }

        for (int i = start; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return (int) res * sign;
            }
            res = res * 10 + str.charAt(i) - '0';
            if (sign == 1 && res > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            if (sign == -1 && res > Integer.MAX_VALUE)
                return Integer.MIN_VALUE;
        }
        return (int) res * sign;
    }

    public static void main(String[] args){
        System.out.println(myAtoi("-34234"));
    }
}
