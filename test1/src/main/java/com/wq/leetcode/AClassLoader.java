package com.wq.leetcode;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * AClassLoader
 * Created by IntelliJ IDEA.
 *
 * @author Wang Qi
 * @version 1.0 2018/6/7 16:01
 * @see AClassLoader
 * To change this template use File | Settings | File Templates.
 */

public class AClassLoader extends ClassLoader{
    @Override
    public Class loadClass(String name, boolean resolve) throws ClassNotFoundException {
        Class klass = null;
        try {
            klass = findLoadedClass(name); //检查该类是否已经被装载。
            if (klass != null) {
                return klass;
            }

            byte[] bs = getClassBytes(name);//从一个特定的信息源寻找并读取该类的字节。
            if (bs != null && bs.length > 0) {
                klass = defineClass(name, bs, 0, bs.length);
            }
            if (klass == null) { //如果读取字节失败，则试图从JDK的系统API中寻找该类。
                klass = findSystemClass(name);
            }
            if (resolve && klass != null) {
                resolveClass(klass);
            }
        } catch (IOException e) {
            throw new ClassNotFoundException(e.toString());
        }
        System.out.println("klass == " + klass);
        return klass;
    }
    private byte[] getClassBytes(String className) throws IOException {
        String path = System.getProperty("java.class.path") + File.separator;
        path += className.replace('.', File.separatorChar) + ".class";
        System.out.println(path);
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            System.out.println(e);
            return null;   //如果查找失败，则放弃查找。捕捉这个异常主要是为了过滤JDK的系统API。
        }
        byte[] bs = new byte[fis.available()];
        fis.read(bs);
        return bs;
    }

    public static void main(String[] args) throws Exception{
        AClassLoader loader = new AClassLoader();
        Class c = loader.loadClass("test.Test", false);
        System.out.println(c);
        Object o = c.newInstance();
        System.out.println(o);
        Method m = c.getMethod("print", String.class);
        m.invoke(o, "wq");
    }
}
