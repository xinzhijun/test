package test;

/**
 * Test
 * Created by IntelliJ IDEA.
 *
 * @author Wang Qi
 * @version 1.0 2018/6/7 17:12
 * @see Test2
 * To change this template use File | Settings | File Templates.
 */

public class Test2 extends Test{
    @Override
    public void print(String str) {
        System.out.println("嗨，" + str + ", 你终于找到我了22222！");
    }

    @Override
    public String toString() {
        return "我是一个B对象！";
    }

    public static void main(String[] args){
        Test test = new Test2();
        test.print("b");
        System.out.print(test.toString());
    }
}
