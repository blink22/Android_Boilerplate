package com.blink22.core.base;

public interface BasePresenter<T> {
    void bind(T view);
    void unbind();
}
