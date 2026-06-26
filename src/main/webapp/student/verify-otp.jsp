<%-- 
    Document   : verify-otp
    Created on : Jun 4, 2026, 4:20:48 AM
    Author     : mohdgufran
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>

Verify OTP

</title>

<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/common.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/student.css">

</head>

<body>

<jsp:include page="../includes/header.jsp" />

<h2>

Verify OTP

</h2>

<form action="<%=request.getContextPath()%>/VerifyOtpServlet"
      method="post">

OTP

<br>

<input type="text"
       name="otp"
       maxlength="6"
       required>

<br><br>

<button type="submit">

Verify OTP

</button>

</form>
      
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

<jsp:include page="../includes/footer.jsp" />

</body>

</html>