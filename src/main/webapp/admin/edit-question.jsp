<%-- 
    Document   : edit-question
    Created on : May 30, 2026, 3:47:23 PM
    Author     : mohdgufran
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="com.skillmanager.model.Question"%>

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

<%

Question question =
        (Question)
        request.getAttribute(
                "question");

%>

<!DOCTYPE html>

<html>

<head>

    <meta charset="UTF-8">

    <title>Edit Question</title>

</head>

<body>

<h1>Edit Question</h1>

<hr>

<form action="<%=request.getContextPath()%>/AdminServlet"
      method="post">

    <input type="hidden"
           name="action"
           value="updateQuestion">

    <input type="hidden"
           name="question_id"
           value="<%=question.getQuestionId()%>">

    <p>

        Skill ID:

        <input type="number"
               name="skill_id"
               value="<%=question.getSkillId()%>"
               required>

    </p>

    <p>

        Question:

        <input type="text"
               name="question_text"
               size="80"
               value="<%=question.getQuestionText()%>"
               required>

    </p>

    <p>

        Option A:

        <input type="text"
               name="option_a"
               value="<%=question.getOptionA()%>"
               required>

    </p>

    <p>

        Option B:

        <input type="text"
               name="option_b"
               value="<%=question.getOptionB()%>"
               required>

    </p>

    <p>

        Option C:

        <input type="text"
               name="option_c"
               value="<%=question.getOptionC()%>"
               required>

    </p>

    <p>

        Option D:

        <input type="text"
               name="option_d"
               value="<%=question.getOptionD()%>"
               required>

    </p>

    <p>

        Correct Answer:

        <input type="text"
               name="correct_answer"
               value="<%=question.getCorrectAnswer()%>"
               required>

    </p>

    <p>

        Topic:

        <input type="text"
               name="topic"
               value="<%=question.getTopic()%>">

    </p>

    <p>

        Difficulty:

        <input type="text"
               name="difficulty_level"
               value="<%=question.getDifficultyLevel()%>">

    </p>

    <button type="submit">

        Update Question

    </button>

</form>
               
<%@ include file="includes/admin-footer.jsp" %>

</body>

</html>