package org.inuappcenter.inuclub;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.inuappcenter.inuclub.R;

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
