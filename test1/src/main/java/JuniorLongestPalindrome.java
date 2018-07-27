import java.util.HashMap;

/**
 * JuniorLongestPalindrome
 * Created by IntelliJ IDEA.
 *
 * @author Wang Qi
 * @version 1.0 2018/7/26 15:52
 * @see JuniorLongestPalindrome
 * To change this template use File | Settings | File Templates.
 */

public class JuniorLongestPalindrome {
    public static String longestPalindrome(String s) {
        int ans = 0, i = 0, j = 0,old=0;
        HashMap<Character, Integer> hashMap = new HashMap<>(10);
        boolean repeat =false;
        for (; i < s.length(); i++) {
            if (hashMap.containsKey(s.charAt(i))) {
                if(!repeat){
                    old = j;
                }
                j = Math.max(j, hashMap.get(s.charAt(i)));
                repeat =true;
            }
            if(ans<(i - j + 1)){
                old = j;
            }
            ans = Math.max(ans, i - j + 1);
            hashMap.put(s.charAt(i), i + 1);
        }
        StringBuffer stringBuffer = new StringBuffer();
        if(repeat){
            int at = old-1;
            char w =s.charAt(at<0?0:at);
            ans++;
            for (int m = 0; m < ans; m++,at++) {
                if (at < 0) {
                    at = 0;
                }
                if (at >= s.length()) {
                    break;
                }

                if (m == 0 && at < s.length() - 1 && s.charAt(at - 1<0?0:at - 1) == s.charAt(at==0?1:at)) {
                    char ss = s.charAt(--at<0?0:at);
                    stringBuffer.append(ss);
                    at = s.indexOf(ss);
                    for (++at; at < s.length(); at++) {
                        if (ss == s.charAt(at)) {
                            stringBuffer.append(s.charAt(at));
                        } else {
                            break;
                        }
                    }
                    break;
                } else {
                    stringBuffer.append(s.charAt(at));
                }
            }
            if(stringBuffer.length()>0&& stringBuffer.charAt(0)!=stringBuffer.charAt(stringBuffer.length()-1)){
                if(at<stringBuffer.length()-2){
                    stringBuffer.append(s.charAt(at+1));
                }else{
//                    char w = stringBuffer.charAt(stringBuffer.length()-1);
                    if(s.lastIndexOf(w)!=s.indexOf(w)&&s.indexOf(w)<=s.indexOf(stringBuffer.charAt(0))&&stringBuffer.indexOf(w+"")==stringBuffer.lastIndexOf(w+"")){
                        stringBuffer.append(w);
                    }else{
                        stringBuffer.deleteCharAt(stringBuffer.length()-1);
                    }
                }
            }
        }else if(s.length()>0){

            stringBuffer.append(s.charAt(0));
        }

        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("cbbd"));
    }
}
