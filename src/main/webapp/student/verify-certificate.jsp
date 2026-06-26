<%-- 
    Document   : verify-certificate
    Created on : Jun 1, 2026, 10:25:21 AM
    Author     : mohdgufran
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>

<head>

    <title>
        Certificate Verification
    </title>

    <style>

        body {

            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            margin: 0;
            padding: 40px;

        }

        .card {

            max-width: 800px;
            margin: auto;
            background: white;
            padding: 30px;
            border-radius: 12px;
            box-shadow: 0 2px 10px rgba(0,0,0,0.15);

        }

        .verified {

            color: green;
            font-size: 32px;
            font-weight: bold;

        }

        .status {

            color: green;
            font-weight: bold;
            font-size: 22px;

        }

        .label {

            font-weight: bold;

        }

        hr {

            margin-top: 20px;
            margin-bottom: 20px;

        }

    </style>

</head>

<body>
    
    <jsp:include page="../includes/header.jsp" />

<div class="card">

    <div class="verified">

        ✓ Certificate Verified

    </div>

    <p>

        This certificate has been officially
        issued and verified by
        <b>Binary Brains Skill Management System</b>.

    </p>

    <hr>

    <p>

        <span class="label">
            Learner Name:
        </span>

        <%= request.getAttribute(
                "studentName") %>

    </p>

    <p>

        <span class="label">
            Skill:
        </span>

        <%= request.getAttribute(
                "skillName") %>

    </p>

    <p>

        <span class="label">
            Level:
        </span>

        <%= request.getAttribute(
                "level") %>

    </p>

    <p>

        <span class="label">
            Score:
        </span>

        <%= request.getAttribute(
                "percentage") %>%

    </p>

    <p>

        <span class="label">
            Issue Date:
        </span>

        <%= request.getAttribute(
                "issueDate") %>

    </p>

    <p>

        <span class="label">
            Certificate ID:
        </span>

        <%= request.getAttribute(
                "certificateCode") %>

    </p>

    <hr>

    <div class="status">

        VALID CERTIFICATE

    </div>

    <hr>

    <h3>
        About Binary Brains
    </h3>

    <p>

        Binary Brains is a skill assessment
        platform that helps students validate
        their technical knowledge through
        standardized tests and certifications.

    </p>

</div>

<jsp:include page="../includes/footer.jsp" />
                
</body>

</html>
