package test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

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

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Stream<Integer> stream = numbers.stream();
        stream.filter((x) -> {
            return x % 2 == 0;
        }).forEach(System.out::println);
    }
}
