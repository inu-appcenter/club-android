package com.jhyejin99.inuclub;

import android.app.Activity;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;

public class MainActivity extends FragmentActivity {

    ViewPager viewPager;
    TabLayout tabLayout;
    public static int fragmentPosition;
    public static Activity mainActivity; // 종료하려고

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainActivity = MainActivity.this;

        fragmentPosition = 0;
        viewPager = (ViewPager)findViewById(R.id.viewPager);
        tabLayout=(TabLayout)findViewById(R.id.tabLayout);
        viewPager=(ViewPager)findViewById(R.id.viewPager);

        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_home),0,true);
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_recruit),1);
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_notice),2);
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_set),3);

        viewPager.setAdapter(new FragmentAdapter(getSupportFragmentManager()));
        viewPager.setOffscreenPageLimit(4);
        tabLayout.addOnTabSelectedListener(pagerListener);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

    }

    TabLayout.OnTabSelectedListener pagerListener = new TabLayout.OnTabSelectedListener() {
        @Override
        public void onTabSelected(TabLayout.Tab tab) {
            viewPager.setCurrentItem(tab.getPosition()); // 위에 페이지를 선택했을 떄도 페이지 이동 가능하도록
        }

        @Override
        public void onTabUnselected(TabLayout.Tab tab) {

        }

        @Override
        public void onTabReselected(TabLayout.Tab tab) {

        }
    };

    @Override
    protected void onResume() {
        super.onResume();

    }
}
