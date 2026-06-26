package com.skillmanager.controller;

import com.skillmanager.model.Skill;
import com.skillmanager.model.Result;
import com.skillmanager.model.User;
import com.skillmanager.service.SkillService;
import com.skillmanager.service.ResultService;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class SkillServlet extends HttpServlet {

    SkillService skillService =
            new SkillService();

    ResultService resultService =
            new ResultService();

    protected void processRequest(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException,
            IOException {

        // FETCH ALL SKILLS

        List<Skill> skillList =
                skillService.getAllSkills();

        request.setAttribute(
                "skillList",
                skillList);

        // CHECK LOGIN USER

        HttpSession session =
                request.getSession(false);

        User user = null;

        if(session != null) {

            user =
                    (User) session.getAttribute(
                            "user");
        }

        // FETCH RESULTS ONLY IF USER LOGGED IN

        if(user != null) {

            List<Result> resultList =
                    resultService
                    .getResultsByUserId(
                            user.getUserId());

            request.setAttribute(
                    "resultList",
                    resultList);

            System.out.println(
                    "Logged User ID = "
                    + user.getUserId());

            System.out.println(
                    "Result Count = "
                    + resultList.size());
        }
        
        int testCount = 0;
int certificateCount = 0;

if(user != null) {

    List<Result> resultList =
            resultService
            .getResultsByUserId(
                    user.getUserId());

    request.setAttribute(
            "resultList",
            resultList);

    testCount =
            resultList.size();

    for(Result result
            : resultList) {

        if(result.getPercentage()
                >= 80) {

            certificateCount++;
        }
    }
}

request.setAttribute(
        "testCount",
        testCount);

request.setAttribute(
        "certificateCount",
        certificateCount);

        // FORWARD TO DASHBOARD

        request.getRequestDispatcher(
                "/student/dashboard.jsp")
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