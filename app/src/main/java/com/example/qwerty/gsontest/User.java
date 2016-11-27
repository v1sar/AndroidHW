package com.example.qwerty.gsontest;

import android.graphics.Canvas;

import com.google.common.base.Function;
import com.google.common.collect.Ordering;
import com.google.gson.annotations.SerializedName;



/**
 * Created by qwerty on 24.11.16.
 */

public class User {
    @SuppressWarnings("unused")
    private String fullname;

    @SuppressWarnings("unused")
    private int age;

    @SuppressWarnings("unused")
    private float weight;

    @SuppressWarnings("unused")
    private Gender gender;

    @SuppressWarnings("unused")
    private boolean married;

    @SuppressWarnings("unused")
    @SerializedName("protected")
    private String prot;

    public float getWeight() {
        return weight;
    }

    public Gender getGender() {
        return gender;
    }

    static Function<User, Gender> onGender = new Function<User, Gender>() {
        @Override
        public Gender apply(User input) {
            return input.gender;
        }
    };

    public enum Gender {
        MALE, FEMALE, NOT_SURE;

        static Ordering<Gender> genderOrder = Ordering.explicit(Gender.NOT_SURE, Gender.MALE, Gender.FEMALE);
    }
}
