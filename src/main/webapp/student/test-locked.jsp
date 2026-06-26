<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>



<%@ include file="../includes/header.jsp" %>

<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/common.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/student.css">

<%
String message =
        (String) request.getAttribute("message");

String retryMessage =
        (String) request.getAttribute("retryMessage");
%>

<%
if ("No questions available for this skill yet.".equals(message)) {
%>

    <h1>Test Not Available</h1>

    <br>

    <h2>No questions are available for this skill yet.</h2>

    <h3>Please try again later after the assessment is added.</h3>

    <h3>You can continue exploring other available skills in the meantime.</h3>

<%
} else {
%>

    <h1>Test Temporarily Locked</h1>

    <br>

    <h2>
        <%= retryMessage != null
                ? retryMessage
                : "You have already completed this assessment successfully." %>
    </h2>

    <h3>Your current score meets the required performance criteria.</h3>

    <h3>To maintain assessment integrity, this test has been temporarily locked.</h3>

    <h3>You will be eligible to retake this test after 10 days.</h3>

    <h3>Continue exploring new skills and enhancing your knowledge.</h3>

<%
}
%>

<br><br>

<a href="<%=request.getContextPath()%>/SkillServlet">
    Back To Skills
</a>

<br><br>

<%@ include file="../includes/footer.jsp" %>