package com.example.qwerty.gsontest;

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

    public enum Gender {
        MALE, FEMALE, NOT_SURE;
    }
}
