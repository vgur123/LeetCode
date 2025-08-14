package org.example.mdc;

import org.apache.log4j.MDC;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TransferDemo {

    // Log4JRunnable - другое решение
    public static void main(String[] args) {
        Random random = new Random();

        ExecutorService executor = Executors.newFixedThreadPool(10);
        Log4JTransferService log4jBusinessService = new Log4JTransferService();
        for (int i = 0; i < 100; i++) {
            Transfer tx = new Transfer("123","Godunov", random.nextInt(1000));
            MDC.put("transaction.id", tx.getTransactionId());
            MDC.put("transaction.owner", tx.getSender());
            Runnable task = () -> log4jBusinessService.transfer(tx.getAmount());
            executor.submit(task);
            MDC.clear();
        }
        executor.shutdown();

    }
}
