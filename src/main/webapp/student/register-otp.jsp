<%-- 
    Document   : register-otp
    Created on : Jun 5, 2026, 12:48:06 AM
    Author     : mohdgufran
--%>

<%@page contentType="text/html"
        pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>

Verify Registration OTP

</title>

<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/common.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/student.css">

</head>

<body>
    
    <jsp:include page="../includes/header.jsp" />

<h2>

Verify Registration OTP

</h2>
    
<%

String errorMessage =
(String) request.getAttribute(
        "errorMessage");

if(errorMessage != null){

%>

<p style="color:red;
font-weight:bold;">

<%=errorMessage%>

</p>

<%

}

%>    

<form action="<%=request.getContextPath()%>/RegisterOtpServlet"
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

 <jsp:include page="../includes/footer.jsp" />     
      
</body>

</html>