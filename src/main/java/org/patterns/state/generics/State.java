package org.patterns.state.generics;

public interface State<T> {
    void handle(Context<T> context);
}
