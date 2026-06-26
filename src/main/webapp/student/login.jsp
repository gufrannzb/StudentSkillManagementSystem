<%-- 
    Document   : login
    Created on : May 28, 2026
    Author     : mohdgufran
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>Student Login</title>
    
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/common.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/student.css">

</head>

<body>
    
    <jsp:include page="../includes/header.jsp" />
    
    <%

String successMessage =
        (String)
        request.getAttribute(
                "successMessage");

if (successMessage != null) {

%>

<h3 style="color:green;">

    <%= successMessage %>

</h3>

<%

}

%>


    <h2>Student Login</h2>
    
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



    <form action="<%=request.getContextPath()%>/AuthServlet"
      method="post">

        <input type="email"
               name="email"
               placeholder="Enter Email Address"
               required>

        <br><br>

        <input type="password"
               name="password"
               placeholder="Enter Password"
               required>

        <br><br>
        
        <a href="<%=request.getContextPath()%>/student/forgot-password.jsp">

        Forgot Password?

        </a>
        
        <br><br>

        <button type="submit"
                name="action"
                value="login">

            Login

        </button>

    </form>

    <br>
    
    <p>
       Don't have an account? 
    </p>

    <a href="<%=request.getContextPath()%>/student/register.jsp">
       Create New Account
    </a>

    <jsp:include page="../includes/footer.jsp" />
    
</body>

</html>