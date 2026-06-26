<%@ page contentType="text/html"
pageEncoding="UTF-8" %>

<a href="<%=request.getContextPath()%>/AdminServlet?action=dashboard">
    Dashboard

</a>

<br><br>

<a href="<%=request.getContextPath()%>/AdminServlet?action=viewQuestions">

Questions

</a>

<br><br>

<a href="<%=request.getContextPath()%>/AdminServlet?action=viewStudents">

Students

</a>

<br><br>

<a href="<%=request.getContextPath()%>/AdminServlet?action=viewResults">

Results

</a>

<br><br>

<a href="<%=request.getContextPath()%>/AdminServlet?action=viewSkills">
Skills
</a>


<br><br>

<a href="<%=request.getContextPath()%>/AdminServlet?action=viewCertificates">

Certificates

</a>

<br><br>

<a href="<%=request.getContextPath()%>/admin/manage-resources.jsp">

Resources

</a>

<br><br>

<a href="<%=request.getContextPath()%>/LogoutServlet">

Logout

</a>
