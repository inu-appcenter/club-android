package org.inuappcenter.inuclub.RecyclerViews;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerItemDecoration extends RecyclerView.ItemDecoration {
    private int hWidth;
    private int vWidth;

    public RecyclerItemDecoration(int hWidth, int vWidth) {
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
