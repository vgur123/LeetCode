package org.easy.threads.wit;

import lombok.SneakyThrows;
import org.apache.commons.io.ThreadUtils;

import java.time.Duration;

public class ThreadA {

    private static final ThreadB b = new ThreadB();

    public static void main(String... args) throws InterruptedException {
        b.start();

        synchronized (b) {
            while (b.sum == 0) {
                System.out.println("Waiting for ThreadB to complete...");
                b.wait();
            }
            System.out.println("ThreadB has completed. Sum is: " + b.sum);
        }
    }
}

class ThreadB extends Thread {
    int sum=0;

    @SneakyThrows
    @Override
    public void run() {
        synchronized (this) {
            for (int i=0; i < 10000; i++) {
                sum ++;
            }
            notify();
        }
    }
}