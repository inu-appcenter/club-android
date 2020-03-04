package org.inuappcenter.inuclub.RecyclerViews;

public class EventItemData {
    private String club;
    private String eventName;
    private String content;
    private int hour;
    private int minute;
    private int month;
    private int day;
    private String place;

    public EventItemData(String club, String eventName, String content, int hour, int day, String place) {
        this.club = club;
        this.eventName = eventName;
        this.content = content;
        this.hour = hour;
        this.day = day;
        this.place = place;
    }

    public String getEventName() {
        return eventName;
    }

    public int getDay() {
        return day;
    }

    public int getHour() {
        return hour;
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

    public void setDay(int day) {
        this.day = day;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
