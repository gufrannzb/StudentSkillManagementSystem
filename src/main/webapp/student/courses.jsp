<%-- 
    Document   : courses.jsp
    Created on : Jun 2, 2026, 7:56:57 PM
    Author     : mohdgufran
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="java.util.List"%>
<%@page import="com.skillmanager.model.Skill"%>

<!DOCTYPE html>

<html>

<head>

    <meta charset="UTF-8">

    <title>Courses</title>
    
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/common.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/student.css">

</head>

<body>

<jsp:include page="../includes/header.jsp" />


<h1>All Courses</h1>

<hr>

<%

List<Skill> skillList =
        (List<Skill>)
        request.getAttribute(
                "skillList");

if(skillList != null
        && !skillList.isEmpty()) {

    for(Skill skill : skillList) {

%>

        <div>

            <h2>

                <%= skill.getSkillName() %>

            </h2>

            <p>

                <b>Description:</b>

                <%= skill.getDescription() %>

            </p>

            <p>

                <b>Category:</b>

                <%= skill.getCategory() %>

            </p>

            <form action="CourseDetailsServlet"
                method="get">

                <input type="hidden"
                name="skillId"
                value="<%= skill.getSkillId() %>">

                <button type="submit">

                      View Details

                </button>

            </form>
            <hr>

        </div>

<%

    }

}
else {

%>

    <h3>

        No Courses Available

    </h3>

<%

}

%>




<jsp:include page="../includes/footer.jsp" />

</body>

</html>