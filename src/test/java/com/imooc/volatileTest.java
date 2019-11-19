package com.imooc;

/**
 * @author : Fy
 * @implSpec :
 * @date : 2018-04-08 13:28
 */

/**
 * 一·基本概念
 * 先补充下概念：java内存模型中的可见性,原子性和有序性。
 * 可见性：
 * 可见性是一种复杂的属性，因为可见性中的错误总会违背我们的直觉。通常，我们无法确保执行读操作的线程能适时地看到其他线程写入的值，有时甚至根本不可能的事情。
 * 为了确保多个线程之间对内存操作的可见性，必须使用同步机制。
 * 可见性，是指线程之间的可读性，一个线程修改的状态对另一个线程是可见的。也就是一个线程修改的结果。另外一个线程马上能看到。比如：用volatile修饰的变量，就
 * 会具有可见性，volatile修饰的变量，就会具有可见性，volatile修饰的变量不允许线程内部缓存和重排序,即直接修改内存。所以对其他线程是可见的。但是这里需要注意一个
 * 问题，volatile只能让被他修饰内容具有可见性，但不能保证它具有原子性。比如 volatile int a =0;之后一个操作a++，这个变量a具有可见性，但是a++仍然是一个非原子
 * 操作，也就是这个操作同样存在线程安全问题。
 * 在java中volatile，synchronized和final实现可见性。
 * <p>
 * 原子性：
 * 原子是世界上的最小单位，具有不可分割性。比如 a=0；（a非long和double类型） 这个操作是不可分割的，那么我们说这个操作时原子操作。再比如：a++； 这个操作
 * 实际是a = a + 1；是可分割的，所以他不是一个原子操作。非原子操作都会存在线程安全问题，需要我们使用同步技术（synchronized）来让它变成一个原子操作。一个操作是
 * 原子操作，那么我们称它具有原子性。java的concurrent包下提供了一些原子类，我们可以通过阅读API来了解这些原子类的用法。比如：AtomicInteger、AtomicLong、AtomicReference等。
 * <p>
 * 有序性：
 * Java 语言提供了 volatile 和 synchronized 两个关键字来保证线程之间操作的有序性，volatile 是因为其本身包含“禁止指令重排序”的语义，synchronized 是由“一个变量在同
 * 一个时刻只允许一条线程对其进行 lock 操作”这条规则获得的，此规则决定了持有同一个对象锁的两个同步块只能串行执行。
 */
public class volatileTest {

    private static boolean ready;
    private static int number;

    private static class ReaderThread extends Thread {
        @Override
        public void run() {
            while (!ready) {
                Thread.yield();
            }
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        new ReaderThread().start();
        number = 42;
        ready = false;
    }
}
