<%-- 
    Document   : my-skills
    Created on : Jun 2, 2026, 7:01:00 PM
    Author     : mohdgufran
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="java.util.List"%>
<%@page import="com.skillmanager.model.Result"%>

<!DOCTYPE html>

<html>

<head>

    <meta charset="UTF-8">

    <title>My Skills</title>
    
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/common.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/student.css">

</head>

<body>

<jsp:include page="../includes/header.jsp" />

<h1>My Skills</h1>

<hr>

<%

List<Result> resultList =
        (List<Result>)
        request.getAttribute(
                "resultList");

if(resultList != null
        && !resultList.isEmpty()) {

    for(Result result : resultList) {

%>

        <div>

            <p>

                <b>Skill:</b>

                <%= result.getSkillName() %>

            </p>

            <p>

                <b>Best Score:</b>

                <%= result.getPercentage() %>%

            </p>

            <p>

                <b>Level:</b>

                <%= result.getSkillLevel() %>

            </p>

            <p>

                <b>Status:</b>

                <%= result.getPercentage() >= 80
                ? "Certified"
                : "In Progress" %>

            </p>

            <hr>

        </div>

<%

    }

}
else {

%>

    <h3>

        No Skills Found

    </h3>

<%

}

%>

<jsp:include page="../includes/footer.jsp" />

</body>

</html>