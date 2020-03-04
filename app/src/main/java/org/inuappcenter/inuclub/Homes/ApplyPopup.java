package org.inuappcenter.inuclub.Homes;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import androidx.annotation.Nullable;

import org.inuappcenter.inuclub.R;

public class ApplyPopup extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //타이틀 없애고 윈도우창 full 사용 설정
        setContentView(R.layout.apply_popup);
    }

    public void OnClickDialog(View v) {
        switch (v.getId()) {
            case R.id.cancel:
                this.finish();
                break;
            case R.id.apply:
                //todo 지원서링크 연결
                Toast.makeText(getApplicationContext(),"지원서링크",Toast.LENGTH_LONG).show();
                break;

        }
    }
}
