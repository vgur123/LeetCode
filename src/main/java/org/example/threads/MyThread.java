package org.example.threads;

public class MyThread extends Thread{
    @Override
    public void run() {
        super.run();
        try {
            sleep(1000);
            System.out.println("Thred over");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String [] arg) throws InterruptedException {
        MyThread myThread = new MyThread();
        myThread.start();
        String threadName = Thread.currentThread().getName();
        myThread.join();
        System.out.println(threadName);
    }
}
