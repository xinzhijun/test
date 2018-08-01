/**
 * JuniorArrayZconvert
 * Created by IntelliJ IDEA.
 *
 * @author Wang Qi
 * @version 1.0 2018/7/28 17:22
 * @see JuniorArrayZconvert
 * To change this template use File | Settings | File Templates.
 */

public class JuniorArrayZconvert {
    public static String convert(String s, int numRows) {
        if (numRows == 1) return s;
        //外部规律numRows-2
        int length = numRows - 2;
        //内部规律2*numRows-4
        int length2 = (numRows << 1) - 4;
        boolean isAdd = false;
        StringBuffer ss = new StringBuffer();
        for (int i = 0; i < numRows; i++) {
            int num = i;
            while (num < s.length()) {
                ss.append(s.charAt(num));
                if (length2 > 0 && i != 0 && i != numRows - 1) {
                    isAdd = true;
                    if ((num + length2) < s.length()) {
                        ss.append(s.charAt(num + length2));
                    }
                }
                num += numRows + length;
            }
            if (isAdd) {
                length2 -= 2;
            }
        }
        return ss.toString();
    }

    public static void main(String[] args) {
        System.out.println(4 << 1);
        System.out.println(convert("ABCDE", 4));
    }
}
