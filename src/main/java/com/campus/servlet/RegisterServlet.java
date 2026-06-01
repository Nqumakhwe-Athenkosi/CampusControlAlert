package com.campus.servlet;

import com.campus.dao.AlertDAO;
import com.campus.entity.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Student student = new Student();
        student.setStudentNumber(req.getParameter("studentNumber"));
        student.setFullName(req.getParameter("fullName"));
        student.setEmail(req.getParameter("email"));
        student.setPhone(req.getParameter("phone"));
        student.setPassword(req.getParameter("password"));
        boolean success = AlertDAO.registerStudent(student);
        if (success) {
            resp.sendRedirect(req.getContextPath() + "/login.jsp?msg=registered");
        } else {
            req.setAttribute("error", "Registration failed. Student number may already exist.");
            req.getRequestDispatcher("/register.jsp").forward(req, resp);
        }
    }
}