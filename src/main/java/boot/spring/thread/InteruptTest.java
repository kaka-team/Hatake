package boot.spring.thread;

/**
 * @program: SSM
 * @description:
 * @author: Hatake
 * @create: 2020-06-18 18:51
 **/
public class InteruptTest {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                int i = 0;
                while (true){
                    if(Thread.currentThread().isInterrupted()){
                        if(i > 100){
                            interrupted();
                            System.out.println("again");
                            break;
                        }
                        System.out.println("thread 1 is isInterrupted");
                        i++;
                    }else{
                        System.out.println("thread 1 is working");
                    }
                }
            }
        };
        thread1.start();
        Thread.sleep(1000L);
        thread1.interrupt();

    }
}
