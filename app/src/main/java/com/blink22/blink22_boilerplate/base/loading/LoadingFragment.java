package com.blink22.blink22_boilerplate.base.loading;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blink22.blink22_boilerplate.R;
import com.wang.avi.AVLoadingIndicatorView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by m.hemdan on 9/18/17.
 */

public class LoadingFragment extends Fragment {
    public static String FRAGMENT_TAG = "LoadingFragmentDialog";
    @BindView(R.id.loading_view)
    AVLoadingIndicatorView loadingView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment_loading, null);
        ButterKnife.bind(this,view);
        startLoading();
        return view;
    }

    public void startLoading(){
        loadingView.show();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        if(loadingView.isShown()){
            loadingView.hide();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if(loadingView.isShown()){
            loadingView.hide();
        }
    }
}
