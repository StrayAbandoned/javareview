package lesson3;

import java.util.concurrent.atomic.AtomicInteger;

public class TaskOne {
    static AtomicInteger i = new AtomicInteger(1);
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    if(i.compareAndSet(1, 1)){
                        System.out.println("ping");
                        i.set(2);
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }

                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    if(i.compareAndSet(2, 2)){
                        System.out.println("pong");
                        i.set(1);
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }

                }
            }
        });
        t1.start();
        t2.start();



    }
}
