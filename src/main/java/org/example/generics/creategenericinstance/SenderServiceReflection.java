package org.example.generics.creategenericinstance;

public class SenderServiceReflection<T extends Sender> {
    private Class<T> clazz;

    public SenderServiceReflection(Class<T> clazz) {
        this.clazz = clazz;
    }

    public T createInstance() {
        try {
            return clazz.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Error while creating an instance.");
        }
    }

}
