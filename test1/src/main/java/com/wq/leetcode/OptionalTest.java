package com.wq.leetcode;

import java.util.Optional;

/**
 * OptionalTest
 * Created by IntelliJ IDEA.
 *
 * @author Wang Qi
 * @version 1.0 2018/7/3 16:59
 * @see OptionalTest
 * To change this template use File | Settings | File Templates.
 */

public class OptionalTest {
    public static void main(String[] args) {
        /**
         * 3种静态工厂生产Optional对象
         */

        //创建一个值为brickworker的Optional对象
        Optional<String> o1 = Optional.of("brickworker");

        //创建一个空的Optional
        Optional<String> o2 = Optional.empty();

        //创建一个空的Optional
        Optional<String> o3 = Optional.ofNullable(null);

        //创建一个值为brickworker的Optional对象
        Optional<String> o4 = Optional.ofNullable("brickworker");


        //get方法
        System.out.println("=========get方法==========");
        System.out.println("o1存在值"+o1.get());
        try {
            System.out.println("o2存在值"+o2.get());//o2和o3是空，会抛出错误，专门处理
        } catch (Exception e) {//不必打印错误
        }

        try {
            System.out.println("o3存在值"+o3.get());//o2和o3是空，会抛出错误，专门处理
        } catch (Exception e) {//不必打印错误
            System.out.println("o4存在值"+o4.get());
        }


        System.out.println("========isPresent方法=========");
        if(o1.isPresent()){
            System.out.println("o1有数据");
        }
        if(o2.isPresent()){
            System.out.println("o2有数据");
        }
        if(o3.isPresent()){
            System.out.println("o3有数据");
        }
        if(o4.isPresent()){
            System.out.println("o4有数据");
        }


        System.out.println("===========orElse方法===========");

        System.out.println(o1.orElse("o1没值输出这个"));
        System.out.println(o2.orElse("o2没值输出这个"));
        System.out.println(o3.orElse("o3没值输出这个"));
        System.out.println(o4.orElse("o4没值输出这个"));


        System.out.println("========map方法=================");

        Optional<String> no1 = o1.map(v -> v.toUpperCase());
        System.out.println(no1.orElse("new o1如果没值输出这个"));
        Optional<String> no2 = o2.map(v -> v.toUpperCase());
        System.out.println(no2.orElse("new o2如果没值输出这个"));
        Optional<String> no3 = o3.map(v -> v.toUpperCase());
        System.out.println(no3.orElse("new o3如果没值输出这个"));
        Optional<String> no4 = o4.map(v -> v.toUpperCase());
        System.out.println(no4.orElse("new o4如果没值输出这个"));


        System.out.println("============filter方法==============");
        Optional<String> nno1 = o1.filter(v -> v.indexOf("brick") > -1);//如果字符串中存在brick
        System.out.println(nno1.orElse("nnew o1如果没值输出这个"));
        Optional<String> nno2 = o2.filter(v -> v.indexOf("brick") > -1);//如果字符串中存在brick
        System.out.println(nno2.orElse("nnew o2如果没值输出这个"));
        Optional<String> nno3 = o3.filter(v -> v.indexOf("brick") > -1);//如果字符串中存在brick
        System.out.println(nno3.orElse("nnew o3如果没值输出这个"));
        Optional<String> nno4 = o4.filter(v -> v.indexOf("brick") > -1);//如果字符串中存在brick
        System.out.println(nno4.orElse("nnew o4如果没值输出这个"));


        System.out.println("==========ifPresent方法==========");
        o1.ifPresent(v -> {System.out.println("o1:"+v);});
        o2.ifPresent(v -> {System.out.println("o2:"+v);});
        o3.ifPresent(v -> {System.out.println("o3:"+v);});
        o4.ifPresent(v -> {System.out.println("o4:"+v);});

    }
}
