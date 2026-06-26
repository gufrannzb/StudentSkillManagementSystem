package com.skillmanager.controller;

import com.skillmanager.dao.UserDAO;
import com.skillmanager.model.User;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class VerifyOtpServlet extends HttpServlet {

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String enteredOtp =
                request.getParameter("otp");

        HttpSession session =
                request.getSession(false);

        if (session == null) {

            response.sendRedirect(
                    request.getContextPath()
                    + "/student/forgot-password.jsp");
            return;
        }

        String actualOtp =
                (String) session.getAttribute("otp");

        String resetEmail =
                (String) session.getAttribute("resetEmail");

        if (actualOtp == null || resetEmail == null) {

            response.sendRedirect(
                    request.getContextPath()
                    + "/student/forgot-password.jsp");
            return;
        }

        if (actualOtp.equals(enteredOtp)) {

            // Email se user fetch karo aur userId session mein save karo
            UserDAO userDAO = new UserDAO();

            User user = userDAO.getUserByEmail(resetEmail);

            if (user != null) {

                session.setAttribute(
                        "resetUserId",
                        user.getUserId());

                response.sendRedirect(
                        request.getContextPath()
                        + "/student/reset-password.jsp");

            } else {

                request.setAttribute(
                        "errorMessage",
                        "User not found. Try again.");

                request.getRequestDispatcher(
                        "/student/forgot-password.jsp")
                        .forward(request, response);
            }

        } else {

            request.setAttribute(
                    "errorMessage",
                    "Invalid OTP. Please try again.");

            request.getRequestDispatcher(
                    "/student/verify-otp.jsp")
                    .forward(request, response);
        }
    }
}