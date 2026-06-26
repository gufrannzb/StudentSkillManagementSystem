<%-- 
    Document   : manage-certificates
    Created on : Jun 6, 2026, 5:50:07 PM
    Author     : mohdgufran
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="java.util.List"%>
<%@page import="com.skillmanager.model.Certificate"%>

<%@ include file="includes/admin-header.jsp" %>
<%@ include file="includes/admin-sidebar.jsp" %>

<%
if(session.getAttribute("admin") == null){

    response.sendRedirect(
            request.getContextPath()
            + "/admin/admin-login.jsp");

    return;
}
%>

<h1>

Certificate Management

</h1>

<hr>

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

<th>Certificate ID</th>
<th>Student Name</th>
<th>Skill Name</th>
<th>Percentage</th>
<th>Issue Date</th>
<th>Certificate Code</th>
<th>Action</th>

</tr>

<%

for(Certificate certificate
        : certificateList){

%>

<tr>

<td>
<%=certificate.getCertificateId()%>
</td>

<td>
<%=certificate.getStudentName()%>
</td>

<td>
<%=certificate.getSkillName()%>
</td>

<td>
<%=certificate.getPercentage()%>%
</td>

<td>
<%=certificate.getIssueDate()%>
</td>

<td>
<%=certificate.getCertificateCode()%>
</td>

<td>

<a href="<%=request.getContextPath()%>/AdminServlet?action=deleteCertificate&certificateId=<%=certificate.getCertificateId()%>"
onclick="return confirm('Delete Certificate?')">

Delete

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

<%@ include file="includes/admin-footer.jsp" %>