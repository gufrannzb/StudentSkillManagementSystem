package com.skillmanager.controller;

import java.io.IOException;

import com.skillmanager.model.CertificateVerification;
import com.skillmanager.service.CertificateService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class VerifyCertificateServlet
        extends HttpServlet {

    protected void processRequest(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException,
            IOException {

        String code =
                request.getParameter(
                        "code");

        CertificateService service =
                new CertificateService();

        CertificateVerification certificate =
                service.getCertificateByCode(
                        code);

        if (certificate == null) {

            response.setContentType(
                    "text/html");

            response.getWriter().println(
                    "<h1>Invalid Certificate</h1>");

            return;
        }

        request.setAttribute(
                "studentName",
                certificate.getStudentName());

        request.setAttribute(
                "skillName",
                certificate.getSkillName());

        request.setAttribute(
                "percentage",
                certificate.getPercentage());

        request.setAttribute(
                "issueDate",
                certificate.getIssueDate());

        request.setAttribute(
                "certificateCode",
                certificate.getCertificateCode());
        request.setAttribute(
        "level",
        certificate.getLevel());

        request.getRequestDispatcher(
        "/student/verify-certificate.jsp")
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

        processRequest(
                request,
                response);
    }

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException,
            IOException {

        processRequest(
                request,
                response);
    }
}