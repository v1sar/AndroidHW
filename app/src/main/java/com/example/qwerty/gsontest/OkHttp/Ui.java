package com.example.qwerty.gsontest.OkHttp;

import android.os.Handler;
import android.os.Looper;

/**
 * Created by qwerty on 24.11.16.
 */

public class Ui {
    private static final Handler HANDLER = new Handler(Looper.getMainLooper());

    public static void run(Runnable runnable) {
        HANDLER.post(runnable);
    }
}
