<%-- 
    Document   : edit-profile
    Created on : Jun 3, 2026, 4:35:36 PM
    Author     : mohdgufran
--%>

<%@page contentType="text/html"
        pageEncoding="UTF-8"%>

<%@page import="com.skillmanager.model.User"%>

<%

User user =
        (User) session.getAttribute(
                "user");

if(user == null) {

    response.sendRedirect(
            request.getContextPath()
            + "/student/login.jsp");

    return;
}

%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>Edit Profile</title>

<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/common.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/student.css">

</head>

<body>

<jsp:include page="../includes/header.jsp" />

<h1>

Edit Profile

</h1>

<hr>

<%
String errorMessage =
        (String) request.getAttribute(
                "errorMessage");

if(errorMessage != null){
%>

<p style="color:red;">

<%= errorMessage %>

</p>

<%
}
%>

<form action="<%=request.getContextPath()%>/UpdateProfileServlet"
      method="post"
      enctype="multipart/form-data">

Name

<br>

<input type="text"
       name="name"
       value="<%= user.getName() %>"
       required>

<br><br>

Mobile

<br>

<input type="text"
       name="mobile"
       value="<%= user.getMobile() %>"
       maxlength="10"
       required>

<br><br>

Gender

<br>

<select name="gender"
        required>

<option value="Male"
<%= "Male".equals(
        user.getGender())
? "selected" : "" %>>

Male

</option>

<option value="Female"
<%= "Female".equals(
        user.getGender())
? "selected" : "" %>>

Female

</option>

<option value="Other"
<%= "Other".equals(
        user.getGender())
? "selected" : "" %>>

Other

</option>

</select>

<br><br>

Profile Picture

<br>

<input type="file"
       name="profileImage"
       accept=".jpg,.jpeg,.png,.webp">

<br>

<small>

Max Size: 10 MB

</small>

<br><br>

<button type="submit">

Update Profile

</button>

</form>

</body>
<br><br><br><br>

<jsp:include page="../includes/footer.jsp" />

</html>