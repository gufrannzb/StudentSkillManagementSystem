package com.skillmanager.controller;

import com.skillmanager.service.AuthService;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class ResetPasswordServlet
        extends HttpServlet {

    AuthService authService =
            new AuthService();

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException,
            IOException {

        String password =
                request.getParameter(
                        "password");

        String confirmPassword =
                request.getParameter(
                        "confirmPassword");

        if(!password.equals(
                confirmPassword)) {

            request.setAttribute(
                    "errorMessage",
                    "Passwords do not match.");

            request.getRequestDispatcher(
                    "/student/reset-password.jsp")
                    .forward(
                            request,
                            response);

            return;
        }

        HttpSession session =
                request.getSession(false);

        if(session == null) {

            response.sendRedirect(
                    request.getContextPath()
                    + "/student/forgot-password.jsp");

            return;
        }

        Integer userId =
                (Integer) session.getAttribute(
                        "resetUserId");

        if(userId == null) {

            response.sendRedirect(
                    request.getContextPath()
                    + "/student/forgot-password.jsp");

            return;
        }

        boolean status =
                authService.updatePassword(
                        userId,
                        password);

        if(status) {

            session.removeAttribute(
                    "otp");

            session.removeAttribute(
                    "resetEmail");

            session.removeAttribute(
                    "resetUserId");

            request.setAttribute(
                    "successMessage",
                    "Password changed successfully. Please login.");

            request.getRequestDispatcher(
                    "/student/login.jsp")
                    .forward(
                            request,
                            response);

        } else {

            request.setAttribute(
                    "errorMessage",
                    "Password reset failed.");

            request.getRequestDispatcher(
                    "/student/reset-password.jsp")
                    .forward(
                            request,
                            response);
        }
    }
}