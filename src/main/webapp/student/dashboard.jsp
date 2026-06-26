<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="java.util.List"%>
<%@page import="com.skillmanager.model.Skill"%>
<%@page import="com.skillmanager.model.Result"%>


<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>Student Dashboard</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/common.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/student.css">
    

</head>

<body>
    
    <jsp:include page="../includes/header.jsp" />
    
    <%@page import="com.skillmanager.model.User"%>

<%
User user =
        (User) session.getAttribute(
                "user");
%>

<%
if(user != null) {
%>

<h1>

Welcome Back,
<%= user.getName() %>

</h1>

<%
}
%>

<%
if(user != null) {
%>

<h2>

Learning Summary

</h2>

<p>

Tests Taken:
<%= request.getAttribute(
        "testCount") %>

</p>

<p>

Certificates Earned:
<%= request.getAttribute(
        "certificateCount") %>

</p>

<%
}
%>

<hr>

<hr>

    <h1>Student Dashboard</h1>
    

    <hr>

    <h2>Featured Courses</h2>

    <%

        List<Skill> skillList =
                (List<Skill>) request.getAttribute("skillList");

        if (skillList != null) {

            for (Skill skill : skillList) {

    %>

                <div>

                    <h3>
                        <%= skill.getSkillName()%>
                    </h3>

                    <p>
                        <%= skill.getDescription()%>
                    </p>

                    <p>
                        Category:
                        <%= skill.getCategory()%>
                    </p>

                    <form action="<%=request.getContextPath()%>/CourseDetailsServlet"
      method="get">

    <input type="hidden"
           name="skillId"
           value="<%= skill.getSkillId()%>">

    <button type="submit">
        View Course
    </button>

</form>

                    <hr>

                </div>

    <%

            }

        }

    %>
    
    <hr>
    
<%
if(user != null) {
%>

<h2>Recent Results</h2>

<%

    List<Result> resultList =
            (List<Result>)
            request.getAttribute("resultList");

    if (resultList != null
            && !resultList.isEmpty()) {

        for (Result result : resultList) {

%>

            <div>

                <p>
                    <p>
                        Skill:
                        <%= result.getSkillName() %>
</p>
                </p>

                <p>
                    Percentage:
                    <%= result.getPercentage() %>%
                </p>

                <p>
                    Level:
                    <%= result.getSkillLevel() %>
                </p>

                <p>
                    Test Date:
                    <%= result.getTestDate() %>
                </p>
                
                <% if (result.getPercentage() >= 80) { %>

                <form action="CertificatePreviewServlet"
                     method="post">

                    <input type="hidden"
                    name="skillId"
                    value="<%= result.getSkillId() %>">

                    <button type="submit">

                        View Certificate

                    </button>

                </form>

<% } %>


                <hr>

            </div>

<%

        }

    } else {

%>

        <p>
            No Previous Results Found
            
            
        </p>
        
        

<%

    }

%>

<%
}
%>

<jsp:include page="../includes/footer.jsp" />

</body>

</html>