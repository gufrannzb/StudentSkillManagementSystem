<%-- 
    Document   : manage-resources
    Created on : May 28, 2026, 4:29:36 PM
    Author     : mohdgufran
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="java.util.List"%>
<%@page import="com.skillmanager.model.Resource"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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

<h1>

Resource Management

</h1>

<hr>

<a href="
<%=request.getContextPath()%>
/admin/add-resource.jsp?skillId=
<%=request.getParameter("skillId")%>
">
Add Resource
</a>

<br><br>

<%

List<Resource> resourceList =
(List<Resource>)
request.getAttribute(
        "resourceList");

if(resourceList != null){

%>

<table border="1">

<tr>

<th>ID</th>
<th>Type</th>
<th>Percentage Range</th>
<th>Title</th>
<th>Link</th>
<th>Description</th>
<th>Action</th>

</tr>

<%

for(Resource resource
        : resourceList){

%>

<tr>

<td>
<%=resource.getResourceId()%>
</td>

<td>
<%=resource.getResourceType()%>
</td>

<td>
<%=resource.getPercentageRange()%>
</td>

<td>
<%=resource.getTitle()%>
</td>

<td>
<%=resource.getLink()%>
</td>

<td>
<%=resource.getDescription()%>
</td>

<td>

<a href="<%=request.getContextPath()%>/AdminServlet?action=editResource&resourceId=<%=resource.getResourceId()%>">
    Edit
</a>

|

<a href="<%=request.getContextPath()%>/AdminServlet?action=deleteResource&resourceId=<%=resource.getResourceId()%>"
   onclick="return confirm('Delete Resource?');">
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

</body>
</html>
