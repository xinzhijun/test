package test;

import java.util.HashMap;
import java.util.Map;

/**
 * _A
 * Created by IntelliJ IDEA.
 *
 * @author Wang Qi
 * @version 1.0 2018/11/5 16:52
 * @see _A
 */

public class _A {
    public static String staticStr = "A静态属性";
    public String nonStaticStr = "A非静态属性";
    public static void staticMethod(){
        System.out.println("A静态方法");
    }
    {
        System.out.println("wwwwwwwwww");
    }
    public void nonStaticMethod(){
        System.out.println("A非静态方法");
    }

    public static Map getStringAmount(String s){
        HashMap<Character,Integer> map = new HashMap();
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
        System.out.println(getStringAmount("A Better Butter"));
    }
}
