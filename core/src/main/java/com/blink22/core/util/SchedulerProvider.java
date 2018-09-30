package com.blink22.core.util;


import io.reactivex.Scheduler;

/**
 * Created by m.hemdan on 8/15/17.
 */

public interface SchedulerProvider {

    Scheduler mainThread();

    Scheduler backgroundThread();

}