package com.example.hp.mycalendarproject;

public class MonthItemData {
    private int dayValue;
    private boolean eventExist;
    private String eventThing;

    public MonthItemData() {
    }

    public MonthItemData(int dayValue) {
        this.dayValue = dayValue;
        this.eventExist = false;
        this.eventThing = null;
    }

    public boolean isEventExist() {
        return eventExist;
    }

    public void setEventExist(boolean eventExist) {
        this.eventExist = eventExist;
    }

    public String getEventThing() {
        return eventThing;
    }

    public void setEventThing(String eventThing) {
        this.eventThing = eventThing;
    }

    public int getDayValue() {
        return dayValue;
    }

    public void setDayValue(int dayValue) {
        this.dayValue = dayValue;
    }
}

