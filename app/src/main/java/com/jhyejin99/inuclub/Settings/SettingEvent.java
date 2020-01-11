package com.jhyejin99.inuclub.Settings;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.ImageButton;

import com.jhyejin99.inuclub.RecyclerViews.EventItemData;
import com.jhyejin99.inuclub.RecyclerViews.RecyclerViewAdapterE;
import com.jhyejin99.inuclub.R;
import com.jhyejin99.inuclub.Settings.Events.SettingEventAdd;

import java.util.ArrayList;

public class SettingEvent extends Activity {

    RecyclerView rc;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    private ArrayList<EventItemData> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set_event);

        list = new ArrayList<>();
        list.add(new EventItemData("싸우라비","개강총회","개강총회입니다",19,6,"구석탱이"));
        list.add(new EventItemData("싸우라비","개강총회","개강총회입니다",19,6,"구석탱이"));
        list.add(new EventItemData("싸우라비","개강총회","개강총회입니다",19,6,"구석탱이"));
        list.add(new EventItemData("싸우라비","개강총회","개강총회입니다",19,6,"구석탱이"));
        list.add(new EventItemData("싸우라비","개강총회","개강총회입니다",19,6,"구석탱이"));

        rc = findViewById(R.id.rc_event_list);
        rc.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        adapter = new RecyclerViewAdapterE(list);
        rc.setLayoutManager(layoutManager);
        rc.setAdapter(adapter);


        ImageButton event_add_btn1 = (ImageButton) findViewById(R.id.event_add_btn1);
        ImageButton event_back = (ImageButton)findViewById(R.id.event_edit_back);

        event_add_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingEvent.this, SettingEventAdd.class);
                startActivity(intent);
            }
        });
    }
}
