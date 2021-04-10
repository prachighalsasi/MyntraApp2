package com.example.myntraapp;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("response")
    private String response;

    @SerializedName("user")
    private String user;

    public String getResponse()
    {
        return response;
    }

    public String getUser()
    {
        return user;
    }
}
