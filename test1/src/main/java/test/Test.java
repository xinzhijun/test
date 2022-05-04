package test;

/**
 * Test
 * Created by IntelliJ IDEA.
 *
 * @author Wang Qi
 * @version 1.0 2018/6/7 17:12
 * @see Test
 * To change this template use File | Settings | File Templates.
 */

public class Test {
    public void print(String str) {
        System.out.println("嗨，" + str + ", 你终于找到我了！");
    }

    @Override
    public String toString() {
        return "我是一个A对象！";
    }

    public static Test t1=new Test();

    {
        System.out.println("blockA");
    }
    static  {
        System.out.println("blockB");
    }
    public static void main(String[] args)
    {
        Test t2=new Test();
        int j =0;
        for(int i=1;i<=600;i++){
            if(600%i==0){
               System.out.println(i+"xxxx  "+(++j));
            }
        }
    }

}
