package com.jhyejin99.inuclub.Retrofits;

import com.google.gson.annotations.SerializedName;

public class Login {

    @SerializedName("id")
    private String id;

    @SerializedName("passwd")
    private String passwd;

    public String getId() {
        return id;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
