package com.skillmanager.controller;

import java.io.IOException;
import java.time.LocalDate;

import com.skillmanager.model.Result;
import com.skillmanager.model.User;

import com.skillmanager.service.CertificateService;
import com.skillmanager.service.ResultService;

import com.skillmanager.util.CertificateGenerator;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class DownloadCertificateServlet
        extends HttpServlet {

    ResultService resultService =
            new ResultService();

    CertificateService certificateService =
            new CertificateService();

    protected void processRequest(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException,
            IOException {

        HttpSession session =
                request.getSession();

        User user =
                (User) session.getAttribute(
                        "user");

        String skillIdParam =
                request.getParameter(
                        "skillId");

        if (skillIdParam == null
                || skillIdParam.isEmpty()) {

            response.getWriter().println(
                    "Skill ID Missing");

            return;
        }

        int skillId =
                Integer.parseInt(
                        skillIdParam);

        Result bestResult =
                resultService.getBestResult(
                        user.getUserId(),
                        skillId);

        String certificateCode;

        String existingCode =
                certificateService.getCertificateCode(
                        user.getUserId(),
                        skillId);

        if (existingCode != null) {

            certificateCode =
                    existingCode;

        } else {

            certificateCode =
                    "SSMS-"
                    + bestResult.getSkillId()
                    + "-"
                    + user.getUserId()
                    + "-"
                    + System.currentTimeMillis();

            certificateService.saveCertificate(
                    user.getUserId(),
                    bestResult.getSkillId(),
                    bestResult.getPercentage(),
                    certificateCode);
        }

        response.setContentType(
                "application/pdf");

        response.setHeader(
                "Content-Disposition",
                "attachment; filename=certificate.pdf");

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
                user.getName(),
                bestResult.getSkillName(),
                bestResult.getPercentage(),
                bestResult.getSkillLevel(),
                certificateCode,
                LocalDate.now().toString(),
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