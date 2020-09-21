package com.jhyejin99.inuclub;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.jhyejin99.inuclub.RecyclerViews.RecyclerViewAdapterR;

import java.util.ArrayList;

//TODO fab구현 위해 edit.xml 만들기. 위... 저거를... 하늘색...그거 고정시켜야 할까...?

public class Recruit extends Fragment {

    TabLayout.Tab tabIng;
    TabLayout.Tab tabDone;
    RecyclerViewAdapterR adapter;


    public Recruit() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        adapter = new RecyclerViewAdapterR();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recruit, container, false);
        initView(view);
        return view;
    }


    private void initView(View root) {
        // Tab
        TabLayout tabs = root.findViewById(R.id.tab_bar);

        tabIng = tabs.getTabAt(0);
        tabDone = tabs.getTabAt(1);

        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                onMoimTabChanged((tab == tabIng) ? TAB_ING : TAB_DONE);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        // RecyclerView
        RecyclerView rcv = root.findViewById(R.id.moim_recycler);
        rcv.setAdapter(adapter);

        onMoimTabChanged(1);
    }

    private void onMoimTabChanged(int tab) {
        ArrayList<String> d = new ArrayList<>();
        switch (tab) {
            case TAB_ING:
                d.add("모집 중인 투표");
                break;

            case TAB_DONE:
                d.add("마감된 투표");
                break;
        }

        adapter.setData(d);
    }

    private static final int TAB_ING = 1;
    private static final int TAB_DONE = 2;

}

