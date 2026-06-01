package com.campus.servlet;

import com.campus.dao.AlertDAO;
import com.campus.entity.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String studentNumber = req.getParameter("studentNumber");
        String password = req.getParameter("password");
        if ("admin".equals(studentNumber) && "admin123".equals(password)) {
            req.getSession().setAttribute("admin", true);
            resp.sendRedirect(req.getContextPath() + "/campus");
            return;
        }
        Student student = AlertDAO.login(studentNumber, password);
        if (student != null) {
            req.getSession().setAttribute("student", student);
            resp.sendRedirect(req.getContextPath() + "/alertForm.jsp");
        } else {
            req.setAttribute("error", "Invalid credentials");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }
}