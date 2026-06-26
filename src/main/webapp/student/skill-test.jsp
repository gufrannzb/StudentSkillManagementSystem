<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.skillmanager.model.Question"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Skill Test</title>
    
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/common.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/student.css">
    
</head>
<body>

<jsp:include page="../includes/header.jsp" />

<h1>Skill Test</h1>
<hr>

<%
    List<Question> questionList =
            (List<Question>) request.getAttribute("questionList");
%>

<%
    if (questionList != null && !questionList.isEmpty()) {
%>

<form action="<%= request.getContextPath() %>/ResultServlet" method="post">

    <input type="hidden"
           name="skill_id"
           value="<%= request.getAttribute("skillId") %>">

    <%
        int questionNumber = 1;

        for (Question question : questionList) {
    %>

        <div>

            <h3>
                Q<%= questionNumber++ %>.
                <%= question.getQuestionText() %>
            </h3>

            <input type="radio"
                   name="question_<%= question.getQuestionId() %>"
                   value="A"
                   required>
            <%= question.getOptionA() %>

            <br><br>

            <input type="radio"
                   name="question_<%= question.getQuestionId() %>"
                   value="B">
            <%= question.getOptionB() %>

            <br><br>

            <input type="radio"
                   name="question_<%= question.getQuestionId() %>"
                   value="C">
            <%= question.getOptionC() %>

            <br><br>

            <input type="radio"
                   name="question_<%= question.getQuestionId() %>"
                   value="D">
            <%= question.getOptionD() %>

            <br><br>

            <!-- HIDDEN QUESTION ID -->
            <input type="hidden"
                   name="questionIds"
                   value="<%= question.getQuestionId() %>">

            <hr>

        </div>

    <%
        }
    %>

    <button type="submit">
        Submit Test
    </button>

</form>

<%
    } else {
%>

    <p>No questions available for this skill test.</p>

<%
    }
%>

<jsp:include page="../includes/footer.jsp" />

</body>
</html>