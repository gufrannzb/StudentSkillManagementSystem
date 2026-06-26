package com.skillmanager.controller;

import com.skillmanager.model.Question;
import com.skillmanager.model.User;
import com.skillmanager.service.QuestionService;
import com.skillmanager.service.ResultService;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class TestServlet extends HttpServlet {

    QuestionService questionService =
            new QuestionService();

    ResultService resultService =
            new ResultService();

    protected void processRequest(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        // LOGIN CHECK
        HttpSession session =
                request.getSession(false);

        if (session == null
                || session.getAttribute("user") == null) {

            response.sendRedirect(
                    request.getContextPath()
                    + "/student/login.jsp");
            return;
        }

        User user =
                (User) session.getAttribute("user");

        // GET SKILL ID
        String skillIdParam =
                request.getParameter("skill_id");

        if (skillIdParam == null
                || skillIdParam.trim().isEmpty()) {

            response.sendRedirect(
                    request.getContextPath()
                    + "/SkillServlet");
            return;
        }

        int skillId;

        try {
            skillId = Integer.parseInt(skillIdParam);
        } catch (NumberFormatException e) {
            response.sendRedirect(
                    request.getContextPath()
                    + "/SkillServlet");
            return;
        }

        // STEP 1: FIRST CHECK QUESTIONS
        List<Question> questionList =
                questionService.getQuestionsBySkillId(skillId);

        System.out.println("==== TEST SERVLET DEBUG ====");
        System.out.println("Skill ID = " + skillId);
        System.out.println("Question count = "
                + (questionList == null ? 0 : questionList.size()));

        if (questionList == null || questionList.isEmpty()) {

            request.setAttribute(
                    "message",
                    "No questions available for this skill yet.");

            request.getRequestDispatcher(
                    "/student/test-locked.jsp")
                    .forward(request, response);
            return;
        }

        // STEP 2: ONLY AFTER QUESTIONS EXIST, CHECK LOCK
        boolean canAttempt =
                resultService.canAttemptTest(
                        user.getUserId(),
                        skillId);

        System.out.println("Can Attempt = " + canAttempt);

        if (!canAttempt) {

            request.setAttribute(
                    "message",
                    "Your test is locked.");

            request.setAttribute(
                    "retryMessage",
                    "You have already completed this assessment successfully. "
                    + "You can retake this test after 10 days.");

            request.getRequestDispatcher(
                    "/student/test-locked.jsp")
                    .forward(request, response);
            return;
        }

        // STEP 3: OPEN TEST
        request.setAttribute(
                "questionList",
                questionList);

        request.setAttribute(
                "skillId",
                skillId);

        request.getRequestDispatcher(
                "/student/skill-test.jsp")
                .forward(request, response);
    }

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        processRequest(request, response);
    }

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        processRequest(request, response);
    }
}