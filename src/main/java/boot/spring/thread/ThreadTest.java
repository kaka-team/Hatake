package boot.spring.thread;

import java.util.concurrent.CountDownLatch;

/**
 * @program: couponcenter
 * @description:
 * @author: Hatake
 * @create: 2020-03-04 15:58
 **/
public class ThreadTest {
    private static  Integer temp1 = 1;
    private static  Integer temp2 = 2;
    private static  Integer temp3 = 3;


    static class Athread implements Runnable{
        private CountDownLatch latch;
        public Athread(CountDownLatch latch) { this.latch = latch; }

        @Override
        public void run() {
            System.out.println("a----calculate");
            temp1 += 1;
            latch.countDown();
        }
    }
    static class Bthread implements Runnable{
        private CountDownLatch latch;
        public Bthread(CountDownLatch latch) { this.latch = latch; }

        @Override
        public void run() {
            System.out.println("b----calculate");
            temp2+=1;
            latch.countDown();

        }

    }
    static class Cthread implements Runnable{
        private CountDownLatch latch;
        public Cthread(CountDownLatch latch) { this.latch = latch; }
        @Override
        public void run() {
            try {
                latch.await();
                System.out.println("c----calculate");
                temp3+=1;
                System.out.println("finish " + temp1+"."+temp2+"."+temp3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(3);
        Thread a = new Thread(new Athread(latch));
        Thread b = new Thread(new Bthread(latch));
        Thread c = new Thread(new Cthread(latch));

        a.start();
        b.start();
        c.start();
        System.out.println("main thread");
        latch.countDown();


    }

}

