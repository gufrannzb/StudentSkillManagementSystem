package com.skillmanager.controller;

import com.skillmanager.model.User;
import com.skillmanager.service.AuthService;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author mohdgufran
 */

public class AdminAuthServlet
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

        String password =
                request.getParameter(
                        "password");

        User user =
                authService.loginUser(
                        email,
                        password);
       

        if (user != null
                && user.getRole()
                .equals("admin")) {

            HttpSession session =
                    request.getSession();

            session.setAttribute(
                    "admin",
                    user);

            response.sendRedirect(
                    "AdminServlet");

        }

        else {

            request.setAttribute(
                    "errorMessage",
                    "Invalid Email or Password!");

            request.getRequestDispatcher(
                    "/admin/admin-login.jsp")
                    .forward(
                            request,
                            response);
        }

    }

}