package com.jhyejin99.inuclub.Homes;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CateItemDecoration extends RecyclerView.ItemDecoration {
    private int hWidth;
    private int vWidth;

    public CateItemDecoration(int hWidth, int vWidth) {
        this.hWidth = hWidth;
        this.vWidth = vWidth;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        outRect.left=hWidth;
        outRect.right=hWidth;
        outRect.top=vWidth;
        outRect.bottom=vWidth;
    }
}
