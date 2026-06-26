<%-- 
    Document   : register
    Created on : May 28, 2026
    Author     : mohdgufran
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>Student Registration</title>
    
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/common.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/student.css">

</head>

<body>
    
    <jsp:include page="../includes/header.jsp" />
    


    <h2>Student Registration</h2>
    
    <%

String errorMessage =
(String) request.getAttribute(
        "errorMessage");

String successMessage =
(String) request.getAttribute(
        "successMessage");

if(errorMessage != null){

%>

<p style="color:red;
font-weight:bold;">

<%=errorMessage%>

</p>

<%

}

if(successMessage != null){

%>

<p style="color:green;
font-weight:bold;">

<%=successMessage%>

</p>

<%

}

%>

    <form action="<%=request.getContextPath()%>/AuthServlet"
      method="post">

        <input type="text"
               name="name"
               placeholder="Enter Full Name"
               maxlength="25"
               required>

        <br><br>

        <input type="email"
               name="email"
               placeholder="Enter Email Address"
               maxlength="35"
               required>

        <br><br>
        
        <input type="text"
               name="mobile"
               placeholder="Enter Mobile Number"
               maxlength="10"
               minlength="10"
               required>

        <br><br>

        Date Of Birth

        <br>

        <input type="date"
               name="dob"
               required>

        <br><br>
        
        Gender

        <br>

        <select name="gender"
        required>

        <option value="">
        Select Gender
        </option>

        <option value="Male">
        Male
        </option>

        <option value="Female">
         Female
        </option>

        <option value="Other">
        Other
        </option>

        </select>

        <br><br>

        <input type="password"
               name="password"
               placeholder="Enter Password"
               minlength="8"
               maxlength="25"
               required>
        <br>
        
        <small>

            Password must contain:
            Uppercase, Lowercase,
            Number and Special Character.

        </small>

        <br><br>
        

        <input type="text"
               name="college_id"
               placeholder="Enter College ID"
               maxlength="15"
               required>

        <br><br>

        <select name="department" required>

            <option value="">
                Select Department
            </option>

            <!-- Computer / IT Related -->

            <option value="Computer Science Engineering">
                Computer Science Engineering
            </option>

            <option value="Information Technology">
                Information Technology
            </option>

            <option value="Artificial Intelligence">
                Artificial Intelligence
            </option>

            <option value="Artificial Intelligence and Machine Learning">
                Artificial Intelligence and Machine Learning
            </option>

            <option value="Data Science">
                Data Science
            </option>

            <option value="Cyber Security">
                Cyber Security
            </option>

            <option value="Software Engineering">
                Software Engineering
            </option>

            <!-- Core Engineering -->

            <option value="Electronics and Communication Engineering">
                Electronics and Communication Engineering
            </option>

            <option value="Electrical Engineering">
                Electrical Engineering
            </option>

            <option value="Mechanical Engineering">
                Mechanical Engineering
            </option>

            <option value="Civil Engineering">
                Civil Engineering
            </option>

            <option value="Chemical Engineering">
                Chemical Engineering
            </option>

            <option value="Automobile Engineering">
                Automobile Engineering
            </option>

            <!-- Business / Management -->

            <option value="Business Administration">
                Business Administration
            </option>

            <option value="Marketing">
                Marketing
            </option>

            <option value="Finance">
                Finance
            </option>

            <option value="Human Resource Management">
                Human Resource Management
            </option>

            <!-- Science -->

            <option value="Physics">
                Physics
            </option>

            <option value="Chemistry">
                Chemistry
            </option>

            <option value="Mathematics">
                Mathematics
            </option>

            <!-- Other -->

            <option value="BCA">
                BCA
            </option>

            <option value="MCA">
                MCA
            </option>

            <option value="Other">
                Other
            </option>

        </select>

        <br><br>

        <button type="submit"
                name="action"
                value="register">

            Register

        </button>

    </form>
      

    <br>

    <a href="<%=request.getContextPath()%>/student/login.jsp">
        Already have an account? Login
    </a>

<jsp:include page="../includes/footer.jsp" />        
        
</body>

</html>