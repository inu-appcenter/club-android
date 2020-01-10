package com.jhyejin99.inuclub;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.jhyejin99.inuclub.Settings.Setting;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    private FragmentManager fragmentManager = getSupportFragmentManager();
    private Home home = new Home();
    private Recruit recruit = new Recruit();
    private Notice notice = new Notice();
    private Setting setting = new Setting();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottom_nav);
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frameLayout,home).commitAllowingStateLoss();
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                switch (menuItem.getItemId()) {
                    case R.id.home_menu: {
                        transaction.replace(R.id.frameLayout, home).commitAllowingStateLoss();
                        break;
                    }
                    case R.id.recruit_menu: {
                        transaction.replace(R.id.frameLayout, recruit).commitAllowingStateLoss();
                        break;
                    }
                    case R.id.notice_menu: {
                        transaction.replace(R.id.frameLayout, notice).commitAllowingStateLoss();
                        break;
                    }
                    case R.id.setting_menu: {
                        transaction.replace(R.id.frameLayout, setting).commitAllowingStateLoss();
                        break;
                    }
                }
                return true;
            }
        });
    }
}
