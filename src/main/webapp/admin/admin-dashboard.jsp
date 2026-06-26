<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ include file="includes/admin-header.jsp" %>

<%@ include file="includes/admin-sidebar.jsp" %>

<!DOCTYPE html>

<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Dashboard</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/admin.css">
</head>
<body>
    
    <%
if(session.getAttribute("admin") == null){

    response.sendRedirect(
            request.getContextPath()
            + "/admin/admin-login.jsp");

    return;
}
%>


<h1>

Admin Dashboard

</h1>

<hr>

<h2>

Dashboard Statistics

</h2>

<%
Integer totalStudents =
(Integer) request.getAttribute(
        "totalStudents");

Integer totalSkills =
(Integer) request.getAttribute(
        "totalSkills");

Integer totalTests =
(Integer) request.getAttribute(
        "totalTests");

Integer totalCertificates =
(Integer) request.getAttribute(
        "totalCertificates");
%>

<div class="dashboard-container">

    <a href="<%=request.getContextPath()%>/AdminServlet?action=viewStudents"
       class="dashboard-card">

        <h3>Total Students</h3>

        <h1>
            <%= totalStudents == null
                    ? 0
                    : totalStudents %>
        </h1>

    </a>

    <a href="<%=request.getContextPath()%>/AdminServlet?action=viewSkills"
       class="dashboard-card">

        <h3>Total Skills</h3>

        <h1>
            <%= totalSkills == null
                    ? 0
                    : totalSkills %>
        </h1>

    </a>

    <a href="<%=request.getContextPath()%>/AdminServlet?action=viewResults"
       class="dashboard-card">

        <h3>Total Tests</h3>

        <h1>
            <%= totalTests == null
                    ? 0
                    : totalTests %>
        </h1>

    </a>

    <a href="<%=request.getContextPath()%>/AdminServlet?action=viewCertificates"
       class="dashboard-card">

        <h3>Total Certificates</h3>

        <h1>
            <%= totalCertificates == null
                    ? 0
                    : totalCertificates %>
        </h1>

    </a>

</div>
<hr>

<h3>

Welcome Admin

</h3>

<p>

Use the sidebar to manage
questions, students,
results, skills and resources.

</p>

<%@ include file="includes/admin-footer.jsp" %>

</body>
</html>