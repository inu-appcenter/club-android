package com.jhyejin99.inuclub.Retrofits;

import com.google.gson.annotations.SerializedName;

public class LoginResponse {

    @SerializedName("token")
    private String token;

    public String getToken() {
        return token;
    }
}
