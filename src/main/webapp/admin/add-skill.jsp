<%-- 
    Document   : add-skill
    Created on : Jun 6, 2026, 12:17:28 PM
    Author     : mohdgufran
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ include file="includes/admin-header.jsp" %>
<%@ include file="includes/admin-sidebar.jsp" %>

<h1>Add Skill</h1>

<form action="<%=request.getContextPath()%>/AdminServlet"
      method="post">

<input type="hidden"
       name="action"
       value="addSkill">

Skill Name

<br>

<input type="text"
       name="skillName"
       required>

<br><br>

Category

<br>

<input type="text"
       name="category"
       required>

<br><br>

Description

<br>

<textarea
name="description"
rows="8"
cols="80"></textarea>

<br><br>

<input type="submit"
       value="Save Skill">

</form>
      
<%@ include file="includes/admin-footer.jsp" %>