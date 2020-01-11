package com.jhyejin99.inuclub.Settings;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;

import com.jhyejin99.inuclub.R;

public class Loading extends AppCompatActivity {

    String loadingText;
    String club_num;
    TextView loading;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loading);

        Intent intent = getIntent();
        loadingText = intent.getStringExtra("settingValue");
        club_num = intent.getStringExtra("clubIDNumber");

        OpenNext();
    }

    public void EditClub () {
        Intent intent = new Intent(Loading.this, SettingClubEdit.class);
        intent.putExtra("clubIDNumber",club_num);
        startActivity(intent);
        finish();
    }
    public void EditEvent () {
        Intent intent = new Intent(Loading.this, SettingEvent.class);
        intent.putExtra("clubIDNumber",club_num);
        startActivity(intent);
        finish();
    }

    public void Login () {
        Intent intent = new Intent(Loading.this, Login.class); //로그인클래스로 변경
        intent.putExtra("fromLoading",1);
        startActivity(intent);
        finish();
    }

    public void AlarmSet () {
        Intent intent = new Intent(Loading.this, SettingAlarm.class);
        intent.putExtra("fromLoading",1);
        startActivity(intent);
        finish();
    }

    /*public void Logout () {
        SharedPreferences savedToken = getSharedPreferences("loginToken", MODE_PRIVATE);
        SharedPreferences.Editor editor = savedToken.edit();
        editor.putString("savedID", "noID");
        editor.putString("savedPW", "noPW");
        editor.commit();
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        startActivity(intent);
        finish();
        MainActivity.mainActivity.finish(); //스택에 쌓인 뷰페이저 종료
    } */

    public void OpenNext() {
            switch (loadingText) {
                case "행사 관리":
                    EditEvent();
                    break;

                case "동아리 소개 수정":
                    EditClub();
                    break;

                case "알림 설정":
                    AlarmSet();
                    break;

                case "로그인":
                    Login();
                    break;

                /*case "로그아웃":
                    Logout();
                    break;*/

                default:
                    loading.setText("잘못된 접속입니다.");
                    break;
            }
    }
}
