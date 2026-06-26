<%-- 
    Document   : login-required
    Created on : Jun 3, 2026, 1:43:47 AM
    Author     : mohdgufran
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
    <title>Login Required</title>
    
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/common.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/student.css">
    
</head>

<body>

<jsp:include page="../includes/header.jsp" />


<h2 style="color:red;">

⚠ Login Required

</h2>

<p>

Please login to continue.

</p>

<jsp:include page="login.jsp" />

</body>

</html>