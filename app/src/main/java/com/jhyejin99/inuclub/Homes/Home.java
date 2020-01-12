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

import com.jhyejin99.inuclub.RecyclerViews.EventItemData;
import com.jhyejin99.inuclub.R;
import com.jhyejin99.inuclub.RecyclerViews.CateItemData;
import com.jhyejin99.inuclub.RecyclerViews.RecyclerItemDecoration;
import com.jhyejin99.inuclub.RecyclerViews.RecyclerViewAdapterC;
import com.jhyejin99.inuclub.RecyclerViews.RecyclerViewAdapterE;

import java.util.ArrayList;


public class Home extends Fragment {
    ViewFlipper viewFlipper;
    RecyclerView cate_rc,event_rc;
    RecyclerView.Adapter adapterc, adaptere;
    RecyclerView.LayoutManager layoutManagerc, layoutManagere;
    private ArrayList<CateItemData> cateList; // 카테고리 리싸이클러뷰 아이템 리스트
    private ArrayList<EventItemData> eventList; // 이달의 행사 리싸이클러뷰 아이템 리스트

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

        //todo 서버에서 카테고리별 동아리 개수 불러와 변수에 저장
        cateList = new ArrayList<CateItemData>();
        cateList.add(new CateItemData("스포츠",R.drawable.soccer2x,15));
        cateList.add(new CateItemData("종교",R.drawable.pray2x,10));
        cateList.add(new CateItemData("문화",R.drawable.party2x,23));
        cateList.add(new CateItemData("봉사",R.drawable.love2x,19));
        cateList.add(new CateItemData("취미/전시",R.drawable.card2x,9));
        cateList.add(new CateItemData("학술/교양",R.drawable.soccer2x,11));

        // 카테고리 리싸이클러뷰
        cate_rc = view.findViewById(R.id.cate_recycler);
        cate_rc.setHasFixedSize(true); //고정된 크기 가짐
        layoutManagerc = new GridLayoutManager(getActivity(),3);
        cate_rc.setLayoutManager(layoutManagerc);
        adapterc = new RecyclerViewAdapterC(cateList);
        cate_rc.setAdapter(adapterc);
        cate_rc.addItemDecoration(new RecyclerItemDecoration(10,12));

        //todo 서버에서 이달의 행사 정보(동아리이름, 행사이름, 내용, 시간, 날짜, 장소) 불러와서 리스트에 추가
        eventList = new ArrayList<EventItemData>();
        eventList.add(new EventItemData("싸우라비","개강총회","개강총회입니다",19,6,"구석탱이"));
        eventList.add(new EventItemData("싸우라비","개강총회","개강총회입니다",19,6,"구석탱이"));
        eventList.add(new EventItemData("싸우라비","개강총회","개강총회입니다",19,6,"구석탱이"));
        eventList.add(new EventItemData("싸우라비","개강총회","개강총회입니다",19,6,"구석탱이"));
        eventList.add(new EventItemData("싸우라비","개강총회","개강총회입니다",19,6,"구석탱이"));
        eventList.add(new EventItemData("싸우라비","개강총회","개강총회입니다",19,6,"구석탱이"));
        eventList.add(new EventItemData("싸우라비","개강총회","개강총회입니다",19,6,"구석탱이"));
        eventList.add(new EventItemData("싸우라비","개강총회","개강총회입니다",19,6,"구석탱이"));

        // 이 달의 행사 리싸이클러뷰
        event_rc = view.findViewById(R.id.event_recycler);
        event_rc.setHasFixedSize(true);
        layoutManagere = new LinearLayoutManager(getActivity());
        event_rc.setLayoutManager(layoutManagere);
        adaptere = new RecyclerViewAdapterE(eventList);
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
