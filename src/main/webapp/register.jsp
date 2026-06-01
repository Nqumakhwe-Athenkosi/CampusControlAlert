<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Register - Campus Alert</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 50px; }
        .container { max-width: 500px; margin: auto; padding: 20px; border: 1px solid #ccc; border-radius: 5px; }
        input { width: 100%; padding: 8px; margin: 5px 0 15px; }
        input[type="submit"] { background: #4CAF50; color: white; border: none; cursor: pointer; }
        .error { color: red; }
    </style>
</head>
<body>
<div class="container">
    <h2>Student Registration</h2>
    <form action="${pageContext.request.contextPath}/register" method="post">
        <label>Student Number:</label>
        <input type="text" name="studentNumber" required>
        <label>Full Name:</label>
        <input type="text" name="fullName" required>
        <label>Email:</label>
        <input type="email" name="email">
        <label>Phone:</label>
        <input type="text" name="phone">
        <label>Password:</label>
        <input type="password" name="password" required>
        <input type="submit" value="Register">
    </form>
    <p><a href="${pageContext.request.contextPath}/login.jsp">Back to Login</a></p>
    <c:if test="${not empty error}">
        <p class="error">${error}</p>
    </c:if>
</div>
</body>
</html>