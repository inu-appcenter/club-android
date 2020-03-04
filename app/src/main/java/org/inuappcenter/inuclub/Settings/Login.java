package org.inuappcenter.inuclub.Settings;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.Nullable;

import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import org.inuappcenter.inuclub.R;

public class Login extends Activity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        ImageView inu = findViewById(R.id.inu);
        EditText login_id = findViewById(R.id.login_id);
        EditText login_pw = findViewById(R.id.login_pw);
        ImageButton login = findViewById(R.id.login);
        ImageButton signup = findViewById(R.id.signup);
        ImageButton later = findViewById(R.id.later);
    }

}
