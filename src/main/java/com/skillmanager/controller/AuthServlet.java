package com.skillmanager.controller;

import com.skillmanager.model.User;
import com.skillmanager.service.AuthService;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class AuthServlet extends HttpServlet {

    // Object of Service layer
    
    private AuthService authService = new AuthService();

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        

        // Null Check se bachne ke liye
        
        if ("register".equals(action)) {

            String name = request.getParameter("name");
            String email = request.getParameter("email");
            
            if(authService.emailExists(
                email)) {

            request.setAttribute(
                "errorMessage",
                "This email is already registered.<br>"
                + "Please log in or reset your password below.");

            request.getRequestDispatcher(
                "/student/register.jsp")
                    .forward(
                            request,
                            response);

            return;
}
            
            String mobile = request.getParameter("mobile");
            String dob = request.getParameter("dob");
            String gender = request.getParameter("gender");
            String password = request.getParameter("password");
            String collegeId = request.getParameter("college_id");
            String department = request.getParameter("department");
            
            
            
            if(name.length() > 25){

                request.setAttribute(
                    "errorMessage",
                    "Name cannot exceed 25 characters.");

            request.getRequestDispatcher(
                    "/student/register.jsp")
                                .forward(
                                        request,
                                        response);

            return;
}

            if(collegeId.length() > 15){

                request.setAttribute(
                    "errorMessage",
                    "College ID cannot exceed 15 characters.");

                request.getRequestDispatcher(
                    "/student/register.jsp")
                                .forward(
                                        request,
                                        response);

            return;
}

            if(password.length() > 25){

                request.setAttribute(
                    "errorMessage",
                    "Password cannot exceed 25 characters.");

                request.getRequestDispatcher(
                    "/student/register.jsp")
                                .forward(
                                        request,
                                        response);

            return;
}

            
            // Password Validation
            
            if (password == null || !password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$")) {
                request.setAttribute("errorMessage", "Password must contain Uppercase, Lowercase, Number and Special Character.");
                request.getRequestDispatcher("/student/register.jsp").forward(request, response);
                return;
            }

            // 2. Mobile number validation
            
            if (mobile == null || !mobile.matches("[0-9]{10}")) {

                request.setAttribute(
                    "errorMessage",
                    "Invalid Mobile Number");

                request.getRequestDispatcher(
                    "/student/register.jsp")
                               .forward(
                                       request,
                                       response);

    return;
}

            // Prepare to user object
            
            User user = new User();
            user.setName(name);
            user.setEmail(email);
            user.setMobile(mobile);
            try {
                user.setDob(java.sql.Date.valueOf(dob));
            } catch (IllegalArgumentException e) {

                request.setAttribute(
                    "errorMessage",
                    "Invalid Date Format");

                request.getRequestDispatcher(
                    "/student/register.jsp")
                           .forward(
                                    request,
                                    response);

    return;
}
            user.setGender(gender);
            user.setProfileImage(null);
            user.setPassword(password);
            user.setCollegeId(collegeId);
            user.setDepartment(department);

            // save data and send OTP in Section
            
            HttpSession session = request.getSession();
            session.setAttribute("pendingUser", user);

            String otp = String.valueOf(100000 + new java.util.Random().nextInt(900000));
            session.setAttribute("registerOtp", otp);
            session.setAttribute(
            "registerOtpTime",
            System.currentTimeMillis());

            com.skillmanager.util.EmailUtil.sendOtp(email, otp);

            response.sendRedirect(request.getContextPath() + "/student/register-otp.jsp");
            return;

        } 
        
        
        // login Action
        
        else if ("login".equals(action)) {

            String email = request.getParameter("email");
            String password = request.getParameter("password");
            
            if(authService.isAccountLocked(
                email)) {

                request.setAttribute(
                "errorMessage",
                "Account locked after 5 failed attempts. Contact admin.");

                request.getRequestDispatcher(
                "/student/login.jsp")
                .forward(
                        request,
                        response);

    return;
}

            User user = authService.loginUser(email, password);

            if (user != null && "student".equals(user.getRole())) {

                authService.resetFailedAttempts(
                    email);

                HttpSession oldSession =
                    request.getSession(false);

               if(oldSession != null){

                   oldSession.invalidate();
                }

               HttpSession session =
                   request.getSession(true);

               session.setAttribute(
                       "user",
                      user);

               response.sendRedirect(
                       "SkillServlet");
               
            } else {

                authService.incrementFailedAttempts(
                       email);

                int attempts =
                authService.getFailedAttempts(
                    email);

                if(attempts >= 5) {

                    authService.lockAccount(
                            email);

                    request.setAttribute(
                        "errorMessage",
                        "Account locked after 5 failed login attempts. <br> " + "Please try again after 30 minutes or use Forgot Password.");

            } else {

                    request.setAttribute(
                        "errorMessage",
                        "Invalid Email or Password! Attempts Left: "
                    + (5 - attempts));
                }

                   request.getRequestDispatcher(
                        "/student/login.jsp")
                                .forward(
                                        request,
                                        response);
}
            }
        
                // If not met any action
            else {
                  response.getWriter().println("Invalid or Missing Action Parameter!");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        service(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        service(request, response);
    }
        
    
}