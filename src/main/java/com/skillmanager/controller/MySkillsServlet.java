package com.skillmanager.controller;

import com.skillmanager.model.Result;
import com.skillmanager.model.User;
import com.skillmanager.service.ResultService;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


public class MySkillsServlet
        extends HttpServlet {

    ResultService resultService =
            new ResultService();

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

        List<Result> resultList =
                resultService
                        .getResultsByUserId(
                                user.getUserId());

        request.setAttribute(
                "resultList",
                resultList);

        request.getRequestDispatcher(
                "student/my-skills.jsp")
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