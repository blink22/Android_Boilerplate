package com.blink22.core.base;

public interface BaseView {
    void showError(Throwable throwable);
    void showMessage(String message);
    void showServerDownError();
    void showOfflineMessage();
    void showLoading();
    void hideLoading();
}
