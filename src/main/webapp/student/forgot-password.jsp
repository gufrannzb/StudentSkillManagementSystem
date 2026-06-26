<%-- 
    Document   : forgot-password
    Created on : Jun 4, 2026, 4:20:28 AM
    Author     : mohdgufran
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>
Forgot Password
</title>

<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/common.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/student.css">

</head>
<body>

<jsp:include page="../includes/header.jsp" />

<h2>
Forgot Password
</h2>

<form action="<%=request.getContextPath()%>/ForgotPasswordServlet"
      method="post">

Email
<br>
<input type="email"
       name="email"
       required>
<br><br>

<button type="submit">
Send OTP
</button>

</form>

<%
String errorMessage =
        (String) request.getAttribute(
                "errorMessage");

if (errorMessage != null) {
%>
<p style="color:red;">
<%= errorMessage %>
</p>
<%
}
%>

<%
String successMessage =
        (String) request.getAttribute(
                "successMessage");

if (successMessage != null) {
%>
<p style="color:green;">
<%= successMessage %>
</p>
<%
}
%>

<br>
<a href="<%=request.getContextPath()%>/student/login.jsp">
Back to Login
</a>

</body>
</html>