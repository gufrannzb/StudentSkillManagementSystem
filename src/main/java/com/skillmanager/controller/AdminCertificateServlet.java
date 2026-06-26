package com.skillmanager.controller;

import java.io.IOException;





import com.skillmanager.service.CertificateService;


import com.skillmanager.util.CertificateGenerator;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.skillmanager.model.CertificateVerification;

public class AdminCertificateServlet
        extends HttpServlet {


    CertificateService certificateService =
            new CertificateService();

    protected void processRequest(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException,
            IOException {

        String certificateCode =
        request.getParameter(
                "code");
        
        CertificateVerification certificate =
        certificateService
        .getCertificateByCode(
                certificateCode);

if(certificate == null){

    response.getWriter().println(
            "Certificate Not Found");

    return;
}

response.setContentType(
        "application/pdf");

response.setHeader(
        "Content-Disposition",
        "inline; filename=certificate.pdf");

String verifyUrl =
        "http://localhost:8080/"
        + "StudentSkillManagementSystem/"
        + "VerifyCertificate?code="
        + certificateCode;

String imagePath =
        getServletContext()
        .getRealPath(
                "/assets/images/certificate-template.png");

CertificateGenerator.generateCertificate(
        response.getOutputStream(),
        imagePath,
        certificate.getStudentName(),
        certificate.getSkillName(),
        certificate.getPercentage(),
        certificate.getLevel(),
        certificate.getCertificateCode(),
        certificate.getIssueDate(),
        verifyUrl);

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