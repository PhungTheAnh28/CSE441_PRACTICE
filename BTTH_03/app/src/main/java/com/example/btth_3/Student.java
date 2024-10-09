//package com.example.btth_03;
//
//import java.io.Serializable;
//
//public class Student implements Serializable {
//    private String id;
//    private FullName fullName;
//    private String gender;
//    private String birthDate;
//    private String email;
//    private String address;
//    private String major;
//    private double gpa;
//    private int year;
//
//    // Inner class FullName
//    public static class FullName {
//        private String first;
//        private String midd;
//        private String last;
//
//        public FullName(String first, String midd, String last) {
//            this.first = first;
//            this.midd = midd;
//            this.last = last;
//        }
//
//        public String getFirst() {
//            return first;
//        }
//
//        public void setFirst(String first) {
//            this.first = first;
//        }
//
//        public String getMidd() {
//            return midd;
//        }
//
//        public void setMidd(String midd) {
//            this.midd = midd;
//        }
//
//        public String getLast() {
//            return last;
//        }
//
//        public void setLast(String last) {
//            this.last = last;
//        }
//    }
//
//    // Constructor của lớp Student
//    public Student(String id, FullName fullName, String gender, String birthDate, String email, String address, String major, double gpa, int year) {
//        this.id = id;
//        this.fullName = fullName;  // Truyền vào một đối tượng FullName
//        this.gender = gender;
//        this.birthDate = birthDate;
//        this.email = email;
//        this.address = address;
//        this.major = major;
//        this.gpa = gpa;
//        this.year = year;
//    }
//
//    // Getters và Setters cho các trường
//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public FullName getFullName() {
//        return fullName;
//    }
//
//    public void setFullName(FullName fullName) {
//        this.fullName = fullName;
//    }
//
//    public String getGender() {
//        return gender;
//    }
//
//    public void setGender(String gender) {
//        this.gender = gender;
//    }
//
//    public String getBirthDate() {
//        return birthDate;
//    }
//
//    public void setBirthDate(String birthDate) {
//        this.birthDate = birthDate;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//
//    public String getMajor() {
//        return major;
//    }
//
//    public void setMajor(String major) {
//        this.major = major;
//    }
//
//    public double getGpa() {
//        return gpa;
//    }
//
//    public void setGpa(double gpa) {
//        this.gpa = gpa;
//    }
//
//    public int getYear() {
//        return year;
//    }
//
//    public void setYear(int year) {
//        this.year = year;
//    }
//}
package com.example.btth_3;

import java.io.Serializable;

public class Student implements Serializable {
    private String id;
    private FullName fullName;
    private String gender;
    private String birthDate;
    private String email;
    private String address;
    private String major;
    private double gpa;
    private int year;

    public Student(String id, FullName fullName, String gender, String birthDate, String email, String address, String major, double gpa, int year) {
        this.id = id;
        this.fullName = fullName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.email = email;
        this.address = address;
        this.major = major;
        this.gpa = gpa;
        this.year = year;
    }

    // Getters
    public String getId() { return id; }
    public FullName getFullName() { return fullName; }
    public String getGender() { return gender; }
    public String getBirthDate() { return birthDate; }
    public String getEmail() { return email; }
    public String getAddress() { return address; }
    public String getMajor() { return major; }
    public double getGpa() { return gpa; }
    public int getYear() { return year; }

    public static class FullName implements Serializable {
        private String first;
        private String midd;
        private String last;

        public FullName(String first, String midd, String last) {
            this.first = first;
            this.midd = midd;
            this.last = last;
        }

        public String getFirst() { return first; }
        public String getMidd() { return midd; }
        public String getLast() { return last; }
    }
}
