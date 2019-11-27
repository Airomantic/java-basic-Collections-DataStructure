package Concurrence;

import java.util.concurrent.CountDownLatch;

/**
 * @program: java基础算法-数据结构
 * @description:
 * @author: jiangzq
 * @create: 2019-11-27 09:58
 **/
public class Main {
    /**
     * 定义一个不安全方法：在高并发情况下得不到想要的结果
     * queryTimes 是一个不安全的属性；
     * getTimes是一个不安全方法；
     */
    static int queryTimes = 0;
    public static int getTimes(){
        queryTimes = queryTimes +1;
        return queryTimes;
    }

    /**
     * 200个线程来执行获取getTimes
     * @param args
     */
    public static void main(String[] args) {

        parallelTesk(200, new Runnable() {
            @Override
            public void run() {
                System.out.println(getTimes());
            }
        });
    }

    /**
     * 高并发测试：
     * 创建threadNum个线程；
     * 执行任务task
     * @param threadNum 线程数量
     * @param task 任务
     */
    public static void parallelTesk(int threadNum, Runnable task){

        // 1. 定义闭锁来拦截线程
        final CountDownLatch startGate = new CountDownLatch(1);
        final CountDownLatch endGate  = new CountDownLatch(threadNum);

        // 2. 创建指定数量的线程
        for (int i = 0; i <threadNum; i++) {
            Thread t = new Thread(() -> {
                try {
                    startGate.await();
                    try {
                        task.run();
                    } finally {
                        endGate.countDown();
                    }
                } catch (InterruptedException e) {

                }
            });

            t.start();
        }

        // 3. 线程统一放行，并记录时间！
        long start =  System.nanoTime();

        startGate.countDown();
        try {
            endGate.await();
        } catch (InterruptedException e) {
        }

        long end = System.nanoTime();
        System.out.print("cost times : " +(end - start));
    }
}
