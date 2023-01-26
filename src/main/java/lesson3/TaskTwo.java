package lesson3;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TaskTwo {
    static AtomicInteger i = new AtomicInteger(0);
    static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    lock.lock();
                    System.out.println(i.incrementAndGet() +" " +Thread.currentThread().getName());
                    lock.unlock();
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    lock.lock();
                    System.out.println(i.incrementAndGet() +" " +Thread.currentThread().getName());
                    lock.unlock();
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    lock.lock();
                    System.out.println(i.incrementAndGet() +" " +Thread.currentThread().getName());
                    lock.unlock();
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

            }
        });
        t1.start();
        t2.start();
        t3.start();

    }

}
