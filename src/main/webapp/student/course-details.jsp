<%-- 
    Document   : course-details
    Created on : Jun 2, 2026, 8:42:53 PM
    Author     : mohdgufran
    Description: This page displays the details of a skill course.
                 It shows skill info, progress card (for logged-in users),
                 assessment button, and available topics list.
--%>


<%@page contentType="text/html"
        pageEncoding="UTF-8"%>


<%@page import="com.skillmanager.model.Skill"%>
<%@page import="com.skillmanager.model.Topic"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Set"%>
<%@page import="com.skillmanager.model.Resource"%>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Course Details</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/common.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/student.css">
</head>


<body>
    
    

<%-- -------------------- SESSION CHECK -------------------- --%>
<%
Object user =
        session.getAttribute(
                "user");
%>

<%-- -------------------- HEADER INCLUDE -------------------- --%>
<jsp:include page="../includes/header.jsp" />

<%-- -------------------- SKILL DETAILS -------------------- --%>
<%
Skill skill =
        (Skill) request.getAttribute(
                "skill");
%>

<h1>
    <%= skill.getSkillName() %>
</h1>
<hr>

<p>
    <b>Description:</b>
    <%= skill.getDescription() %>
</p>

<p>
    <b>Category:</b>
    <%= skill.getCategory() %>
</p>

<%-- -------------------- PROGRESS VARIABLES -------------------- --%>
<%
Integer completedCount =
        (Integer) request.getAttribute(
                "completedCount");
Integer totalCount =
        (Integer) request.getAttribute(
                "totalCount");
Integer progressPercentage =
        (Integer) request.getAttribute(
                "progressPercentage");
%>

<%-- -------------------- PROGRESS CARD (Logged-in Users Only) -------------------- --%>
<%
if(user != null) {
%>
<div class="progress-card">

    <div class="progress-card-header">
        <h3>My Progress</h3>
    </div>

    <div class="progress-card-body">

        <p>
            <span class="progress-count">
                <%= completedCount %> / <%= totalCount %>
            </span>
            Topics Completed
        </p>

        <div class="progress-bar-container">
            <div class="progress-bar-fill"
                 style="width: <%= progressPercentage %>%;">
            </div>
        </div>

        <p class="progress-percentage">
            <%= progressPercentage %>% Completed
        </p>

    </div>

</div>
<%
}
%>

<%-- -------------------- ASSESSMENT FORM -------------------- --%>

<form action="<%= request.getContextPath() %>/TestServlet"
      method="get">

    <input type="hidden"
           name="skill_id"
           value="<%= skill.getSkillId() %>">

    <button type="submit">
        Start Assessment
    </button>

</form>

<%-- -------------------- AVAILABLE TOPICS -------------------- --%>

<h3>
    Available Topics
</h3>

<%-- Fetch completed topics set from request --%>
<%
Set<Integer> completedTopics =
        (Set<Integer>)
        request.getAttribute(
                "completedTopics");
%>

<%-- Fetch topic list from request --%>
<%
List<Topic> topicList =
        (List<Topic>)
        request.getAttribute(
                "topicList");
%>

<%-- -------------------- TOPICS LIST -------------------- --%>
<%
if(topicList != null
        && !topicList.isEmpty()) {
%>

<ul style="list-style: none;">

<%
for(Topic topic : topicList) {
%>

    <li>

        <%-- Show tick if topic is completed, else show circle --%>
        <%
        if(completedTopics != null
                &&
                completedTopics.contains(
                        topic.getTopicId())) {
        %>
            ✓
        <%
        }
        else {
        %>
            ○
        <%
        }
        %>

        <a href="TopicServlet?topicId=<%= topic.getTopicId() %>">
            <%= topic.getTopicName() %>
        </a>

    </li>

<%
}
%>

</ul>

<%-- -------------------- NO TOPICS FALLBACK -------------------- --%>
<%
}
else {
%>
<p>
    No Topics Available
</p>
<%
}
%>

<hr>

<h3>
Resources
</h3>

<%

List<Resource> resourceList =
(List<Resource>)
request.getAttribute(
        "resourceList");

if(resourceList != null
        && !resourceList.isEmpty()) {

%>

<table border="1">

<tr>

<th>Type</th>
<th>Title</th>
<th>Description</th>
<th>Open</th>

</tr>
<%

for(Resource resource
        : resourceList){

%>

<tr>

<td>
<%=resource.getResourceType()%>
</td>

<td>
<%=resource.getTitle()%>
</td>

<td>
<%=resource.getDescription()%>
</td>

<td>

<a href="
<%=resource.getLink()%>"
target="_blank">

Open

</a>

</td>

</tr>

<%

}

%>

</table>

<%

}
else {

%>

<p>

No Resources Available

</p>

<%

}
%>

<br><br><br>

<jsp:include page="../includes/footer.jsp" />

</body>
</html>