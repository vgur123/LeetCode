package org.example.generics.creategenericinstance;

public class NotificationSender<T> implements Sender {
    private T body;

    public NotificationSender(T body) {
        this.body=body;
    }

    @Override
    public String send() {
        return body.toString();
    }
}
