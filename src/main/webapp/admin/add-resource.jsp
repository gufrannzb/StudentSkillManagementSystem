<%-- 
    Document   : add-resources
    Created on : Jun 6, 2026, 3:36:05 AM
    Author     : mohdgufran
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ include file="includes/admin-header.jsp" %>
<%@ include file="includes/admin-sidebar.jsp" %>

<h1>Add Resource</h1>

<hr>

<form
action="<%=request.getContextPath()%>/AdminServlet"
method="post">

<input
type="hidden"
name="action"
value="addResource">

<input
type="hidden"
name="skillId"
value="<%=request.getParameter("skillId")%>">

Percentage Range:

<br>

<select
name="percentageRange"
style="width:250px;">

    <option value="0-40">0-40</option>
    <option value="41-60">41-60</option>
    <option value="61-80">61-80</option>
    <option value="81-100">81-100</option>

</select>

<br><br>


Type:

<br>

<input
type="text"
name="resourceType"
style="width:500px;">

<br><br>

Title:

<br>

<input
type="text"
name="title"
style="width:700px;">

<br><br>

Link:

<br>

<input
type="text"
name="link"
style="width:900px;">

<br><br>

Description:

<br>

<textarea
name="description"
rows="10"
cols="120"></textarea>
<br><br>

<input type="submit"
       value="Save Resource">

</form>

<%@ include file="includes/admin-footer.jsp" %>