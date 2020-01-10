package com.jhyejin99.inuclub.Homes;

public class EventItemData {
    private String club;
    private String eventName;
    private String content;
    private int time;
    private int date;
    private String place;

    public EventItemData(String club, String eventName,String content, int time, int date, String place) {
        this.club = club;
        this.eventName = eventName;
        this.content = content;
        this.time = time;
        this.date = date;
        this.place = place;
    }

    public String getEventName() {
        return eventName;
    }

    public int getDate() {
        return date;
    }

    public int getTime() {
        return time;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public String getPlace() {
        return place;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
