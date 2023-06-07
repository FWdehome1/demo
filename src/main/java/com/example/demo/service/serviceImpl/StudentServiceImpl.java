package com.example.demo.service.serviceImpl;


import com.example.demo.domain.ConsTant;
import com.example.demo.service.StudentService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.*;

@Service
public class StudentServiceImpl  implements StudentService {


    private static  final ExecutorService executorService1= Executors.newCachedThreadPool();
    private static  final ExecutorService executorService2= new ThreadPoolExecutor(10, 100,
            60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());





    @Override
    public Object getNameTwo(String id) {
        for(int i=0;i<100000;i++){
            executorService1.submit(()->{
                ConsTant.areaCode.set(Thread.currentThread().getName());
                System.out.println("第一次调用使用线程池"+Thread.currentThread().getName()+ConsTant.areaCode.get());
             //   ConsTant.areaCode.remove();
            });
        }

      /*  for(int i=0;i<1000000;i++){
            executorService1.submit(()->{

                System.out.println("我是第二个"+Thread.currentThread().getName()+ConsTant.areaCode.get());
            });
        }*/
        return null ;
    }

    @Override
    public Object getNameThree(String id) {

        for(int i=0;i<100000;i++){
            executorService1.submit(()->{
                //ConsTant.areaCode.set(Thread.currentThread().getName());
                System.out.println("第二次调用使用线程池"+Thread.currentThread().getName()+ConsTant.areaCode.get());
            });
        }
        return null;
    }


    @Override
    @Async
    public Object getName(String id) {
        return "我是范旺";
    }
}
