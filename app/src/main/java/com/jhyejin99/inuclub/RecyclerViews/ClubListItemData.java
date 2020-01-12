package com.jhyejin99.inuclub.RecyclerViews;

public class ClubListItemData {
    private String clubName;
    private String clubPlace;
    private int clubImage;

    public ClubListItemData(String clubName,String clubPlace, int clubImage){
        this.clubName = clubName;
        this.clubImage = clubImage;
        this.clubPlace = clubPlace;
    }

    public int getClubImage() {
        return clubImage;
    }

    public String getClubName() {
        return clubName;
    }

    public String getClubPlace() {
        return clubPlace;
    }

    public void setClubImage(int clubImage) {
        this.clubImage = clubImage;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public void setClubPlace(String clubPlace) {
        this.clubPlace = clubPlace;
    }
}
