<%-- 
    Document   : edit-skill
    Created on : Jun 6, 2026, 12:29:29 PM
    Author     : mohdgufran
--%>

<%@page import="com.skillmanager.model.Skill"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ include file="includes/admin-header.jsp" %>
<%@ include file="includes/admin-sidebar.jsp" %>

<%
Skill skill =
(Skill)request.getAttribute(
        "skill");
%>

<h1>Edit Skill</h1>

<form action="<%=request.getContextPath()%>/AdminServlet"
      method="post">

<input type="hidden"
       name="action"
       value="updateSkill">

<input type="hidden"
       name="skillId"
       value="<%=skill.getSkillId()%>">

Skill Name

<br>

<input type="text"
       name="skillName"
       value="<%=skill.getSkillName()%>"
       required>

<br><br>

Category

<br>

<input type="text"
       name="category"
       value="<%=skill.getCategory()%>"
       required>

<br><br>

Description

<br>

<textarea
name="description"
rows="8"
cols="80"><%=skill.getDescription()%></textarea>

<br><br>

<input type="submit"
       value="Update Skill">

</form>

<%@ include file="includes/admin-footer.jsp" %>