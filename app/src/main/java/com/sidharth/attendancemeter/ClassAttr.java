package com.sidharth.attendancemeter;

/**
 * Created by Sidharth on 6/26/2017.
 */

public class ClassAttr {
    private String title;
    private String year;
    private String no;

    public ClassAttr(String title, String year, String no) {
        this.title = title;
        this.year = year;
        this.no = no;
    }

    public ClassAttr(){

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }
}
