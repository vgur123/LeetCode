package org.patterns.factory;

public interface Notifier<T> {
    void notify(T obj);
}
