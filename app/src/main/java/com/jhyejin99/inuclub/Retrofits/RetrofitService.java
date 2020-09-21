package com.jhyejin99.inuclub.Retrofits;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RetrofitService {

    //로그인
    @FormUrlEncoded
    @POST("/account/signIn")
    Call<LoginResponse> login(@Field("id") String id, @Field("passwd") String passwd);
}
