<%-- 
    Document   : profile.jsp
    Created on : Jun 1, 2026, 11:29:01 PM
    Author     : mohdgufran
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="com.skillmanager.model.User"%>

<%
    User user =
            (User) session.getAttribute(
                    "user");

    if(user == null){

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

    <title>My Profile</title>
    
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/common.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/student.css">

</head>

<body>

<jsp:include page="../includes/header.jsp" />

<h1>My Profile</h1>

<hr>



<%

String profileImage =
        user.getProfileImage();

if(profileImage == null
        || profileImage.isEmpty()) {

    if("Male".equals(
            user.getGender())) {

        profileImage =
                request.getContextPath()
                    + "/assets/images/profile/male-avatar.png";
    }

    else if("Female".equals(
            user.getGender())) {

        profileImage =
                request.getContextPath()
                    + "/assets/images/profile/female-avatar.png";
    }

    else {

        profileImage =
                request.getContextPath()
                    + "/assets/images/profile/default-avatar.png";
    }
}

%>

<img src="<%= profileImage %>"
     width="120"
     height="120"
     style="border-radius:50%;">
     
<br><br>

<p>
<b>Name:</b>
<%= user.getName() %>
</p>

<p>
<b>Email:</b>
<%= user.getEmail() %>
</p>

<p>
<b>Mobile:</b>
<%= user.getMobile() %>
</p>

<p>
<b>DOB:</b>
<%= user.getDob() %>
</p>

<p>
<b>Gender:</b>
<%= user.getGender() %>
</p>

<p>
<b>College ID:</b>
<%= user.getCollegeId() %>
</p>

<p>
<b>Department:</b>
<%= user.getDepartment() %>
</p>

<br><br>

<a href="<%=request.getContextPath()%>/student/edit-profile.jsp">

Edit Profile

</a>

<br><br>

<hr>

<a href="<%=request.getContextPath()%>/SkillServlet">
    Back To Dashboard
</a>

<jsp:include page="../includes/footer.jsp" />
    
</body>

</html>