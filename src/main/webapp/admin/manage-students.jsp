<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="java.util.List"%>
<%@page import="com.skillmanager.model.User"%>

<!DOCTYPE html>

<html>

<head>

    <meta charset="UTF-8">

    <title>Manage Students</title>

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

<h1>Manage Students</h1>

<hr>

<%

List<User> studentList =
        (List<User>)
        request.getAttribute(
                "studentList");

if (studentList != null
        && !studentList.isEmpty()) {

%>

<table border="1">

<tr>

    <th>ID</th>
    <th>Name</th>
    <th>Email</th>
    <th>College ID</th>
    <th>Department</th>
    <th>Action</th>

</tr>

<%

for (User user : studentList) {

%>

<tr>

    <td>
        <%= user.getUserId() %>
    </td>

    <td>
        <%= user.getName() %>
    </td>

    <td>
        <%= user.getEmail() %>
    </td>

    <td>
        <%= user.getCollegeId() %>
    </td>

    <td>
        <%= user.getDepartment() %>
    </td>

    <td>

    <a href="<%=request.getContextPath()%>/AdminServlet?action=viewStudent&userId=<%=user.getUserId()%>">

        View Student

    </a>

    |

    <a href="<%=request.getContextPath()%>/AdminServlet?action=deleteStudent&userId=<%=user.getUserId()%>"
       onclick="return confirm('Delete Student?')">

        Delete Students

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

<p>No Students Found</p>

<%

}

%>

<%@ include file="includes/admin-footer.jsp" %>

</body>

</html>