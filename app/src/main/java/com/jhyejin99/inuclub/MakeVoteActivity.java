package com.jhyejin99.inuclub;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MakeVoteActivity extends AppCompatActivity {
   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recruit_makevote);

        initView(findViewById(R.id.root));
    }

    /**
     * view를 초기화한다.
     * 여기서 view에 대한 모든 것들을 다한다.
     * 이를테면 spinner, clickListener, editText 의 filter 넣기
     * @param view 이 activity 의 root view
     */
    private void initView(View view){
        //뷰  5개를 가져와서 변수에 담기
        //editText 에는 필터 적용하기
        //spinner 에는 선택된 행동 지정하기(값 확보)
    }

    /**
     * 5개의 view 로부터 값을 읽는다.
     * 입력 체크도 한다.(유효성 검사)
     * 입력이 모두 올바를 경우 서버로 보낸다.
     * 입력이 틀릴 경우 사용자에게 알린다.
     */
    private void submit(){
        //뷰 5개를 다시 가져올 것
        //뷰 전체 유효성 검사
        boolean isValid = false;
        if(isValid){
            //뷰의 값 5개를 다시 가져올 것 (initView 값을 field 로 갖고와서 재활용)
            //서버에 해당 값들을 던지고 지지고볶고 한다.(다른 함수 대체도 고려해볼 것)
        }
        else{
            //사용자에게 경고를 띄운다.
        }
    }
}
