package com.example.bt1;

import java.io.Serializable;

public class Student implements Serializable {
    private String mssv;
    private String hoten;
    private String lop;
    private double gpa;

    public Student() {
    }

    public Student(String mssv, String hoten, String lop, double gpa) {
        this.mssv = mssv;
        this.gpa = gpa;
        this.hoten = hoten;
        this.lop = lop;

    }

    // Getter và Setter
    public String getMssv() {
        return mssv;
    }

    public void setMssv(String mssv) {
        this.mssv = mssv;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return hoten + " (" + mssv + ") - GPA: " + gpa;
    }
}
