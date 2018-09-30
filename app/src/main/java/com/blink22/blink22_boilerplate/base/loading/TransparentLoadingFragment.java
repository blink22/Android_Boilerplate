package com.blink22.blink22_boilerplate.base.loading;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blink22.blink22_boilerplate.R;
import com.wang.avi.AVLoadingIndicatorView;

import butterknife.BindView;
import butterknife.ButterKnife;



/**
 * Created by m.hemdan on 11/30/17.
 */

public class TransparentLoadingFragment extends Fragment {
    public static String FRAGMENT_TAG = "TransparentLoadingFragment";

    @BindView(R.id.loading_view)
    AVLoadingIndicatorView loadingView;

    private static View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        if (view != null) {
            ViewGroup parent = (ViewGroup) view.getParent();
            if (parent != null)
                parent.removeView(view);
        }
        try {
            view = inflater.inflate(R.layout.fragment_loading,container, false);
            ButterKnife.bind(this, view);
            startLoading();
        } catch (InflateException e) {
        /* map is already there, just return view as it is */
        }
        return view;
    }


    private void startLoading() {
       loadingView.show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if(loadingView.isShown()){
            loadingView.hide();
        }
    }
}