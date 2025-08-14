package org.patterns.state.generics;

public interface Context<T> {
    void setState(State<T> newState);
    T getData(); // Example: context might hold some data
}