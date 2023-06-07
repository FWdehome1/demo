package com.example.demo;

import java.util.concurrent.*;

public class Test {

    private  static  ThreadLocal<String> areaCode =new ThreadLocal<>();
    private static  final ExecutorService executorService1= Executors.newCachedThreadPool();
  private static  final ExecutorService executorService2= new ThreadPoolExecutor(10, 100,
                                    60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());

    public static void main(String[] args) {
        for(int i=0;i<100000;i++){
            executorService1.submit(()->{
                Test.areaCode.set(Thread.currentThread().getName());
                System.out.println(Thread.currentThread().getName()+Test.areaCode.get());
            });
        }

        for(int i=0;i<1000000;i++){
            executorService1.submit(()->{

                System.out.println("我是第二个"+Thread.currentThread().getName()+Test.areaCode.get());
            });
        }


    }
}
