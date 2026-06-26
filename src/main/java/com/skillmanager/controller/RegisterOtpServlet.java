package com.skillmanager.controller;

import com.skillmanager.model.User;
import com.skillmanager.service.AuthService;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class RegisterOtpServlet
        extends HttpServlet {

    AuthService authService =
            new AuthService();

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException,
            IOException {

        String enteredOtp =
                request.getParameter(
                        "otp");

        HttpSession session =
                request.getSession(false);

        if(session == null) {

            response.sendRedirect(
                    request.getContextPath()
                    + "/student/register.jsp");

            return;
        }

        String actualOtp =
                (String) session.getAttribute(
                        "registerOtp");
        
        Long otpTime =
        (Long) session.getAttribute(
                "registerOtpTime");

        User user =
                (User) session.getAttribute(
                        "pendingUser");

        if(actualOtp == null
        || user == null) {
            
            if(otpTime == null
            || System.currentTimeMillis()
            - otpTime > 300000) {

                    request.setAttribute(
                    "errorMessage",
                    "OTP expired. Please register again.");

                    request.getRequestDispatcher(
                    "/student/register.jsp")
                    .forward(
                            request,
                            response);

    return;
}

            response.sendRedirect(
                    request.getContextPath()
                    + "/student/register.jsp");

            return;
        }

        if(actualOtp.equals(
                enteredOtp)) {

            boolean status =
                    authService.registerUser(
                            user);

            if(status) {

                session.removeAttribute(
                        "registerOtp");

                session.removeAttribute(
                        "pendingUser");

                request.setAttribute(
                        "successMessage",
                        "Registration Successful. Please Login.");

                request.getRequestDispatcher(
                        "/student/login.jsp")
                        .forward(
                                request,
                                response);

            } else {

                request.setAttribute(
                     "errorMessage",
                     "Registration Failed. Please try again.");

                request.getRequestDispatcher(
                     "/student/register-otp.jsp")
                    .forward(
                            request,
                            response);
            }

        } else {

            request.setAttribute(
                    "errorMessage",
                    "Invalid OTP");

            request.getRequestDispatcher(
                    "/student/register-otp.jsp")
                    .forward(
                            request,
                            response);
        }
    }
}