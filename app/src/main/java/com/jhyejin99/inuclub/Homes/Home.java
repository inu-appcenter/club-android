package com.jhyejin99.inuclub.Homes;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.jhyejin99.inuclub.R;


public class Home extends Fragment {
    ViewFlipper viewFlipper;
    RecyclerView cate_rc,event_rc;
    RecyclerView.Adapter adapterc, adaptere;
    RecyclerView.LayoutManager layoutManagerc, layoutManagere;

    public Home() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState); }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home, container, false);
        // 광고 배너 슬라이드
        int images[] = {R.drawable.inu, R.drawable.peoplex3};
        viewFlipper = view.findViewById(R.id.banner_slide);
        for(int image : images) { flipperImages(image); }

        cate_rc = view.findViewById(R.id.cate_recycler);
        cate_rc.setHasFixedSize(true); //고정된 크기 가짐

        layoutManagerc = new GridLayoutManager(getActivity(),3);
        cate_rc.setLayoutManager(layoutManagerc);
        adapterc = new RecyclerViewAdapterC();
        cate_rc.setAdapter(adapterc);
        cate_rc.addItemDecoration(new CateItemDecoration(8,12));

        event_rc = view.findViewById(R.id.event_recycler);
        event_rc.setHasFixedSize(true);
        layoutManagere = new LinearLayoutManager(getActivity());
        event_rc.setLayoutManager(layoutManagere);
        adaptere = new RecyclerViewAdapterE();
        event_rc.setAdapter(adaptere);


    return view;
    }

    public void flipperImages(int image) {
        ImageView imageView = new ImageView(getActivity());
        imageView.setBackgroundResource(image);
        viewFlipper.addView(imageView); // 이미지추가
        viewFlipper.setFlipInterval(4000); // 자동 이미지 슬라이드 딜레이시간 (1000당 1초)
        viewFlipper.setAutoStart(true); // 자동슬라이드
    }
}
