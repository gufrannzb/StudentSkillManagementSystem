package com.skillmanager.controller;

import java.io.IOException;
import com.skillmanager.model.Result;
import com.skillmanager.model.User;
import com.skillmanager.service.ResultService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class CertificatePreviewServlet
        extends HttpServlet {

    protected void processRequest(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException,
            IOException {

        HttpSession session =
                request.getSession(false);

        if (session == null) {

            response.sendRedirect(
                    request.getContextPath()
                    + "/student/login.jsp");

            return;
        }

        User user =
                (User) session.getAttribute(
                        "user");

        if (user == null) {

            response.sendRedirect(
                    request.getContextPath()
                    + "/student/login.jsp");

            return;
        }

        int skillId =
                Integer.parseInt(
                        request.getParameter(
                                "skillId"));

        ResultService resultService =
                new ResultService();

        Result result =
                resultService.getBestResult(
                        user.getUserId(),
                        skillId);

        if (result == null) {

            response.sendError(
                    HttpServletResponse.SC_NOT_FOUND,
                    "Certificate Not Found");

            return;
        }

        if (result.getUserId()
                != user.getUserId()) {

            response.sendError(
                    HttpServletResponse.SC_FORBIDDEN,
                    "Access Denied");

            return;
        }

        request.setAttribute(
                "studentName",
                user.getName());

        request.setAttribute(
                "skillName",
                result.getSkillName());

        request.setAttribute(
                "percentage",
                result.getPercentage());

        request.setAttribute(
                "level",
                result.getSkillLevel());

        request.setAttribute(
                "skillId",
                skillId);

        request.getRequestDispatcher(
                "student/certificate.jsp")
                .forward(
                        request,
                        response);
    }

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException,
            IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException,
            IOException {
        processRequest(request, response);
    }
}