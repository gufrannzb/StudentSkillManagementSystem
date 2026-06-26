<%-- 
    Document   : privacy
    Created on : Jun 5, 2026, 8:30:02 PM
    Author     : mohdgufran
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Privacy Policy - Student Skill Management System</title>
    
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/common.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/student.css">
    
</head>
<body>
    
    <jsp:include page="../includes/header.jsp" />

    <main class="privacy-container">
        
        <header class="privacy-header">
            <h1>Privacy Policy</h1>
            <p>Last Updated: <%= new java.text.SimpleDateFormat("MMMM dd, yyyy").format(new java.util.Date()) %></p>
        </header>

        <hr>

        <section class="privacy-section">
            <h2>1. Introduction</h2>
            <p>Welcome to the <strong>Student Skill Management System</strong>. We value your privacy and are committed to protecting your personal data. This Privacy Policy explains how we collect, use, and safeguard your information when you use our platform to track, manage, and showcase your professional and academic skills.</p>
        </section>

        <section class="privacy-section">
            <h2>2. Information We Collect</h2>
            <p>To provide a better experience, we may collect the following types of information:</p>
            <ul>
                <li><strong>Personal Details:</strong> Name, Email Address, University Roll Number, and Profile Pictures.</li>
                <li><strong>Academic & Skill Data:</strong> Skills added, certificates uploaded, project details, and performance scores on the leaderboard.</li>
                <li><strong>Technical Data:</strong> IP address, browser type, and login session details to ensure secure access.</li>
            </ul>
        </section>

        <section class="privacy-section">
            <h2>3. How We Use Your Information</h2>
            <p>We use the collected data for the following purposes:</p>
            <ul>
                <li>To create and maintain your student/developer profile.</li>
                <li>To display rankings on the Student Leaderboard based on skills and performance.</li>
                <li>To send system updates, notifications, or responses to your queries via email.</li>
                <li>To secure the platform and prevent unauthorized access or system misuse.</li>
            </ul>
        </section>

        <section class="privacy-section">
            <h2>4. Data Visibility and Sharing</h2>
            <p>Since this is a Skill Management platform:</p>
            <ul>
                <li>Your selected skills, projects, and leaderboard rankings are visible to peers and registered administrators (teachers/mentors).</li>
                <li>We <strong>do not sell, trade, or share</strong> your personal information with third-party advertising companies.</li>
                <li>Your external social media links (Instagram, Facebook, X, Gmail) provided on profile pages are publicly accessible to help you connect with others.</li>
            </ul>
        </section>

        <section class="privacy-section">
            <h2>5. Data Security</h2>
            <p>We implement standard security measures to protect your data from unauthorized access, alteration, or disclosure. However, please remember that no method of transmission over the internet or electronic storage is 100% secure.</p>
        </section>

        <section class="privacy-section">
            <h2>6. Changes to This Privacy Policy</h2>
            <p>We may update our Privacy Policy from time to time. Any changes will be posted directly on this page with an updated modification date.</p>
        </section>

        <section class="privacy-section contact-info">
            <h2>7. Contact Us</h2>
            <p>If you have any questions or suggestions about this Privacy Policy, please contact us at:</p>
            <p><strong>Email:</strong> mohd_gufranbca2023@msit.edu.in</p>
            <p><strong>Location:</strong> East Topsia, Kolkata, Pin- 700100West Bengal, India</p>
        </section>

    </main>

        
    <jsp:include page="../includes/footer.jsp" />
    
</body>
</html>