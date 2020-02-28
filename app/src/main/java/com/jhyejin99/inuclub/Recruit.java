package com.jhyejin99.inuclub;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.jhyejin99.inuclub.RecyclerViews.RecyclerViewAdapterR;

import java.util.ArrayList;
import java.util.List;

public class Recruit extends Fragment {

    TabLayout.Tab tabIng;
    TabLayout.Tab tabDone;
    RecyclerViewAdapterR adapter;
    FloatingActionButton recruit_fab;

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

        recruit_fab = (FloatingActionButton) root.findViewById(R.id.recruit_fab);
        // RecyclerView
        /*RecyclerView rcv = root.findViewById(R.id.moim_recycler);
        rcv.setAdapter(adapter);

        onMoimTabChanged(1);

        //for spinner array
        spinner = root.findViewById(R.id.spinner_member);
        List<Integer> members = new ArrayList<>();
        members.add(0);
        for(int i = 5; i <= 20; i = i+5){
            members.add(i);
        }
        ArrayAdapter dataAdapter;
        dataAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item, members);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(dataAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if(parent.getItemAtPosition(position).equals(0)){
                    //do nothing
                }

                else{
                    int item = (int)parent.getItemAtPosition(position);

                    Toast.makeText(parent.getContext(), item + "선택", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });*/
    }

    private void initListener() {
        recruit_fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MakeVoteActivity.class);
                startActivity(intent);
            }
        });
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

