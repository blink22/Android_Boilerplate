package com.blink22.core.modules.example;

import com.blink22.core.domain.exceptions.ApiResponseCodeException;
import com.blink22.core.domain.mapper.Mapper;
import com.blink22.core.util.Constants;
import com.blink22.core.util.DataBaseHelper;
import com.blink22.core.util.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;


public class ExamplePresenterImpl implements ExampleContract.Presenter {


    @Inject
    ExampleContract.Interactor interactor;

    @Inject
    DataBaseHelper databaseHelper;

    private ExampleContract.View view;
    private Disposable disposable;
    private SchedulerProvider scheduler;


    @Inject
    public ExamplePresenterImpl(SchedulerProvider scheduler) {
        this.scheduler = scheduler;
    }

    @Override
    public void bind(ExampleContract.View view) {
        this.view = view;
    }

    @Override
    public void unbind() {
        if (disposable != null && !disposable.isDisposed())
            disposable.dispose();

        interactor.unbind();

        view = null;
    }

    @Override
    public void getData(boolean isConnected) {
        if (null != view) {
            view.showLoading();
        }

        disposable = interactor.getData()
                // check if result code is OK
                .map(baseResponse -> {
                    if (Constants.CODE_OK == baseResponse.getCode())
                        return baseResponse;
                    else
                        throw Exceptions.propagate(new ApiResponseCodeException(baseResponse.getCode(), baseResponse.getStatus()));
                })
                // check if is there any result
                .map(baseResponse -> {
//                    if (baseResponse.getData() > 0)
//                        return baseResponse;
//                    else
//                        throw Exceptions.propagate(new NoSuchCharacterException());
                    return baseResponse;
                })
                // map BaseResponse to corresponding Model
//                .map(Mapper::mapBaseResponseResponseToExample)
                // cache data on database
                .map(exampleModel -> {
//                    try {
//                        databaseHelper.addExample(example);
//                    } catch (SQLException e) {
//                        throw Exceptions.propagate(e);
//                    }

                    return exampleModel;
                })
                .observeOn(scheduler.mainThread())
                .subscribe(exampleModel -> {
                            if (null != view) {
                                view.hideLoading();
                                view.setExample(exampleModel);

                                if (!isConnected)
                                    view.showOfflineMessage();
                            }
                        },
                        // handle exceptions
                        throwable -> {
                            if (null != view) {
                                view.hideLoading();

                                if (isConnected) {
                                    if (throwable instanceof ApiResponseCodeException)
                                        view.showError((ApiResponseCodeException) throwable);
                                   else
                                        view.showServerDownError();

                                } else {
                                    view.showOfflineMessage();
                                }
                            }
                        });
    }
}
