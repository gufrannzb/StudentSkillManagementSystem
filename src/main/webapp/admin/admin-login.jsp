<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>

<head>

    <title>
        Admin Login
    </title>

</head>

<body>
    
    <jsp:include page="../includes/header.jsp" />    

<h2>

    Admin Login

</h2>

<%

String errorMessage =
        (String)
        request.getAttribute(
                "errorMessage");

if (errorMessage != null) {

%>

<h3 style="color:red;">

    <%= errorMessage %>

</h3>

<%

}

%>

<form action="<%=request.getContextPath()%>/AdminAuthServlet"
      method="post">

    <input type="email"
           name="email"
           placeholder="Enter Admin Email"
           required>

    <br><br>

    <input type="password"
           name="password"
           placeholder="Enter Password"
           required>

    <br><br>

    <button type="submit">

        Login

    </button>

</form>

<%@ include file="includes/admin-footer.jsp" %>     
      
</body>

</html>