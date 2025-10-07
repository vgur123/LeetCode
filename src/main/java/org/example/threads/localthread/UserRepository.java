package org.example.threads.localthread;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {
    public Map<Integer,String> users = new HashMap<>();

    public UserRepository() {
        users.put(1,"Rabinovich");
        users.put(2,"Zilmanovich");
    }

    public String getById(Integer id){
        return users.getOrDefault(id, "NoName");
    }
}
