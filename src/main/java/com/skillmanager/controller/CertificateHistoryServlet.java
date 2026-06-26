package com.skillmanager.controller;

import com.skillmanager.model.Certificate;
import com.skillmanager.model.User;
import com.skillmanager.service.CertificateService;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


public class CertificateHistoryServlet
        extends HttpServlet {

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

        List<Certificate> certificateList =
                certificateService
                        .getCertificatesByUserId(
                                user.getUserId());

        request.setAttribute(
                "certificateList",
                certificateList);

        request.getRequestDispatcher(
                "student/history.jsp")
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