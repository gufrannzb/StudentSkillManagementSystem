<%-- 
    Document   : assessment-result.jsp
    Created on : Jun 2, 2026, 4:48:59 PM
    Author     : mohdgufran
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.skillmanager.model.Recommendation"%>

<%@page import="com.skillmanager.model.Resource"%>
<%@page import="java.util.List"%>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>Test Result</title>
    
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/common.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/student.css">

</head>

<body>
    
    <jsp:include page="../includes/header.jsp" />

    <h1>Skill Test Result</h1>

    <hr>

<%

Double percentageObj =
        (Double) request.getAttribute(
                "percentage");

Integer correctAnswersObj =
        (Integer) request.getAttribute(
                "correctAnswers");

Integer totalQuestionsObj =
        (Integer) request.getAttribute(
                "totalQuestions");

String skillLevel =
        (String) request.getAttribute(
                "skillLevel");

String message =
        (String) request.getAttribute(
                "message");

Recommendation recommendation =
        (Recommendation)
        request.getAttribute(
                "recommendation");

List<Resource> resourceList =
        (List<Resource>)
        request.getAttribute(
                "resourceList");

double percentage =
        percentageObj == null
        ? 0
        : percentageObj;

Double bestPercentageObj =
        (Double) request.getAttribute(
                "bestPercentage");

String bestSkillLevel =
        (String) request.getAttribute(
                "bestSkillLevel");

double bestPercentage =
        bestPercentageObj == null
        ? percentage
        : bestPercentageObj;


int correctAnswers =
        correctAnswersObj == null
        ? 0
        : correctAnswersObj;

int totalQuestions =
        totalQuestionsObj == null
        ? 0
        : totalQuestionsObj;

%>

<%

if (message != null) {

%>

<h3>

    <%= message %>

</h3>

<%

}

%>

<h2>

    Current Score:
    <%= correctAnswers %> /
    <%= totalQuestions %>

</h2>

<h2>

    Current Percentage:
    <%= percentage %>%

</h2>

<%
String performanceStatus;

if (percentage <= 40) {
    performanceStatus = "Needs Improvement";
} else if (percentage <= 60) {
    performanceStatus = "Average Performance";
} else if (percentage <= 80) {
    performanceStatus = "Good Progress";
} else {
    performanceStatus = "Excellent Performance";
}
%>

<h2>
    Status:
    <%= performanceStatus %>
</h2>

<h2>

    Best Score So Far:
    <%= bestPercentage %>%

</h2>

<h2>

    Best Skill Level:
    <%= bestSkillLevel == null
            ? skillLevel
            : bestSkillLevel %>

</h2>

    <h2>

        Current Skill Level:
        <%= skillLevel %>

    </h2>
        
        <hr>

<%

if(recommendation != null){

%>

<h2>Performance Feedback</h2>

<p>
    <%= recommendation.getSuggestionText() %>
</p>

<h3>

Next Topics

</h3>

<p>

<%=recommendation.getNextTopics()%>

</p>

<h3>

Career Roles

</h3>

<p>

<%=recommendation.getCareerRoles()%>

</p>

<%

}

else{

%>

<p>No recommendation available for this result yet.</p>

<%

}

%>

<hr>

<h2>Recommended Resources</h2>

<%
if(resourceList != null && !resourceList.isEmpty()) {
%>

    <table border="1" cellpadding="8" cellspacing="0">

        <tr>
            <th>Type</th>
            <th>Title</th>
            <th>Description</th>
            <th>Open</th>
        </tr>

        <%
        for(Resource resource : resourceList) {
        %>

        <tr>
            <td><%= resource.getResourceType() %></td>
            <td><%= resource.getTitle() %></td>
            <td><%= resource.getDescription() %></td>
            <td>
                <a href="<%= resource.getLink() %>" target="_blank">
                    Open
                </a>
            </td>
        </tr>

        <%
        }
        %>

    </table>

<%
} else {
%>

    <p>No recommended resources available for this skill right now.</p>

<%
}
%>

    <hr>
    
    <%

if(bestPercentage >= 80){

%>

<h2>

Certificate Earned

</h2>

<h3>

You have earned a certificate for this skill.

</h3>

<a href="<%=request.getContextPath()%>/CertificatePreviewServlet?skillId=<%=request.getAttribute("skillId")%>">

View Certificate

</a>

<%

}

%>



    <hr>

    <a href="<%=request.getContextPath()%>/SkillServlet">
        Back To Dashboard
    </a>
    
    
   <jsp:include page="../includes/footer.jsp" />

</body>

</html>