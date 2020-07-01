package boot.spring.test;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @program: SSM
 * @description:
 * @author: Hatake
 * @create: 2020-06-28 10:57
 **/
public class ReentrantReadWriteLockTest {
    public void get(ReentrantReadWriteLock lock) throws InterruptedException {
        System.out.println("----");
        lock.readLock().lock();
        System.out.println("get");
        Thread.sleep(3000);
        lock.readLock().unlock();
    }

    public  void get2(ReentrantReadWriteLock lock){
        lock.readLock().lock();
        System.out.println("get2");
        lock.readLock().unlock();
    }
    public  void set(ReentrantReadWriteLock lock) throws InterruptedException {
        lock.writeLock().lock();
        System.out.println("write");
        Thread.sleep(5000L);
        lock.writeLock().unlock();
    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        ReentrantReadWriteLockTest t = new ReentrantReadWriteLockTest();
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                try {
                    t.set(lock);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread thread2 = new Thread() {
            @Override
            public void run() {
                try {
                    t.get(lock);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread1.start();
        thread2.start();
    }
}
