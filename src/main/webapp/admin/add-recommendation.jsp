<%-- 
    Document   : add-recommendation
    Created on : Jun 6, 2026, 2:52:18 PM
    Author     : mohdgufran
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ include file="includes/admin-header.jsp" %>
<%@ include file="includes/admin-sidebar.jsp" %>

<html>
<body>

<h2>Add Recommendation</h2>

<form action="<%=request.getContextPath()%>/AdminServlet"
      method="post">

    <input type="hidden"
           name="action"
           value="addRecommendation">

    <input type="hidden"
           name="skillId"
           value="<%=request.getParameter("skillId")%>">

    Percentage Range:

    <input type="text"
           name="percentageRange">

    <br><br>

    Suggestion:

    <textarea name="suggestionText"></textarea>

    <br><br>

    Next Topics:

    <textarea name="nextTopics"></textarea>

    <br><br>

    Career Roles:

    <textarea name="careerRoles"></textarea>

    <br><br>

    <input type="submit"
           value="Add Recommendation">

</form>

 <%@ include file="includes/admin-footer.jsp" %>
 
</body>
</html>