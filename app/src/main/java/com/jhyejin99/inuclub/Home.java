package com.jhyejin99.inuclub;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ViewFlipper;


public class Home extends Fragment {
    ViewFlipper viewFlipper;
    RecyclerView rc;
    GridLayoutManager gridLayoutManager;

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

        rc = (RecyclerView)view.findViewById(R.id.cate_recycler);
        gridLayoutManager = new GridLayoutManager(getActivity(),3);


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
