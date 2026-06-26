<%-- 
    Document   : manage-skills
    Created on : May 28, 2026, 4:28:32 PM
    Author     : mohdgufran
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <%@ include file="includes/admin-header.jsp" %>
        <%@ include file="includes/admin-sidebar.jsp" %>
        
        <%
if(session.getAttribute("admin") == null){

    response.sendRedirect(
            request.getContextPath()
            + "/admin/admin-login.jsp");

    return;
}
%>
        
        <h1>Skill Management</h1>

<hr>

<a href="add-skill.jsp">

Add Skill

</a>

|

<a href="<%=request.getContextPath()%>/AdminServlet?action=viewSkills">

View Skills

</a>

<hr>

<p>

Manage Skills, Topics,
Recommendations and Resources.

</p>

<%@ include file="includes/admin-footer.jsp" %>

</body>
</html>
