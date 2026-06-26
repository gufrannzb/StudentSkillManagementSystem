<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>

<head>

<title>

Student Skill Management System

</title>

</head>

<body>

<jsp:include page="includes/header.jsp" />

<%
response.sendRedirect(
        request.getContextPath()
        + "/SkillServlet");
%>

<jsp:include page="includes/footer.jsp"/>

</body>

</html>