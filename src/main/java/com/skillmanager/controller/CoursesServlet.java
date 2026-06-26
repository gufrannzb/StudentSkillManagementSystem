package com.skillmanager.controller;

import com.skillmanager.model.Skill;
import com.skillmanager.service.SkillService;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class CoursesServlet
        extends HttpServlet {

    SkillService skillService =
            new SkillService();

    protected void processRequest(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException,
            IOException {

        List<Skill> skillList =
                skillService
                        .getAllSkills();

        request.setAttribute(
                "skillList",
                skillList);

        request.getRequestDispatcher(
                "student/courses.jsp")
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