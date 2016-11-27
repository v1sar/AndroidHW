package com.example.qwerty.gsontest;


import android.location.GnssClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.qwerty.gsontest.OkHttp.UrlDownloader;
import com.google.common.base.Function;
import com.google.common.collect.Ordering;

import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String url = "https://json-storage.herokuapp.com/community/154";
    private static String json;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadJson();
    }

    private void loadJson() {
        final JsonParser parser = new JsonParser();
        UrlDownloader.getInstance().load(url);
        UrlDownloader.getInstance().setCallback(new UrlDownloader.Callback() {
            @Override
            public void onLoaded(String key, String value) {
                json = value;
                System.out.println(json);

                JsonCommunity jsonCommunity = parser.parse(json);
                System.out.println("hello");

                Ordering<User> primary = Ordering.natural().onResultOf(new Function<User, Integer>() {
                    @Override
                    public Integer apply(User input) {
                        switch (input.getGender()) {
                            case NOT_SURE: return 1;
                            case MALE: return 2;
                            case FEMALE: return 3;
                        }
                        return null;
                    }
                });
                Ordering<User> secondary = Ordering.natural().onResultOf(new Function<User, Float>() {
                    @Override
                    public Float apply(User user) {
                        return user.getWeight();
                    }
                });
                Ordering<User> compound = primary.compound(secondary);
                List<User> usersTemp = jsonCommunity.getUsers();
                Collections.sort(usersTemp, compound);
                System.out.println(usersTemp);

            }
        });
    }
}
