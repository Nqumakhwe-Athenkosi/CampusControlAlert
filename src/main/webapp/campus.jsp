<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%
    if (session.getAttribute("student") == null && session.getAttribute("admin") == null) {
        response.sendRedirect(request.getContextPath() + "/login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Campus Control</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 30px; }
        table { width: 100%; border-collapse: collapse; margin-top: 20px; }
        th, td { border: 1px solid #ddd; padding: 10px; text-align: left; }
        th { background: #4CAF50; color: white; }
        .unresolved { background-color: #ffcccc; }
        .resolved { background-color: #ccffcc; }
        .btn-resolve { background: #008CBA; color: white; border: none; padding: 5px 10px; cursor: pointer; border-radius: 3px; }
    </style>
</head>
<body>
<h2>🏢 Campus Control - Emergency Monitor</h2>
<table>
    <thead>
    <tr><th>ID</th><th>Student</th><th>Type</th><th>Location</th><th>Severity</th><th>Time</th><th>Status</th><th>Action</th></tr>
    </thead>
    <tbody>
    <c:forEach var="alert" items="${alerts}">
        <tr class="${alert.status == 'UNRESOLVED' ? 'unresolved' : 'resolved'}">
            <td>${alert.id}</td>
            <td>${alert.studentName}</td>
            <td>${alert.type}</td>
            <td>${alert.location}</td>
            <td>${alert.severity}</td>
            <td>${alert.createdTime}</td>
            <td>${alert.status}</td>
            <td>
                <c:if test="${alert.status == 'UNRESOLVED'}">
                    <form action="${pageContext.request.contextPath}/campus" method="post" style="margin:0">
                        <input type="hidden" name="alertId" value="${alert.id}">
                        <input type="submit" value="Resolve" class="btn-resolve">
                    </form>
                </c:if>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<p><a href="${pageContext.request.contextPath}/alertForm.jsp">← Back to Alert Form</a> | <a href="${pageContext.request.contextPath}/logout">Logout</a></p>
</body>
</html>