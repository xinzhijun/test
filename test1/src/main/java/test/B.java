package test;

/**
 * B
 * Created by IntelliJ IDEA.
 *
 * @author Wang Qi
 * @version 1.0 2018/11/5 16:53
 * @see B
 */

public class B extends _A {
    public static String staticStr = "B改写后的静态属性";
    public String nonStaticStr = "B改写后的非静态属性";
    public static void staticMethod(){
        System.out.println("B改写后的静态方法");
    }

}
