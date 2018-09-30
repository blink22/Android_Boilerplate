package com.blink22.core.modules.example;

import com.blink22.core.base.BaseInteractor;
import com.blink22.core.base.BasePresenter;
import com.blink22.core.base.BaseView;
import com.blink22.core.domain.model.BaseResponse;

import io.reactivex.Single;

public interface ExampleContract {
    interface View extends BaseView{

//        void setExample(ExampleModel example);
        void setExample(BaseResponse example);
    }

    interface Presenter extends BasePresenter<ExampleContract.View> {
        void getData(boolean isConnected);
    }

    interface Interactor extends BaseInteractor{
        Single<BaseResponse> getData();
    }

}
