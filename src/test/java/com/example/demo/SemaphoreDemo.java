package com.example.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


//统一时间内只有一个线程可以访问
public class SemaphoreDemo {

    private static Semaphore semaphore = new Semaphore(1);

    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(6, 10, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(10), Executors.defaultThreadFactory(), new ThreadPoolExecutor.DiscardPolicy());
        for (int i = 0; i < 10; i++) {
            executorService.execute(new Shopping(semaphore, "同学 " + i));
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }

    public static class Shopping implements Runnable {

        private Semaphore semaphore;

        private String name;

        public Shopping(Semaphore semaphore, String name) {
            this.semaphore = semaphore;
            this.name = name;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println(name + " 正在购物。。。");
                Thread.sleep(3000);

                System.out.println(name + " 走出商场");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }
        }
    }
}

