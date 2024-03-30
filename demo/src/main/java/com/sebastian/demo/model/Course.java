package com.sebastian.demo.model;

public class Course {
    private int id;
    private String name;
    private int duration;
    private String schedule;

    public Course(int id, String name, int duration, String schedule) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.schedule = schedule;
    }
    public Course(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }
}
