<%-- 
    Document   : manage-topics
    Created on : Jun 5, 2026, 11:53:59 PM
    Author     : mohdgufran
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.skillmanager.model.Topic"%>

<%@ include file="includes/admin-header.jsp" %>
<%@ include file="includes/admin-sidebar.jsp" %>

<h1>

Topic Management

</h1>

<a href="
<%=request.getContextPath()%>
/admin/add-topic.jsp">

Add New Topic

</a>

<hr>

<hr>

<%

List<Topic> topicList =
(List<Topic>)
request.getAttribute(
        "topicList");

if(topicList != null){

%>

<table border="1">

<tr>

<th>ID</th>
<th>Name</th>
<th>Content</th>
<th>Order</th>
<th>Actions</th>

</tr>



<%

for(Topic topic : topicList){

%>

<tr>

<td><%=topic.getTopicId()%></td>

<td><%=topic.getTopicName()%></td>

<td><%=topic.getTopicContent()%></td>

<td><%=topic.getTopicOrder()%></td>

<td>

<a href="
<%=request.getContextPath()%>
/AdminServlet?action=editTopic
&topicId=<%=topic.getTopicId()%>">

Edit

</a>

|

<a href="
<%=request.getContextPath()%>
/AdminServlet?action=deleteTopic
&topicId=<%=topic.getTopicId()%>">

Delete

</a>

</td>

</tr>

<%

}

%>

</table>

<%

}
%>

<%@ include file="includes/admin-footer.jsp" %>


