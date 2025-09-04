package org.example.threads;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class ArrayBlockingQueueExample {

    public static void main(String[] args) throws InterruptedException {

        // Create an ArrayBlockingQueue with a capacity of 3
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(3);

        // --- Producer Thread ---
        Thread producer = new Thread(() -> {
            try {
                System.out.println("Producer: Adding 'Apple'...");
                queue.put("Apple"); // Blocks if queue is full
                System.out.println("Producer: Added 'Apple'. Queue: " + queue);

                System.out.println("Producer: Adding 'Banana'...");
                queue.put("Banana");
                System.out.println("Producer: Added 'Banana'. Queue: " + queue);

                System.out.println("Producer: Adding 'Cherry'...");
                queue.put("Cherry");
                System.out.println("Producer: Added 'Cherry'. Queue: " + queue);

                System.out.println("Producer: Trying to add 'Date' (will block)...");
                // This will block until a consumer takes an element
                queue.put("Date");
                System.out.println("Producer: Added 'Date'. Queue: " + queue);

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // --- Consumer Thread ---
        Thread consumer = new Thread(() -> {
            try {
                // Give producer a chance to fill the queue
                Thread.sleep(1000);

                System.out.println("Consumer: Taking element...");
                String item1 = queue.take(); // Blocks if queue is empty
                System.out.println("Consumer: Taken: " + item1 + ". Queue: " + queue);

                System.out.println("Consumer: Taking element...");
                String item2 = queue.take();
                System.out.println("Consumer: Taken: " + item2 + ". Queue: " + queue);

                System.out.println("Consumer: Taking element...");
                String item3 = queue.take();
                System.out.println("Consumer: Taken: " + item3 + ". Queue: " + queue);

                System.out.println("Consumer: Taking element...");
                String item4 = queue.take(); // This will unblock the producer
                System.out.println("Consumer: Taken: " + item4 + ". Queue: " + queue);

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        consumer.start();

        producer.join();
        consumer.join();

        System.out.println("Main: All operations complete. Final Queue: " + queue);
    }
}
