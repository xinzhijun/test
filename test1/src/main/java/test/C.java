package test;

/**
 * C
 * Created by IntelliJ IDEA.
 *
 * @author Wang Qi
 * @version 1.0 2018/11/5 16:53
 * @see C
 */

public class C extends _A {

    public static void main(String[] args) {
        C c = new C();
        System.out.println(c.nonStaticStr);
        System.out.println(c.staticStr);
        c.staticMethod();//输出的结果都是父类中的非静态属性、静态属性和静态方法,推出静态属性和静态方法可以被继承

        System.out.println("-------------------------------");

        _A c1 = new C();
        System.out.println(c1.nonStaticStr);
        System.out.println(c1.staticStr);
        c1.staticMethod();//结果同上，输出的结果都是父类中的非静态属性、静态属性和静态方法,推出静态属性和静态方法可以被继承

        System.out.println("-------------------------------");
        B b = new B();
        System.out.println(b.nonStaticStr);
        System.out.println(b.staticStr);
        b.staticMethod();

        System.out.println("-------------------------------");
        _A b1 = new B();
        System.out.println(b1.nonStaticStr);
        System.out.println(b1.staticStr);
        b1.staticMethod();//结果都是父类的静态方法，说明静态方法不可以被重写，不能实现多态

    }
}
