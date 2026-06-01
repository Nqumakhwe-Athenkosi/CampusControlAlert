package com.campus.servlet;

import com.campus.dao.AlertDAO;
import com.campus.entity.EmergencyAlert;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/campus")
public class CampusServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<EmergencyAlert> alerts = AlertDAO.getAllAlerts();
        req.setAttribute("alerts", alerts);
        req.getRequestDispatcher("/campus.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int alertId = Integer.parseInt(req.getParameter("alertId"));
        AlertDAO.resolveAlert(alertId);
        resp.sendRedirect(req.getContextPath() + "/campus");
    }
}