package com.campus.dao;

import com.campus.entity.*;
import com.campus.util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlertDAO {

    public static boolean registerStudent(Student student) {
        String sql = "INSERT INTO students (student_number, full_name, email, phone, password) VALUES (?,?,?,?,?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, student.getStudentNumber());
            ps.setString(2, student.getFullName());
            ps.setString(3, student.getEmail());
            ps.setString(4, student.getPhone());
            ps.setString(5, student.getPassword());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Student login(String studentNumber, String password) {
        String sql = "SELECT * FROM students WHERE student_number = ? AND password = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, studentNumber);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Student s = new Student();
                s.setStudentId(rs.getInt("student_id"));
                s.setStudentNumber(rs.getString("student_number"));
                s.setFullName(rs.getString("full_name"));
                s.setEmail(rs.getString("email"));
                s.setPhone(rs.getString("phone"));
                return s;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean saveAlert(EmergencyAlert alert) {
        String sql = "INSERT INTO emergency_alerts (type, location, description, severity, student_number, student_name, status) VALUES (?,?,?,?,?,?,?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, alert.getType());
            ps.setString(2, alert.getLocation());
            ps.setString(3, alert.getDescription());
            ps.setString(4, alert.getSeverity());
            ps.setString(5, alert.getStudentNumber());
            ps.setString(6, alert.getStudentName());
            ps.setString(7, "UNRESOLVED");
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static List<EmergencyAlert> getAllAlerts() {
        List<EmergencyAlert> list = new ArrayList<>();
        String sql = "SELECT * FROM emergency_alerts ORDER BY created_time DESC";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                EmergencyAlert a = new EmergencyAlert();
                a.setId(rs.getInt("id"));
                a.setType(rs.getString("type"));
                a.setLocation(rs.getString("location"));
                a.setDescription(rs.getString("description"));
                a.setSeverity(rs.getString("severity"));
                a.setStudentNumber(rs.getString("student_number"));
                a.setStudentName(rs.getString("student_name"));
                a.setCreatedTime(rs.getTimestamp("created_time"));
                a.setStatus(rs.getString("status"));
                list.add(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static boolean resolveAlert(int alertId) {
        String sql = "UPDATE emergency_alerts SET status = 'RESOLVED', resolved_time = ? WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
            ps.setInt(2, alertId);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}