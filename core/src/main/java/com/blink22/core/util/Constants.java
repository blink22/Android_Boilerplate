package com.blink22.core.util;

public interface Constants {
    String FAILURE_STATUS = "failure";
    int CODE_OK = 200;


    int NETWORK_CONNECTION_TIMEOUT = 30; // 30 sec
    long CACHE_SIZE = 10 * 1024 * 1024; // 10 MB
    int CACHE_MAX_AGE = 2; // 2 min
    int CACHE_MAX_STALE = 7; // 7 day
    int API_RETRY_COUNT = 3;

}
