<%-- 
    Document   : edit-recommendation
    Created on : Jun 6, 2026, 2:52:39 PM
    Author     : mohdgufran
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.skillmanager.model.Recommendation"%>

<%
Recommendation recommendation =
(Recommendation)
request.getAttribute(
        "recommendation");
%>

<h2>Edit Recommendation</h2>

<form action="<%=request.getContextPath()%>/AdminServlet"
      method="post">

    <input type="hidden"
           name="action"
           value="updateRecommendation">

    <input type="hidden"
           name="recommendationId"
           value="<%=recommendation.getRecommendationId()%>">

    Percentage Range:

    <input type="text"
           name="percentageRange"
           value="<%=recommendation.getPercentageRange()%>">

    <br><br>

    Suggestion:

    <textarea name="suggestionText"><%=recommendation.getSuggestionText()%></textarea>

    <br><br>

    Next Topics:

    <textarea name="nextTopics"><%=recommendation.getNextTopics()%></textarea>

    <br><br>

    Career Roles:

    <textarea name="careerRoles"><%=recommendation.getCareerRoles()%></textarea>

    <br><br>

    <input type="submit"
           value="Update Recommendation">

</form>
    
<%@ include file="includes/admin-footer.jsp" %>    