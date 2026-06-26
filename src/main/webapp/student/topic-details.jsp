<%-- 
    Document   : topic-details
    Created on : Jun 3, 2026, 3:11:46 AM
    Author     : mohdgufran
--%>

<%@page contentType="text/html"
        pageEncoding="UTF-8"%>

<%@page import="com.skillmanager.model.Topic"%>

<%@page import="com.skillmanager.model.User"%>


<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>Topic Details</title>

<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/common.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/student.css">

</head>

<body>
    
   


<%

User loggedInUser =
        (User) session.getAttribute(
                "user");

%>

<%

Boolean completed =
        (Boolean) request.getAttribute(
                "completed");

if(completed == null) {

    completed = false;
}

%>

<jsp:include page="../includes/header.jsp" />


<%

Topic topic =
        (Topic) request.getAttribute(
                "topic");

%>

<%

Topic previousTopic =
        (Topic) request.getAttribute(
                "previousTopic");

Topic nextTopic =
        (Topic) request.getAttribute(
                "nextTopic");

%>

<h1>

<%= topic.getTopicName() %>

</h1>

<hr>

<p>

<%= topic.getTopicContent() %>

</p>

<br><br>

<%

if(loggedInUser != null) {

    if(completed) {

%>

<button disabled
        style="background-color:green;
               color:white;">

✓ Completed

</button>

<%

    }
    else {

%>

<form action="MarkTopicCompleteServlet"
      method="post">

<input type="hidden"
       name="topicId"
       value="<%= topic.getTopicId() %>">

<button type="submit">

Mark As Completed

</button>

</form>

<%

    }

}

%>
<br>

<a href="javascript:history.back()">

Back To Course

</a>

<br><br>

<%

if(previousTopic != null) {

%>

<a href="TopicServlet?topicId=<%= previousTopic.getTopicId() %>">

←

</a>

<%

}

%>

&nbsp;&nbsp;&nbsp;&nbsp;

<%
    
if(nextTopic != null) {

%>

<a href="TopicServlet?topicId=<%= nextTopic.getTopicId() %>">

→

</a>

<%

}

%>

<jsp:include page="../includes/footer.jsp" />

</body>

</html>