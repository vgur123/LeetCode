package org.easy.threads;


import java.util.concurrent.Semaphore;

public class Foo {

    private Semaphore firstSemaphore = new Semaphore(1);
    private Semaphore secondSemaphore = new Semaphore(0);
    private Semaphore thirdSemaphore = new Semaphore(0);

    public void first(Runnable printFirst) throws InterruptedException {
        firstSemaphore.acquire();
        printFirst.run();
        secondSemaphore.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        secondSemaphore.acquire();
        printSecond.run();
        thirdSemaphore.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        thirdSemaphore.acquire();
        printThird.run();
        firstSemaphore.release();
    }


    public static void main(String[] args) throws InterruptedException {
        Foo foo = new Foo();

        Thread threadA = new Thread(() -> {
            try {
                foo.first(() -> System.out.println("1"));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread threadB = new Thread(() -> {
            try {
                foo.second(() -> System.out.println("2"));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread threadC = new Thread(() -> {
            try {
                foo.third(() -> System.out.println("3"));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        threadC.start();
        threadA.start();
        threadB.start();

    }
}