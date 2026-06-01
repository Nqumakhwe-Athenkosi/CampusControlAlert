package com.campus.entity;

import java.sql.Timestamp;

public class EmergencyAlert {
    private int id;
    private String type;
    private String location;
    private String description;
    private String severity;
    private String studentNumber;
    private String studentName;
    private Timestamp createdTime;
    private Timestamp resolvedTime;
    private String status;

    public EmergencyAlert() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getSeverity() { return severity; }
    public void setSeverity(String severity) { this.severity = severity; }
    public String getStudentNumber() { return studentNumber; }
    public void setStudentNumber(String studentNumber) { this.studentNumber = studentNumber; }
    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) { this.studentName = studentName; }
    public Timestamp getCreatedTime() { return createdTime; }
    public void setCreatedTime(Timestamp createdTime) { this.createdTime = createdTime; }
    public Timestamp getResolvedTime() { return resolvedTime; }
    public void setResolvedTime(Timestamp resolvedTime) { this.resolvedTime = resolvedTime; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}