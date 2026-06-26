<%@page import="com.skillmanager.model.User"%>



<%
User user =
        (User) session.getAttribute(
                "user");
%>

<% if(user == null) { %>

<a href="<%=request.getContextPath()%>/SkillServlet">
    SSMS Logo
</a>

|

<a href="<%=request.getContextPath()%>/CoursesServlet">
    Courses
</a>

|

<a href="<%=request.getContextPath()%>/about.jsp">
    About Us
</a>

|

<a href="<%=request.getContextPath()%>/contact.jsp">
    Contact Us
</a>

|

<a href="<%=request.getContextPath()%>/student/login.jsp">
    Login / Signup
</a>

|

<a href="<%=request.getContextPath()%>/admin/admin-login.jsp">
    Admin Login
</a>

<% } else { %>

<a href="<%=request.getContextPath()%>/SkillServlet">
    SSMS Logo
</a>

|

<a href="<%=request.getContextPath()%>/CoursesServlet">
    Courses
</a>

|

<a href="<%=request.getContextPath()%>/MySkillsServlet">
    My Skills
</a>

|

<a href="<%=request.getContextPath()%>/CertificateHistoryServlet">
    Certificates
</a>

|

<a href="<%=request.getContextPath()%>/student/profile.jsp">
    Profile
</a>

|

<a href="<%=request.getContextPath()%>/LogoutServlet">
    Logout
</a>

<% } %>

<hr>