package com.sidharth.attendancemeter;

/**
 * Created by Sidharth on 6/13/2017.
 */

public class Add {
    String roll;
    String name;
    String dob;
    String year;
    public Add(){

    }

    public Add(String name,String year,String roll,String dob){
        this.name=name;
        this.year=year;
        this.roll=roll;
        this.dob=dob;
    }

    public String getRoll() {
        return roll;
    }

    public String getName() {
        return name;
    }

    public String getDob() {
        return dob;
    }

    public String getYear() {
        return year;
    }
}

