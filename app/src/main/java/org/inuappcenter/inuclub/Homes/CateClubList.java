package org.inuappcenter.inuclub.Homes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.inuappcenter.inuclub.R;
import org.inuappcenter.inuclub.RecyclerViews.ClubListItemData;
import org.inuappcenter.inuclub.RecyclerViews.RecyclerItemDecoration;
import org.inuappcenter.inuclub.RecyclerViews.RecyclerViewAdapterL;

import java.util.ArrayList;

public class CateClubList extends Activity {

    RecyclerView rc;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    TextView cateName;
    TextView cateCount;
    ImageButton backbtn;

    private ArrayList<ClubListItemData> list;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cate_club_list);

        Intent intent = getIntent();
        String cate = intent.getStringExtra("카테고리");
        String count = String.valueOf(intent.getIntExtra("동아리 개수",0));

        backbtn = findViewById(R.id.backbtn);
        cateName = findViewById(R.id.cate);
        cateCount = findViewById(R.id.cate_club_count);
        cateName.setText(cate);
        cateCount.setText(count);

        //todo 서버에서 카테고리에 해당하는 동아리들 이름, 동방, 사진 불러와서 list에 추가
        list = new ArrayList<ClubListItemData>();
        list.add(new ClubListItemData("싸우라비","17호관 301호",R.drawable.club1));
        list.add(new ClubListItemData("싸우라비","17호관 301호",R.drawable.club1));
        list.add(new ClubListItemData("싸우라비","17호관 301호",R.drawable.club1));
        list.add(new ClubListItemData("싸우라비","17호관 301호",R.drawable.club1));
        list.add(new ClubListItemData("싸우라비","17호관 301호",R.drawable.club1));
        list.add(new ClubListItemData("싸우라비","17호관 301호",R.drawable.club1));
        list.add(new ClubListItemData("싸우라비","17호관 301호",R.drawable.club1));
        rc = findViewById(R.id.cate_club_recycler);
        rc.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        rc.setLayoutManager(layoutManager);
        adapter = new RecyclerViewAdapterL(list);
        rc.setAdapter(adapter);
        rc.addItemDecoration(new RecyclerItemDecoration(0,12));

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
