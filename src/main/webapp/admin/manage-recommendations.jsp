<%-- 
    Document   : manage-recommendations
    Created on : Jun 6, 2026, 2:51:49 PM
    Author     : mohdgufran
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.skillmanager.model.Recommendation"%>

<%@ include file="includes/admin-header.jsp" %>
<%@ include file="includes/admin-sidebar.jsp" %>



<h1>Recommendations</h1>

<a href="<%=request.getContextPath()%>/admin/add-recommendation.jsp?skillId=<%=request.getAttribute("skillId")%>">
Add Recommendation
</a>

<hr>

<%
List<Recommendation> recommendationList =
(List<Recommendation>)
request.getAttribute(
        "recommendationList");
%>

<table border="1">

<tr>
<th>ID</th>
<th>Range</th>
<th>Suggestion</th>
<th>Next Topics</th>
<th>Career Roles</th>
<th>Actions</th>
</tr>

<%
for(Recommendation recommendation :
        recommendationList){
%>

<tr>

<td>
<%=recommendation.getRecommendationId()%>
</td>

<td>
<%=recommendation.getPercentageRange()%>
</td>

<td>
<%=recommendation.getSuggestionText()%>
</td>

<td>
<%=recommendation.getNextTopics()%>
</td>

<td>
<%=recommendation.getCareerRoles()%>
</td>

<td>

<a href="<%=request.getContextPath()%>/AdminServlet?action=editRecommendation&recommendationId=<%=recommendation.getRecommendationId()%>">

Edit

</a>

|

<a href="<%=request.getContextPath()%>/AdminServlet?action=deleteRecommendation&recommendationId=<%=recommendation.getRecommendationId()%>"
onclick="return confirm('Delete Recommendation?')">

Delete

</a>

</td>


</tr>


<%
}
%>

<%@ include file="includes/admin-footer.jsp" %>

</table>