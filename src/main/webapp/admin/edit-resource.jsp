<%-- 
    Document   : edit-resource
    Created on : Jun 6, 2026, 3:11:49 PM
    Author     : mohdgufran
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.skillmanager.model.Resource"%>

<%@ include file="includes/admin-header.jsp" %>
<%@ include file="includes/admin-sidebar.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <title>Edit Resource</title>
</head>
<body>

<%
Resource resource =
(Resource)request.getAttribute("resource");
%>

<h2>Edit Resource</h2>

<form action="<%=request.getContextPath()%>/AdminServlet"
      method="post">

    <input type="hidden"
           name="action"
           value="updateResource">

    <input type="hidden"
           name="resourceId"
           value="<%=resource.getResourceId()%>">

    <input type="hidden"
           name="skillId"
           value="<%=resource.getSkillId()%>">
    
        Percentage Range:

    <select name="percentageRange">

        <option value="0-40"
            <%= "0-40".equals(resource.getPercentageRange()) ? "selected" : "" %>>
            0-40
        </option>

        <option value="41-60"
            <%= "41-60".equals(resource.getPercentageRange()) ? "selected" : "" %>>
            41-60
        </option>

        <option value="61-80"
            <%= "61-80".equals(resource.getPercentageRange()) ? "selected" : "" %>>
            61-80
        </option>

        <option value="81-100"
            <%= "81-100".equals(resource.getPercentageRange()) ? "selected" : "" %>>
            81-100
        </option>

    </select>

    <br><br>

    Resource Type:

    <input type="text"
           name="resourceType"
           value="<%=resource.getResourceType()%>">

    <br><br>

    Title:

    <input type="text"
           name="title"
           value="<%=resource.getTitle()%>">

    <br><br>

    Link:

    <input type="text"
           name="link"
           value="<%=resource.getLink()%>">

    <br><br>

    Description:

    <textarea name="description"
              rows="5"
              cols="40"><%=resource.getDescription()%></textarea>

    <br><br>

    <input type="submit"
           value="Update Resource">

</form>

<%@ include file="includes/admin-footer.jsp" %>             
              
</body>
</html>