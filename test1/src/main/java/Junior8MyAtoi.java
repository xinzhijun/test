import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    private final static Pattern pattern = Pattern.compile("\\b(\\w{3}) *(\\w{4})\\b",Pattern.MULTILINE);
    public static int myAtoi(String str) {
        String[] ss = str.split(" ");
//        for(String s: ss){
            Matcher matcher =  pattern.matcher(str);
            MatchResult ms = null;
            while (matcher.find()) {
                ms = matcher.toMatchResult();
                System.out.print("匹配对象的组结果：");
                System.out.print(String.format("\n\t第%s组的结果是:%s",0,matcher.group(0)));
                for (int i = 0; i < matcher.groupCount(); i++) {
                    System.out.print(String.format("\n\t第%s组的结果是:%s",i+1,matcher.group(i+1)));
                }
                System.out.print("\n匹配的整个结果:");
                System.out.println(ms.group());
            }
//        }
        return 0;
    }

    public static void main(String[] args){
        myAtoi("dada ada adad adsda ad asdda adr3 fas daf fas fdsf 234 adda");
    }
}
