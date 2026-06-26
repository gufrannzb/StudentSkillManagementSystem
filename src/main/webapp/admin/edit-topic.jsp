<%-- 
    Document   : edit-topic
    Created on : Jun 6, 2026, 2:09:25 AM
    Author     : mohdgufran
--%>

<%@page contentType="text/html"
pageEncoding="UTF-8"%>

<%@page import=
"com.skillmanager.model.Topic"%>

<%
Topic topic =
(Topic)
request.getAttribute(
        "topic");
%>

<%@ include file=
"includes/admin-header.jsp" %>

<%@ include file=
"includes/admin-sidebar.jsp" %>

<h1>Edit Topic</h1>

<form action=
"<%=request.getContextPath()%>/AdminServlet"
method="post">

<input type="hidden"
name="action"
value="updateTopic">

<input type="hidden"
name="topicId"
value="<%=topic.getTopicId()%>">

Topic Name:

<input type="text"
       name="topicName"
       value="<%=topic.getTopicName()%>"
       size="80">

<br><br>

Content:

<textarea
    name="topicContent"
    style="width:900px;
           height:250px;">

<%=topic.getTopicContent()%>

</textarea>

<br><br>

Order:

<input type="number"
name="topicOrder"
value="<%=topic.getTopicOrder()%>">

<br><br>

<input type="submit"
value="Update Topic">

</form>

<%@ include file="includes/admin-footer.jsp" %>