<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>Certificate Preview</title>
    
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/common.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/student.css">
</head>
<body>
    
    <jsp:include page="../includes/header.jsp" />

<h2>Certificate Preview</h2>

<iframe
src="<%=request.getContextPath()%>/CertificateServlet?skillId=<%=request.getAttribute("skillId")%>"
width="700"
height="565"
style="border:none;">
</iframe>

<br><br>

<a href="<%=request.getContextPath()%>/SkillServlet">
    Back To Dashboard
</a>

<jsp:include page="../includes/footer.jsp" />
    
</body>
</html>