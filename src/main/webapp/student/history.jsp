<%-- 
    Document   : history
    Created on : Jun 1, 2026, 11:29:29 PM
    Author     : mohdgufran
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="java.util.List"%>
<%@page import="com.skillmanager.model.Certificate"%>

<!DOCTYPE html>

<html>

<head>

    <meta charset="UTF-8">

    <title>My Certificates</title>
    
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/common.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/student.css">

</head>

<body>

<jsp:include page="../includes/header.jsp" />

<h1>My Certificates</h1>

<hr>

<%

List<Certificate> certificateList =
        (List<Certificate>)
        request.getAttribute(
                "certificateList");

if(certificateList != null
        && !certificateList.isEmpty()) {

    for(Certificate certificate
            : certificateList) {

%>

        <div>

            <p>

                <b>Skill:</b>

                <%= certificate.getSkillName() %>

            </p>

            <p>

                <b>Percentage:</b>

                <%= certificate.getPercentage() %>%

            </p>

            <p>

                <b>Issue Date:</b>

                <%= certificate.getIssueDate() %>

            </p>

            <form
                action="CertificatePreviewServlet"
                method="post">

                <input
                    type="hidden"
                    name="skillId"
                    value="<%= certificate.getSkillId() %>">

                <button type="submit">

                    View Certificate

                </button>

            </form>

            <hr>

        </div>

<%

    }

}
else {

%>

    <div>

        <h3>

            No certificates earned yet.

        </h3>

        <p>

            Complete a course assessment with a qualifying score to earn your first certificate.

        </p>

        <form action="<%=request.getContextPath()%>/SkillServlet"
              method="get">

            <button type="submit">

                Explore Courses

            </button>

        </form>

    </div>

<%

}
%>

<jsp:include page="../includes/footer.jsp" />

</body>

</html>