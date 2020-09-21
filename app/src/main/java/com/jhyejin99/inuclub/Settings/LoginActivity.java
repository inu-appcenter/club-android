package com.jhyejin99.inuclub.Settings;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.Nullable;

import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.jhyejin99.inuclub.R;
import com.jhyejin99.inuclub.Retrofits.LoginResponse;
import com.jhyejin99.inuclub.Retrofits.RetrofitHelper;
import com.jhyejin99.inuclub.Retrofits.RetrofitService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends Activity implements View.OnClickListener {

    EditText login_id, login_pw;
    String id,passwd;
    ImageButton later, login, signup;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);


        login = findViewById(R.id.login);
        login.setOnClickListener(this);

        signup = findViewById(R.id.signup);
        later = findViewById(R.id.later);
        later.setOnClickListener(this);
        login_id = findViewById(R.id.login_id);
        login_pw = findViewById(R.id.login_pw);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login:
            {
                RetrofitService retrofitService = RetrofitHelper.create();
                id = login_id.getText().toString();
                passwd = login_pw.getText().toString();
                retrofitService.login(id,passwd).enqueue(new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                        if(response.isSuccessful()){
                            String result = response.body().getToken();
                            Log.d("loginResult", result);
                            Toast.makeText(getApplicationContext(),"로그인 되었습니다.",Toast.LENGTH_SHORT).show();
                            finish();
                        }

                        else{
                            Toast.makeText(getApplicationContext(),"아이디 또는 비밀번호를 확인해주세요.",Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<LoginResponse> call, Throwable t) {


                    }
                });
            }
            case R.id.later:
                finish();
        }
    }
}
