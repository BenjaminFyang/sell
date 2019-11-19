package com.imooc.Singleton;

/**
 * @author : Fy
 * @implSpec : Created with IntelliJ IDEA.
 * @date : 2018-03-13 15:40
 * @deprecated : 单例模式Singleton
 * 应用场合：有些对象只需要一个就足够了，比如古代皇帝，老婆
 * 作用：保证整个应用程序中某个实例有且只有一个
 * 类型：懒汉模式，饿汉模式
 */
public class Singleton {
    //1.将构造方法私有化，不允许外部直接创建对象
    private Singleton() {

    }

    //2.创建类的唯一实例,使用private static
    private static Singleton instance = new Singleton();


    //3.提供一个用于获取实例的方法,使用public static修饰
    static Singleton getInstance() {
        return instance;
    }

}
