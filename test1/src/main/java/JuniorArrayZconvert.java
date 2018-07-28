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
    public  static  String convert(String s, int numRows) {
        int length = numRows-2;
        StringBuffer ss = new StringBuffer();
        for(int i=0;i<numRows;i++){
            int num= i;
            while (num<s.length()){
                ss.append(s.charAt(num));
                num += numRows+length;
            }
        }
        return ss.toString();
    }

    public static void main(String[] args){
        System.out.println(convert("PAYPALISHIRING",4));
    }
}
