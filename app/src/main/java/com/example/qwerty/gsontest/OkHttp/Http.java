package com.example.qwerty.gsontest.OkHttp;

import okhttp3.OkHttpClient;

/**
 * Created by qwerty on 24.11.16.
 */

public class Http {
    private static final OkHttpClient OK_HTTP_CLIENT = new OkHttpClient();

    public static OkHttpClient getClient() {
        return OK_HTTP_CLIENT;
    }
}
