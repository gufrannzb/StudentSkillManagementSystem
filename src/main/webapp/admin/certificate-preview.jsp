<%-- 
    Document   : certificate-preview
    Created on : Jun 9, 2026, 3:28:49 PM
    Author     : mohdgufran
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%@page import="com.skillmanager.model.CertificateVerification"%>

<%@ include file="includes/admin-header.jsp" %>
<%@ include file="includes/admin-sidebar.jsp" %>

<%
CertificateVerification certificate =
(CertificateVerification)
request.getAttribute("certificate");
%>

<div
style="
width:900px;
margin:auto;
padding:40px;
border:10px solid #0d6efd;
text-align:center;
background:white;
">

<h1>

Certificate of Achievement

</h1>

<hr>

<h2>

<%=certificate.getStudentName()%>

</h2>

<h3>

Successfully Completed

</h3>

<h2>

<%=certificate.getSkillName()%>

</h2>

<p>

Level:
<b>

<%=certificate.getLevel()%>

</b>

</p>

<p>

Score:
<b>

<%=certificate.getPercentage()%>%

</b>

</p>

<p>

Certificate ID:
<b>

<%=certificate.getCertificateCode()%>

</b>

</p>

<p>

Issue Date:
<b>

<%=certificate.getIssueDate()%>

</b>

</p>

<br>

<button
onclick="window.print()">

Download / Print Certificate

</button>

</div>
</p>

<%@ include file="includes/admin-footer.jsp" %>