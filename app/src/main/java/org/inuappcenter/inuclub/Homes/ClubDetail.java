package org.inuappcenter.inuclub.Homes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import androidx.annotation.Nullable;

import org.inuappcenter.inuclub.R;

public class ClubDetail extends Activity implements View.OnClickListener {
    ViewFlipper viewFlipper;
    TextView club_name;
    TextView club_place;
    ImageButton back;
    ImageButton apply;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.club_detail);

        Intent intent = getIntent();
        club_name = findViewById(R.id.club_detail_name);
        club_place = findViewById(R.id.club_place);
        club_place.setText(intent.getStringExtra("동아리방"));
        club_name.setText(intent.getStringExtra("동아리이름"));

        int images[] = {R.drawable.inu, R.drawable.club1};
        viewFlipper = findViewById(R.id.club_image_slide);
        for(int image : images) { flipperImages(image); }

        back = findViewById(R.id.club_detail_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        apply = findViewById(R.id.detail_apply);
        apply.setOnClickListener(this);


    }

    public void flipperImages(int image) {
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);
        viewFlipper.addView(imageView); // 이미지추가
        viewFlipper.setAutoStart(true);
        viewFlipper.setFlipInterval(5000);
    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(this,ApplyPopup.class));
    }
}
