package org.inuappcenter.inuclub;

import androidx.annotation.NonNull;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;
import android.view.MenuItem;

import org.inuappcenter.inuclub.Homes.Home;

import org.inuappcenter.inuclub.R;

import org.inuappcenter.inuclub.Settings.Setting;

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

        //스플래시
        Intent intent = new Intent(this,Splash.class);
        startActivity(intent);

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
