package org.example.threads;

public class TaskEvenOdd implements Runnable {
    private int max;
    private Printer print;
    private boolean isEvenNumber;

    public TaskEvenOdd(Printer print, int numbs, boolean isEven) {
        isEvenNumber = isEven;
        max = numbs;
        this.print=print;
    }

    // When the odd thread starts running, the value of isEven = false.
    //      and the variable number = 1     =>     printOdd(1) s called.
    // In printOdd method :
    // Since isOdd is false initially, wait() is not called, and the value is printed
    // We then set the value of isOdd to true, so that the odd thread goes into the wait state
    //      and call notify() to wake up the even thread.
    @Override
    public void run() {
        int number = isEvenNumber ? 2 : 1;
        while (number <= max) {
            if (isEvenNumber) {
                print.printEven(number);
            } else {
                print.printOdd(number);
            }
            number += 2;
        }
    }

    public static void main(String... args) {
        Printer print = new Printer();
        Thread t1 = new Thread(new TaskEvenOdd(print, 10, false),"Odd");
        Thread t2 = new Thread(new TaskEvenOdd(print, 10, true),"Even");
        t1.start();
        t2.start();
    }
}

class Printer {
    // It guarantees that any write to a volatile variable by one thread
    // is immediately visible to all other threads
    private volatile boolean isOdd;

    synchronized void printEven(int number) {
        while (!isOdd) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(Thread.currentThread().getName() + ":" + number);
        isOdd = false;
        notify();
    }

    synchronized void printOdd(int number) {
        while (isOdd) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(Thread.currentThread().getName() + ":" + number);
        isOdd = true;
        notify();
    }
}