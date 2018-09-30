package com.blink22.blink22_boilerplate.base.fragment;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.blink22.blink22_boilerplate.AppInstance;
import com.blink22.blink22_boilerplate.base.BaseActivity;
import com.blink22.core.base.BaseView;

public abstract class BaseFragment extends Fragment implements BaseView{

    @Override
    public void showError(Throwable throwable) {
        ((BaseActivity)getActivity()).showError(throwable);
    }

    @Override
    public void showMessage(String message) {
        ((BaseActivity)getActivity()).showMessage(message);
    }

    @Override
    public void showServerDownError() {
        ((BaseActivity)getActivity()).showServerDownError();
    }

    @Override
    public void showOfflineMessage() {
        ((BaseActivity)getActivity()).showOfflineMessage();
    }

    @Override
    public void showLoading() {
        ((BaseActivity)getActivity()).showLoading();
    }

    @Override
    public void hideLoading() {
        ((BaseActivity)getActivity()).hideLoading();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        injectDependencies(AppInstance.get(getContext()));
    }
    protected abstract void injectDependencies(AppInstance application);
}
