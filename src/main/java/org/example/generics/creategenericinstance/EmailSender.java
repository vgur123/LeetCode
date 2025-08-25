package org.example.generics.creategenericinstance;

import lombok.Data;

@Data
public class EmailSender implements Sender {
    private String message;

    @Override
    public String send() {
        return message;
    }
}
