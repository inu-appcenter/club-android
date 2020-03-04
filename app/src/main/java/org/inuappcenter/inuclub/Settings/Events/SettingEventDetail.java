package org.inuappcenter.inuclub.Settings.Events;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;

import org.inuappcenter.inuclub.R;

public class SettingEventDetail extends Activity {
    ImageButton back;
    TextView name;
    TextView content;
    TextView place;
    TextView day;
    TextView hour;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set_event_detail);

        back= findViewById(R.id.event_detail_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
