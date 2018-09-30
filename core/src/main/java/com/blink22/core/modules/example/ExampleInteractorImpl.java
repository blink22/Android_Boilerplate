package com.blink22.core.modules.example;

import com.blink22.core.domain.client.ExampleApi;
import com.blink22.core.domain.model.BaseResponse;
import com.blink22.core.util.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.SingleSubject;

public class ExampleInteractorImpl implements ExampleContract.Interactor {

    private ExampleApi api;
    private SchedulerProvider scheduler;

    private SingleSubject<BaseResponse> exampleSubject;
    private Disposable exampleSubscription;

    @Inject
    ExampleInteractorImpl(ExampleApi api, SchedulerProvider scheduler) {
        this.api = api;
        this.scheduler = scheduler;
    }

    @Override
    public Single<BaseResponse> getData() {
        if (exampleSubscription == null || exampleSubscription.isDisposed()) {
            exampleSubject = SingleSubject.create();

            exampleSubscription = api.executeGetData()
                    .subscribeOn(scheduler.backgroundThread())
                    .subscribe(exampleSubject::onSuccess);
        }

        return exampleSubject.hide();
    }

    @Override
    public void unbind() {
        if (exampleSubscription != null && !exampleSubscription.isDisposed())
            exampleSubscription.dispose();
    }
}
