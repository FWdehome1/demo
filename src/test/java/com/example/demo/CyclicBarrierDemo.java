package com.example.demo;

import java.util.concurrent.*;

public class CyclicBarrierDemo {


        private static final int MIN_CLASS_NUMBER = 5;

        private static CyclicBarrier cyclicBarrier = new CyclicBarrier(MIN_CLASS_NUMBER, () -> System.out.println("人数到达开班要求，开始排课。"));

        public static void main(String[] args) {
            ExecutorService executorService = new ThreadPoolExecutor(6, 10, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(10), Executors.defaultThreadFactory(), new ThreadPoolExecutor.DiscardPolicy());
            for (int i = 0; i < MIN_CLASS_NUMBER; i++) {
                executorService.execute(new LearnFromLeetCode(cyclicBarrier, "同学 " + i));
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            for (int i = MIN_CLASS_NUMBER; i < MIN_CLASS_NUMBER * 3; i++) {
                executorService.execute(new LearnFromLeetCode(cyclicBarrier, "同学 " + i));
            }
            executorService.shutdown();
        }

        public static class LearnFromLeetCode implements Runnable {

            private CyclicBarrier cyclicBarrier;

            private String name;

            public LearnFromLeetCode(CyclicBarrier cyclicBarrier, String name) {
                this.cyclicBarrier = cyclicBarrier;
                this.name = name;
            }

            @Override
            public void run() {
                try {
                    System.out.println(name + " 报名");
                    Thread.sleep(1000);
                    cyclicBarrier.await();
                    System.out.println(name + " 开始上课");
                    Thread.sleep(1000);
                    System.out.println(name + " 毕业");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }
    }



