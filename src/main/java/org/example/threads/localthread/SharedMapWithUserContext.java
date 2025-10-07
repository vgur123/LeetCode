package org.example.threads.localthread;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SharedMapWithUserContext implements Runnable {

    //public static Map<Integer, Context> userContextPerUserId = new ConcurrentHashMap<>();
    private static ThreadLocal<Context> userContext = new ThreadLocal<>();
    private Integer userId;
    private UserRepository userRepository = new UserRepository();

    @Override
    public void run() {
        String userName = userRepository.getById(userId);
        //userContextPerUserId.put(userId, new Context(userName));
        userContext.set(new Context(userName));
        System.out.println("thread context for given userId: "
                + userId + " is: " + userContext.get());
    }

    public SharedMapWithUserContext(Integer userId) {
        this.userId = userId;
    }
}
