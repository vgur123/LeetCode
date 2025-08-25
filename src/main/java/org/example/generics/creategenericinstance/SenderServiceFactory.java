package org.example.generics.creategenericinstance;

public class SenderServiceFactory<T extends Sender> {
    private final Factory<T> factory;

    public SenderServiceFactory(Factory<T> factory) {
        this.factory = factory;
    }

    public T createInstance() {
        return factory.create();
    }
}
