package com.skillmanager.controller;

import com.skillmanager.service.AuthService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Random;
import com.skillmanager.util.EmailUtil;

public class ForgotPasswordServlet
        extends HttpServlet {

    AuthService authService =
            new AuthService();

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException,
            IOException {

        String email =
                request.getParameter(
                        "email");

        if(!authService.emailExists(
                email)) {

            request.setAttribute(
                    "errorMessage",
                    "Email not found.");

            request.getRequestDispatcher(
                    "/student/forgot-password.jsp")
                    .forward(
                            request,
                            response);

            return;
        }

        String otp =
                String.valueOf(
                        100000
                        + new Random()
                        .nextInt(
                                900000));

        EmailUtil.sendOtp(
                  email,
                        otp);

        HttpSession session =
                request.getSession();

        session.setAttribute(
                "resetEmail",
                email);

        session.setAttribute(
                "otp",
                otp);

        request.setAttribute(
        "successMessage",
        "OTP sent successfully to your email.");


request.getRequestDispatcher(
        "/student/verify-otp.jsp")
        .forward(request, response);

Long lastOtpTime =
        (Long) session.getAttribute(
                "lastOtpTime");

if(lastOtpTime != null
&& System.currentTimeMillis()
- lastOtpTime < 60000) {

    request.setAttribute(
            "errorMessage",
            "Please wait 60 seconds before requesting another OTP.");

    request.getRequestDispatcher(
            "/student/forgot-password.jsp")
            .forward(
                    request,
                    response);

    return;
}

session.setAttribute(
        "lastOtpTime",
        System.currentTimeMillis());
    }
    
    
}

