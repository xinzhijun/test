package com.wq.leetcode;

/**
 * <Description>
 *Manacher算法的流程
 * 首先大的方面分为两种情况：
 *
 * 第一种情况：下一个要移动的位置在最右回文右边界R的右边。
 *
 * 比如在最开始时，R=-1,p的下一个移动的位置为p=0，p=0在R=-1的右边；p=0时，此时的R=0，p的下一个移动位置为p=1，也在R=0的右边。
 *
 * 在这种情况下，采用普遍的解法，将移动的位置为对称中心，向两边扩，同时更新回文半径数组，最右回文右边界R和最右回文右边界的对称中心C。
 *
 * 第二种情况：下一个要移动的位置就是最右回文右边界R或是在R的左边
 *
 * 在这种情况下又分为三种：
 *
 * 1、下一个要移动的位置p1不在最右回文右边界R右边，且cL<pL。
 *
 * p2是p1以C为对称中心的对称点；
 *
 * pL是以p2为对称中心的回文子串的左边界;
 *
 * cL是以C为对称中心的回文子串的左边界。
 *
 * 这种情况下p1的回文半径就是p2的回文半径radius[p2]。
 *
 * 2、下一个要移动的位置票p1不在最右回文右边界R的右边，且cL>pL。
 *
 * p2是p1以C为对称中心的对称点；
 *
 * pL是以p2为对称中心的回文子串的左边界；
 *
 * cL是以C为对称中心的回文子串的左边界。
 *
 * 这种情况下p1的回文半径就是p1到R的距离R-p1+1。
 *
 * 3、下一个要移动的位置票p1不在最右回文右边界R的右边，且cL=pL；
 *
 * p2是p1以C为对称中心的对称点；
 *
 * pL是以p2为对称中心的回文子串的左边界；
 *
 * cL是以C为对称中心的回文子串的左边界。
 *
 * 这种情况下p1的回文半径就还要继续往外扩，但是只需要从R之后往外扩就可以了，扩了之后更新R和C。
 *
 * @author wangqi
 * @version 1.0
 * @see com.wq.leetcode
 * @since 2019/09/23 15:26
 */
public class Junior5LongestPalindrome2_Manacher {
    public static void main(String[] args) {
//        String str = "abcdcbafabcdck";
        String str = "acbbcbbcbbcds";
        System.out.println(manacher(str));
    }

    public static char[] manacherString(String str){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append("#");
            sb.append(str.charAt(i));
        }
        sb.append("#");
        return sb.toString().toCharArray();
    }

    public static int manacher(String str){
        if(str == null || str.length() < 1){
            return 0;
        }
        char[] charArr = manacherString(str);
        int[] radius = new int[charArr.length];
        int R = -1;
        int c = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < radius.length; i++) {
            radius[i] = R > i ? Math.min(radius[2*c-i],R-i+1):1;
            while(i+radius[i] < charArr.length && i - radius[i] > -1){
                if(charArr[i-radius[i]] == charArr[i+radius[i]]){
                    radius[i]++;
                }else{
                    break;
                }
            }
            if(i + radius[i] > R){
                R = i + radius[i]-1;
                c = i;
            }
            max = Math.max(max,radius[i]);
        }
        return max-1;
    }

}
