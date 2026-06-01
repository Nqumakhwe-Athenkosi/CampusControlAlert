<%@ page import="com.campus.entity.Student" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%
    Student student = (Student) session.getAttribute("student");
    if (student == null) {
        response.sendRedirect(request.getContextPath() + "/login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Report Emergency</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 50px; }
        .container { max-width: 600px; margin: auto; padding: 20px; border: 1px solid #ccc; border-radius: 5px; }
        input, select, textarea { width: 100%; padding: 8px; margin: 5px 0 15px; }
        input[type="submit"] { background: #f44336; color: white; border: none; cursor: pointer; font-size: 16px; }
        .success { color: green; }
        .error { color: red; }
    </style>
</head>
<body>
<div class="container">
    <h2>Welcome, <%= student.getFullName() %> (<%= student.getStudentNumber() %>)</h2>
    <form action="${pageContext.request.contextPath}/submitAlert" method="post">
        <label>Emergency Type:</label>
        <select name="type">
            <option>Fire</option>
            <option>Medical</option>
            <option>Violence</option>
            <option>Theft</option>
            <option>Rape</option>
            <option>Power Outage</option>
            <option>General</option>
        </select>
        <label>Location (Building/Room):</label>
        <input type="text" name="location" required>
        <label>Description:</label>
        <textarea name="description" rows="4"></textarea>
        <input type="submit" value="🚨 TRIGGER ALERT 🚨">
    </form>
    <c:if test="${not empty message}">
        <p class="success">${message}</p>
    </c:if>
    <c:if test="${not empty error}">
        <p class="error">${error}</p>
    </c:if>
    <hr>
    <a href="${pageContext.request.contextPath}/campus">📋 Campus Control Dashboard</a> |
    <a href="${pageContext.request.contextPath}/logout">Logout</a>
</div>
</body>
</html>