package org.easy.threads;

class Box {
    int n;
    boolean valueSet = false;

    synchronized int get() {
        while(!valueSet)
            try {
                wait();

            } catch(InterruptedException e) {
                System.out.println("InterruptedException caught");
            }

        System.out.println("Got: " + n);
        valueSet = false;
        notify();
        return n;
    }

    synchronized void put(int n) {
        while(valueSet)
            try {
                wait();
            } catch(InterruptedException e) {
                System.out.println("InterruptedException caught");
            }

        this.n = n;
        valueSet = true;
        System.out.println("Put: " + n);
        notify();
    }
}

class Producer implements Runnable {
    Box box;

    Producer(Box q) {
        this.box = q;
        new Thread(this, "Producer").start();
    }

    public void run() {
        int i = 0;

        while(true) {
            box.put(i++);
        }
    }
}

class Consumer implements Runnable {
    Box box;

    Consumer(Box q) {
        this.box = q;
        new Thread(this, "Consumer").start();
    }

    public void run() {
        while(true) {
            box.get();
        }
    }
}

class ProducerConsumer {
    public static void main(String args[]) {
        Box q = new Box();
        new Producer(q);
        new Consumer(q);

        System.out.println("Press Control-C to stop.");
    }
}
