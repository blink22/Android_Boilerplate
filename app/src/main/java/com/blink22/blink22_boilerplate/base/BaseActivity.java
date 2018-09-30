package com.blink22.blink22_boilerplate.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.blink22.blink22_boilerplate.AppInstance;
import com.blink22.blink22_boilerplate.ApplicationComponent;
import com.blink22.blink22_boilerplate.R;
import com.blink22.blink22_boilerplate.base.loading.LoadingFragmentDialog;
import com.blink22.core.base.BaseView;
import com.tapadoo.alerter.Alerter;
import com.tapadoo.alerter.OnHideAlertListener;

public abstract class BaseActivity extends AppCompatActivity implements BaseView{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        injectDependencies(AppInstance.get(this),AppInstance.getComponent());
    }
    protected abstract void injectDependencies(AppInstance application, ApplicationComponent component);


    @Override
    public void showError(Throwable throwable) {
        showMessage(throwable.getMessage());
    }

    @Override
    public void showMessage(String message) {
        Alerter.create(this)
                .setText(message)
                .setBackgroundColorRes(R.color.colorPrimaryDark)
                .setDuration(2000)
                .enableSwipeToDismiss()
                .enableVibration(true)
                .setOnHideListener(new OnHideAlertListener() {
                    @Override
                    public void onHide() {
                        Alerter.hide();
                    }
                })
                .show();
    }


    @Override
    public void showServerDownError() {
//        showMessage(getResources().getString(R.string.app_server_down_error));

    }

    @Override
    public void showOfflineMessage() {
//        showMessage(getResources().getString(R.string.app_connectivity_error));
    }

    @Override
    public void showLoading() {
        LoadingFragmentDialog fragment = (LoadingFragmentDialog) getSupportFragmentManager().findFragmentByTag(LoadingFragmentDialog.FRAGMENT_TAG);
        if (fragment == null) {
            fragment = new LoadingFragmentDialog();
            fragment.setCancelable(false);
            getSupportFragmentManager().beginTransaction()
                    .add(fragment, LoadingFragmentDialog.FRAGMENT_TAG)
                    .commitAllowingStateLoss();
            }
    }

    @Override
    public void hideLoading() {
        LoadingFragmentDialog fragment = (LoadingFragmentDialog) getSupportFragmentManager().findFragmentByTag(LoadingFragmentDialog.FRAGMENT_TAG);
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction().remove(fragment).commitAllowingStateLoss();
        }
    }
}
