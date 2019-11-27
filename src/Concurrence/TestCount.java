package Concurrence;


import sun.misc.Unsafe;
import sun.misc.VM;
import sun.reflect.Reflection;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;
import static sun.net.InetAddressCachePolicy.get;

/**
 * @program: java基础算法-数据结构
 * @description:
 * @author: jiangzq
 * @create: 2019-11-27 09:14
 **/
public class TestCount {
    //请求总数
    public static int clientTotal = 5000;
    //同时并发执行的线程数
    public static int threadTotal = 200;

    public static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        //信号量，此处用于控制并发的线程数
        final Semaphore semaphore = new Semaphore(threadTotal);
        //闭锁，可实现计数器递减
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(()->{
                try {
                    //执行该方法用于获取--执行许可
                    //当总计未释放的许可数不超过200时,允许通行,
                    //否则线程阻塞等待，直到获取到许可
                    semaphore.acquire();
                    add();
                    //释放许可
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //闭锁减一
                countDownLatch.countDown();
            });
        }
        //线程阻塞，直到闭锁值为0时，阻塞才释放，继续往下执行
        countDownLatch.await();
        executorService.shutdown();
       // log.info("count:{}", count);
    }

    //线程不安全
    /*private static void add() {
        count++;
    }*/
    private static void add() {
        incrementAndGet();
    }

    private static int incrementAndGet() {
        for (; ; ) {
            int current = get();
            int count = current + 1;
            /*if (compareAndSet(current, count)) {
                return count;
            }*/
        }
    }

    /*private static boolean compareAndSet(int current, int count) {
        return
    }

    public static Unsafe unsafe() {
        Class var0 = Reflection.getCallerClass();
        if(!VM.isSystemDomainLoader(var0.getClassLoader())) {
            throw new SecurityException("Unsafe");
        } else {
            //return theUnsafe;
        }
    }*/
}
