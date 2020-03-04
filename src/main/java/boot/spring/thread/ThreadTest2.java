package boot.spring.thread;

import java.util.concurrent.*;

/**
 * @program: couponcenter
 * @description:
 * @author: Hatake
 * @create: 2020-03-04 15:58
 **/
public class ThreadTest2 {
    private static  Integer temp1 = 1;
    private static  Integer temp2 = 2;
    private static  Integer temp3 = 3;


    static class Athread implements Runnable{
        private CyclicBarrier barrier;
        public Athread(CyclicBarrier barrier) { this.barrier = barrier; }

        @Override
        public void run() {
            try {
                for (int i = 0;i < 5;i++){
                    System.out.println("do it");
                    barrier.await(100,TimeUnit.MILLISECONDS);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                e.printStackTrace();
            }
        }
    }
    static class Bthread implements Runnable{
        private CyclicBarrier barrier;
        public Bthread(CyclicBarrier barrier) { this.barrier = barrier; }

        @Override
        public void run() {
            try {
                for (int i = 0;i < 5;i++){
                    System.out.println("do it");
                    barrier.await(100,TimeUnit.MILLISECONDS);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                e.printStackTrace();
            }
        }

    }
    static class Cthread implements Runnable{
        private CyclicBarrier barrier;
        public Cthread(CyclicBarrier barrier) { this.barrier = barrier; }

        @Override
        public void run() {
            try {
                for (int i = 0;i < 5;i++){
                    System.out.println("do it");
                    barrier.await(100,TimeUnit.MILLISECONDS);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(3, new Runnable() {
            @Override
            public void run() {
                System.out.println("action---calcute over!!!");
            }
        });
        Thread a = new Thread(new Athread(barrier));
        Thread b = new Thread(new Bthread(barrier));
        Thread c = new Thread(new Cthread(barrier));

        a.start();
        b.start();
        c.start();
    }

}

