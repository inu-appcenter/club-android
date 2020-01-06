package com.dowls99.inuclub;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.dowls99.inuclub.Settings.Setting;

public class FragmentAdapter extends FragmentStatePagerAdapter {

    public FragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return new Home();
            case 1:
                return new Recruit();
            case 2:
                return new Notice();
            case 3:
                return new Setting();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 4;
    }
}
