package org.easy.threads;

import java.util.concurrent.Semaphore;

public class ResourceAccess {
    private final Semaphore semaphore = new Semaphore(5); // Allow 3 threads to access concurrently

    public void accessResource() throws InterruptedException {
        semaphore.acquire();                    // Acquire a permit
        try {
            System.out.println(Thread.currentThread().getName() + " is accessing the resource.");
            Thread.sleep(2000);         // Simulate work

        } finally {
            semaphore.release();            // Release the permit
            System.out.println(Thread.currentThread().getName() + " has released the resource. With result " + Math.random());
        }
    }

    public static void main(String[] args) {
        ResourceAccess resourceAccess = new ResourceAccess();
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    resourceAccess.accessResource();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }, "Thread-" + (i + 1)).start();
        }
    }
}
