import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class 字母 {
    static HashMap<String,Character> map = new HashMap<>();
    static List<String> getLeter(String digit){

        for(int i=1;i<=26;i++){
            map.put(String.valueOf(i), Character.valueOf((char) ('a'+i-1)));
        }
        //map.put("2","b");
        //map.put("3","c");
        //map.put("4","b");
        // map.put("3","c");
        // map.put("4","b");
        List<String> rs = new ArrayList<>();
        combaniteleter(digit,rs,new StringBuffer());
        return rs;
    }

    public static StringBuffer combaniteleter(String digit,List list,StringBuffer s){
        if(digit==null || "".equals(digit)){
            list.add(s.toString());
            return new StringBuffer();
        }
        StringBuffer rs = new StringBuffer();
        int length = digit.toCharArray().length;
        if(length==1){
            s.append(map.get(digit));
            list.add(s.toString());
            return new StringBuffer();
        }else{
            s.append(map.get(String.valueOf(digit.charAt(0))));
            String ss = "";
            if(s.length()!=1){
                ss =s.toString().substring(0,s.length()-1);
            }
            System.out.println(ss);
            s = combaniteleter(digit.substring(1),list,s);
            if(map.get(digit.charAt(0)+""+digit.charAt(1))!=null){
                s.append(ss+map.get(digit.charAt(0)+""+digit.charAt(1)));
                System.out.println("s=="+s);
                s =  combaniteleter(digit.substring(2),list,s);
            }
        }
        return rs;
    }

    public static void main(String[] args) {
        System.out.println(getLeter("1111"));
    }
}
