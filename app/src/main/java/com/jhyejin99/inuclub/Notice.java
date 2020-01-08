package com.jhyejin99.inuclub;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Notice extends Fragment {

    RecyclerView rc_notice;
    public Notice() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.notice, container, false);
        rc_notice = (RecyclerView)view.findViewById(R.id.rc_notice);
        return view;
    }
}
