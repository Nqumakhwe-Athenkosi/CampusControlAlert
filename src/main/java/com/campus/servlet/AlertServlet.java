package com.campus.servlet;

import com.campus.dao.AlertDAO;
import com.campus.entity.EmergencyAlert;
import com.campus.entity.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/submitAlert")
public class AlertServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Student student = (Student) session.getAttribute("student");
        if (student == null) {
            resp.sendRedirect(req.getContextPath() + "/login.jsp");
            return;
        }
        String type = req.getParameter("type");
        String location = req.getParameter("location");
        String description = req.getParameter("description");
        String severity = calculateSeverity(type, description);
        EmergencyAlert alert = new EmergencyAlert();
        alert.setType(type);
        alert.setLocation(location);
        alert.setDescription(description);
        alert.setSeverity(severity);
        alert.setStudentNumber(student.getStudentNumber());
        alert.setStudentName(student.getFullName());
        boolean saved = AlertDAO.saveAlert(alert);
        if (saved) {
            req.setAttribute("message", "Emergency alert sent successfully!");
        } else {
            req.setAttribute("error", "Failed to send alert.");
        }
        req.getRequestDispatcher("/alertForm.jsp").forward(req, resp);
    }

    private String calculateSeverity(String type, String description) {
        String desc = description.toLowerCase();
        if (type.equals("Fire") || type.equals("Medical") || type.equals("Violence") ||
                type.equals("Theft") || type.equals("Rape") ||
                desc.contains("gun") || desc.contains("knife") || desc.contains("bleeding")) {
            return "Critical";
        } else if (desc.contains("fight")) {
            return "High";
        } else if (type.equals("Power Outage")) {
            return "Medium";
        }
        return "Low";
    }
}