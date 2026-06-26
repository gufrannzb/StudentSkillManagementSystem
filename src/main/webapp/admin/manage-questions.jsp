<%-- 
    Document   : manage-questions
    Created on : May 28, 2026, 4:28:56 PM
    Author     : mohdgufran
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="java.util.List"%>
<%@page import="com.skillmanager.model.Question"%>

<!DOCTYPE html>

<html>
<head>
    <meta charset="UTF-8">
    <title>Manage Questions</title>
</head>
<body>
    
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

<h1>Manage Questions</h1>

<hr>

<h2>Add New Question</h2>

<form action="<%=request.getContextPath()%>/AdminServlet"
      method="post">

    <input type="hidden"
           name="action"
           value="addQuestion">

    <p>
        Skill ID:
        <input type="number"
               name="skill_id"
               required>
    </p>

    <p>
        Question:
        <input type="text"
               name="question_text"
               size="80"
               required>
    </p>

    <p>
        Option A:
        <input type="text"
               name="option_a"
               required>
    </p>

    <p>
        Option B:
        <input type="text"
               name="option_b"
               required>
    </p>

    <p>
        Option C:
        <input type="text"
               name="option_c"
               required>
    </p>

    <p>
        Option D:
        <input type="text"
               name="option_d"
               required>
    </p>

    <p>
        Correct Answer:
        <select name="correct_answer">

            <option>A</option>
            <option>B</option>
            <option>C</option>
            <option>D</option>

        </select>
    </p>

    <p>
        Topic:
        <input type="text"
               name="topic">
    </p>

    <p>
        Difficulty:
        <select name="difficulty_level">

            <option>Easy</option>
            <option>Medium</option>
            <option>Hard</option>

        </select>
    </p>

    <button type="submit">

        Add Question

    </button>

</form>

<hr>

<h2>All Questions</h2>

<%

    List<Question> questionList =
            (List<Question>)
            request.getAttribute(
                    "questionList");

    if (questionList != null
            && !questionList.isEmpty()) {

%>

<table border="1">

    <tr>

        <th>ID</th>
        <th>Skill ID</th>
        <th>Question</th>
        <th>Answer</th>
        <th>Topic</th>
        <th>Difficulty</th>
        <th>Action</th>

    </tr>

<%

        for (Question question
                : questionList) {

%>
<tr>

    <td>
        <%= question.getQuestionId() %>
    </td>

    <td>
        <%= question.getSkillId() %>
    </td>

    <td>
        <%= question.getQuestionText() %>
    </td>

    <td>
        <%= question.getCorrectAnswer() %>
    </td>

    <td>
        <%= question.getTopic() %>
    </td>

    <td>
        <%= question.getDifficultyLevel() %>
    </td>
    
    <td>

<a href="<%=request.getContextPath()%>/AdminServlet?action=editQuestion&questionId=<%=question.getQuestionId()%>">

    Edit

</a>

|

<a href="<%=request.getContextPath()%>/AdminServlet?action=deleteQuestion&questionId=<%=question.getQuestionId()%>">

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

%>

<%@ include file="includes/admin-footer.jsp" %>

</body>
</html>
