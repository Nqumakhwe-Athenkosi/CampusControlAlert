<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login - Campus Alert</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 50px; }
        .container { max-width: 400px; margin: auto; padding: 20px; border: 1px solid #ccc; border-radius: 5px; }
        input { width: 100%; padding: 8px; margin: 5px 0 15px; }
        input[type="submit"] { background: #4CAF50; color: white; border: none; cursor: pointer; }
        .error { color: red; }
        .success { color: green; }
    </style>
</head>
<body>
<div class="container">
    <h2>Campus Emergency Alert System</h2>
    <form action="${pageContext.request.contextPath}/login" method="post">
        <label>Student Number:</label>
        <input type="text" name="studentNumber" required>
        <label>Password:</label>
        <input type="password" name="password" required>
        <input type="submit" value="Login">
    </form>
    <p><a href="${pageContext.request.contextPath}/register.jsp">New Student? Register here</a></p>
    <c:if test="${not empty error}">
        <p class="error">${error}</p>
    </c:if>
    <c:if test="${param.msg == 'registered'}">
        <p class="success">Registration successful! Please login.</p>
    </c:if>
</div>
</body>
</html>