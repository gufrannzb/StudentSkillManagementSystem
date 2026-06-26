<%-- 
    Document   : reset-password
    Created on : Jun 4, 2026, 4:21:06 AM
    Author     : mohdgufran
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>

Reset Password

</title>

<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/common.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/student.css">

</head>

<body>

<jsp:include page="../includes/header.jsp" />

<h2>

Reset Password

</h2>

<%
String errorMessage =
        (String) request.getAttribute(
                "errorMessage");

if(errorMessage != null){
%>

<p style="color:red;">

<%= errorMessage %>

</p>

<%
}
%>

<form action="<%=request.getContextPath()%>/ResetPasswordServlet"
      method="post">

New Password

<br>

<input type="password"
       name="password"
       required>

<br><br>

Confirm Password

<br>

<input type="password"
       name="confirmPassword"
       required>

<br><br>

<button type="submit">

Reset Password

</button>

</form>

<jsp:include page="../includes/footer.jsp" />
      
</body>

</html>