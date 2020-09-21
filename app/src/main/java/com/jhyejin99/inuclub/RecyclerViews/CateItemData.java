package com.jhyejin99.inuclub.RecyclerViews;

import android.graphics.drawable.Drawable;

public class CateItemData {
    public String name; //카테고리 이름
    public int imageNum; //카테고리 이미지
    public int count; //카테고리에 속한 동아리 개수

    public CateItemData(String name, int imageNum, int count) {
        this.name = name;
        this.imageNum = imageNum;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public int getImageNum() {
        return imageNum;
    }

    public int getCount() {
        return count;
    }

    public void setImageNum(int imageNum) {
        this.imageNum = imageNum;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCount(int count) {
        this.count = count;
    }

}
