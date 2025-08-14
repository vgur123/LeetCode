package org.example.threads;

import lombok.SneakyThrows;

import java.util.concurrent.*;

import static java.lang.Thread.sleep;

public class FutureOne {

    @SneakyThrows
    public static void main(String [] args) {

        FutureOne futureOne = new FutureOne();

        CompletableFuture<String> userDetail = futureOne.getCreditScore();
        userDetail.thenAccept(System.out::println);
        System.out.println("Waiting...");
        sleep(2000);
    }

    CompletableFuture<String> getUserDetails(String userId){
        return CompletableFuture.supplyAsync(() -> {
            return "User details for: " + userId;
        });
    }

    CompletableFuture<String> getCreditScore(){
        return getUserDetails("UserOne");
    }


}
