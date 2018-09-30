package com.blink22.blink22_boilerplate.base.loading;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.view.ViewGroup;

import com.blink22.blink22_boilerplate.R;
import com.wang.avi.AVLoadingIndicatorView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by m.hemdan on 8/30/17.
 */

public class LoadingFragmentDialog extends DialogFragment {
    public static String FRAGMENT_TAG = "LoadingFragmentDialog";
    @BindView(R.id.loading_view)
    AVLoadingIndicatorView loadingView;
    @Override
    public void onResume()
    {
        super.onResume();
        getDialog().getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setStyle(DialogFragment.STYLE_NO_FRAME, android.R.style.Theme);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.requestWindowFeature(DialogFragment.STYLE_NO_TITLE);
        View view = View.inflate(getActivity(), R.layout.dialog_loading, null);
        dialog.setContentView(view);
        ButterKnife.bind(this,view);
        startLoading();
        return dialog;
    }
    private void startLoading(){
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
