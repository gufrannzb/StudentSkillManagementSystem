<%-- 
    Document   : add-topic
    Created on : Jun 6, 2026, 1:35:42 AM
    Author     : mohdgufran
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ include file="includes/admin-header.jsp" %>
<%@ include file="includes/admin-sidebar.jsp" %>

<h1>Add Topic</h1>

<form action="<%=request.getContextPath()%>/AdminServlet"
      method="post">

    <input type="hidden"
           name="action"
           value="addTopic">

    Skill ID:
    <input type="number"
           name="skillId">
    <br><br>

    Topic Name:
    <input type="text"
       name="topicName"
       style="width:700px;">
    
    <br><br>

    Topic Content:
    <textarea
        name="topicContent"
        style="width:900px;
               height:250px;">
    </textarea>
    
    <br><br>

    Topic Order:
    <input type="number"
           name="topicOrder">
    <br><br>

    <input type="submit"
           value="Add Topic">

</form>
      
<%@ include file="includes/admin-footer.jsp" %>