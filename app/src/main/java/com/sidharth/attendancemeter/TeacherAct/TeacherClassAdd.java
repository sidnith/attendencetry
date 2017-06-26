package com.sidharth.attendancemeter.TeacherAct;

/**
 * Created by Sidharth on 6/25/2017.
 */

public class TeacherClassAdd {
    String year;
    String section;
    String no;
    String title;
    public TeacherClassAdd(){

    }


    public TeacherClassAdd(String year, String section, String no, String title){
        this.year=year;
        this.section=section;
        this.no=no;
        this.title=title;

    }

    public String getYear() {
        return year;
    }

    public String getSection() {
        return section;
    }

    public String getNo() {
        return no;
    }

    public String getTitle() {
        return title;
    }

}
