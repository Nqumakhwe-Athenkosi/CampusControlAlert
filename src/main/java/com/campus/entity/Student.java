package com.campus.entity;

import java.sql.Timestamp;

public class Student {
    private int studentId;
    private String studentNumber;
    private String fullName;
    private String email;
    private String phone;
    private String password;
    private Timestamp registeredDate;

    public Student() {}

    public Student(String studentNumber, String fullName, String email, String phone, String password) {
        this.studentNumber = studentNumber;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    public int getStudentId() { return studentId; }
    public void setStudentId(int studentId) { this.studentId = studentId; }
    public String getStudentNumber() { return studentNumber; }
    public void setStudentNumber(String studentNumber) { this.studentNumber = studentNumber; }
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public Timestamp getRegisteredDate() { return registeredDate; }
    public void setRegisteredDate(Timestamp registeredDate) { this.registeredDate = registeredDate; }
}