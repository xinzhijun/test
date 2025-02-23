package test;

/**
 * @author wq
 * @create 2024/11/26
 */
public class SingletonDoubleCheck {
    // 类引用
    private static volatile SingletonDoubleCheck singletonDoubleCheck;

    // 构造函数私有化
    private SingletonDoubleCheck() {

    }

    // 双重校验 + 锁实现单例
    public static SingletonDoubleCheck getInstance() {
        // 第一次校验是否为null
        if (singletonDoubleCheck == null) {
            // 不为空则加锁
            synchronized (SingletonDoubleCheck.class) {
                // 第二次校验是否为null
                if (singletonDoubleCheck == null) {
                    singletonDoubleCheck = new SingletonDoubleCheck();
                }
            }
        }
        return singletonDoubleCheck;
    }

}
