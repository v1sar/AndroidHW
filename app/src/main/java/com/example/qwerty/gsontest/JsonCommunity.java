package com.example.qwerty.gsontest;

import java.util.List;

/**
 * Created by qwerty on 24.11.16.
 */

public class JsonCommunity {
    @SuppressWarnings("unused")
    private long id;

    @SuppressWarnings("unused")
    private String name;

    @SuppressWarnings("unused")
    private long size;

    @SuppressWarnings("MismatchedReadAndWriteOfArray")
    private List<User> users;// = new User[0];

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getSize() {
        return size;
    }

    public List<User> getUsers() {
        return users;
    }
}
