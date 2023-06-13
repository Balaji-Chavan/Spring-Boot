package com.cjss.Task2.model;

import java.util.Map;

public class Marks {
    String sid;
    Map< Integer,String> marks;




    public Marks(String sid, Map<Integer, String> marks) {
        super();
        this.sid = sid;
        this.marks = marks;
    }
    public String getSid() {
        return sid;
    }
    public void setSid(String sid) {
        this.sid = sid;
    }
    public Map<Integer, String> getMarks() {
        return marks;
    }
    public void setMarks(Map<Integer, String> marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Marks{" +
                "sid='" + sid + '\'' +
                ", marks=" + marks +
                '}';
    }
}
