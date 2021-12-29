package com.atguigu.jdbc.entity;

import java.io.Serializable;

public class Student implements Serializable {
    private Integer studentId;
    private String studentName;
    private String studentAge;
    private Integer studentPhone;

    public Student(Integer studentId, String studentName, String studentAge, Integer studentPhone) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentAge = studentAge;
        this.studentPhone = studentPhone;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(String studentAge) {
        this.studentAge = studentAge;
    }

    public Integer getStudentPhone() {
        return studentPhone;
    }

    public void setStudentPhone(Integer studentPhone) {
        this.studentPhone = studentPhone;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", studentAge='" + studentAge + '\'' +
                ", studentPhone=" + studentPhone +
                '}';
    }
}