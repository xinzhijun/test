package test;

import java.util.HashMap;
import java.util.Map;

public class StringAmount {
    public static Map getStringAmount(String s){
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=' '){
                if(map.containsKey(s.charAt(i))){
                    map.put(s.charAt(i),map.get(s.charAt(i))+1);
                }else{
                    map.put(s.charAt(i),1);
                }
            }

        }
        map.forEach((k,v)->System.out.print(k+":"+v+","));
        return map;
    }

    public static void main(String[] args){
        getStringAmount("A Better Butter");
    }
}
