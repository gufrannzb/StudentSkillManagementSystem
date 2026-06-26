<%-- 
    Document   : student-details
    Created on : Jun 9, 2026, 3:58:26 AM
    Author     : mohdgufran
--%>

<%@page contentType="text/html"
pageEncoding="UTF-8"%>

<%@page import="com.skillmanager.model.User"%>
<%@page import="com.skillmanager.model.Certificate"%>

<%@page import="java.util.List"%>
<%@page import="com.skillmanager.model.Result"%>

<%@ include file="includes/admin-header.jsp" %>
<%@ include file="includes/admin-sidebar.jsp" %>

<%

User student =
(User) request.getAttribute(
        "student");

%>

<h1>

Student Details

</h1>

<hr>

<p>

<b>Name:</b>

<%=student.getName()%>

</p>

<p>

<b>Email:</b>

<%=student.getEmail()%>

</p>

<p>

<b>College ID:</b>

<%=student.getCollegeId()%>

</p>

<p>

<b>Department:</b>

<%=student.getDepartment()%>

</p>

<p>

<b>Mobile:</b>

<%=student.getMobile()%>

</p>

<p>

<b>Gender:</b>

<%=student.getGender()%>

</p>

<hr>

<h2>

Student Results

</h2>

<%

List<Result> resultList =
(List<Result>)
request.getAttribute(
        "resultList");

if(resultList != null
        && !resultList.isEmpty()) {

%>

<table border="1">

<tr>

<th>Skill</th>
<th>Percentage</th>
<th>Level</th>

</tr>

<%

for(Result result
        : resultList) {

%>

<tr>

<td>

<%=result.getSkillName()%>

</td>

<td>

<%=result.getPercentage()%>%

</td>

<td>

<%=result.getSkillLevel()%>

</td>

</tr>

<%

}

%>

</table>

<hr>


<hr>

<h2>

Student Progress

</h2>

<%

Integer completedTopics =
(Integer)
request.getAttribute(
        "completedTopics");

Integer totalTopics =
(Integer)
request.getAttribute(
        "totalTopics");

double progress = 0;

if(totalTopics != null
        && totalTopics > 0){

    progress =
    ((double)completedTopics
            / totalTopics)
            * 100;
}

%>

<p>

Topics Completed :

<b>

<%=completedTopics%>

</b>

</p>

<p>

Total Topics :

<b>

<%=totalTopics%>

</b>

</p>

<p>

Progress :

<b>

<%=String.format(
        "%.2f",
        progress)%>%

</b>

</p>

<h2>

Student Certificates

</h2>

<%

List<Certificate> certificateList =
(List<Certificate>)
request.getAttribute(
        "certificateList");

if(certificateList != null
        && !certificateList.isEmpty()) {

%>

<table border="1">

<tr>

<th>Skill</th>
<th>Percentage</th>
<th>Certificate Code</th>
<th>Action</th>

</tr>

<%

for(Certificate certificate
        : certificateList) {

%>

<tr>

<td>

<%=certificate.getSkillName()%>

</td>

<td>

<%=certificate.getPercentage()%>%

</td>

<td>

<%=certificate.getCertificateCode()%>

</td>

<td>

<a href="<%=request.getContextPath()%>/AdminCertificateServlet?code=<%=certificate.getCertificateCode()%>"
target="_blank">

View Certificate

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

No Certificates Found

</p>

<%

}

%>

<%

}
else {

%>

<p>

No Results Found

</p>

<%

}

%>

<%@ include file="includes/admin-footer.jsp" %>