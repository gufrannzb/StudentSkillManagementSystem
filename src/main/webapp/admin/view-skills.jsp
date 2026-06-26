<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="java.util.List"%>
<%@page import="com.skillmanager.model.Skill"%>

<%@ include file="includes/admin-header.jsp" %>
<%@ include file="includes/admin-sidebar.jsp" %>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>View Skills</title>

</head>

<body>

<h1>

All Skills

</h1>
    
<hr>

<a href="<%=request.getContextPath()%>/admin/add-skill.jsp">

Add New Skill

</a>

<hr>

<hr>

<%

List<Skill> skillList =
(List<Skill>)
request.getAttribute(
        "skillList");

if(skillList != null
        && !skillList.isEmpty()) {

%>

<table border="1">

<tr>

<th>ID</th>
<th>Name</th>
<th>Category</th>
<th>Description</th>
<th>Actions</th>

</tr>

<%

for(Skill skill : skillList) {

%>

<tr>

<td>

<%= skill.getSkillId() %>

</td>

<td>

<%= skill.getSkillName() %>

</td>

<td>

<%= skill.getCategory() %>

</td>

<td>

<%= skill.getDescription() %>

</td>

<td>

<a href="<%=request.getContextPath()%>/AdminServlet?action=editSkill&skillId=<%=skill.getSkillId()%>">

Edit

</a>

|

<a href="<%=request.getContextPath()%>/AdminServlet?action=deleteSkill&skillId=<%=skill.getSkillId()%>"
onclick="return confirm('Delete Skill?')">

Delete

</a>
|

<a href="<%=request.getContextPath()%>/AdminServlet?action=manageTopics&skillId=<%=skill.getSkillId()%>">

Topics

</a>

|

<a href="<%=request.getContextPath()%>/AdminServlet?action=manageResources&skillId=<%=skill.getSkillId()%>">

Resources

</a>

|

<a href="<%=request.getContextPath()%>/AdminServlet?action=manageRecommendations&skillId=<%=skill.getSkillId()%>">

Recommendations

</a>

</td>

</tr>

<%

}

%>

</table>

<%

}
else {

%>

<p>

No Skills Found

</p>

<%

}

%>

<%@ include file="includes/admin-footer.jsp" %>

</body>

</html>