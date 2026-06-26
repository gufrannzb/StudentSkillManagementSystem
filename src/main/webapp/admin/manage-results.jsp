<%-- 
    Document   : manage-results
    Created on : May 31, 2026, 4:05:09 PM
    Author     : mohdgufran
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="java.util.List"%>
<%@page import="com.skillmanager.model.Result"%>

<!DOCTYPE html>

<html>
<head>
    <meta charset="UTF-8">
    <title>Manage Results</title>
</head>

<body>
    
<%@ include file="includes/admin-header.jsp" %>
<%@ include file="includes/admin-sidebar.jsp" %>

<%
if(session.getAttribute("admin") == null){

    response.sendRedirect(
            request.getContextPath()
            + "/admin/admin-login.jsp");

    return;
}
%>

<h1>All Test Results</h1>

<hr>

<%

List<Result> resultList =
        (List<Result>)
        request.getAttribute(
                "resultList");

if (resultList != null
        && !resultList.isEmpty()) {

%>

<table border="1">

<tr>

    <th>ID</th>
    <th>Student</th>
    <th>Skill</th>
    <th>Percentage</th>
    <th>Level</th>
    <th>Date</th>

</tr>

<%

for (Result result : resultList) {

%>

<tr>

    <td><%= result.getResultId() %></td>

    <td><%= result.getUserName() %></td>

    <td><%= result.getSkillName() %></td>

    <td><%= result.getPercentage() %></td>

    <td><%= result.getSkillLevel() %></td>

    <td><%= result.getTestDate() %></td>

</tr>

<%

}

%>

</table>

<%

} else {

%>

<p>No Results Found</p>

<%

}

%>

<%@ include file="includes/admin-footer.jsp" %>

</body>
</html>