package com.skillmanager.controller;

import com.skillmanager.dao.QuestionDAO;
import com.skillmanager.model.Question;
import com.skillmanager.model.Result;
import com.skillmanager.model.User;
import com.skillmanager.service.ResultService;

import com.skillmanager.model.Recommendation;
import com.skillmanager.service.RecommendationService;
import com.skillmanager.service.CertificateService;

import com.skillmanager.model.Resource;
import com.skillmanager.service.ResourceService;
import java.util.List;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class ResultServlet extends HttpServlet {

    QuestionDAO questionDAO = new QuestionDAO();

    ResultService resultService = new ResultService();
    
    RecommendationService recommendationService =
        new RecommendationService();
    
    ResourceService resourceService =
        new ResourceService();
    

    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        // GET ALL QUESTION IDS

        String[] questionIds =
                request.getParameterValues(
                    "questionIds");

        if(questionIds == null
                || questionIds.length == 0) {

            HttpSession session =
                request.getSession();

            session.setAttribute(
                "errorMessage",
                "No questions were submitted for this test.");

            response.sendRedirect(
                request.getContextPath()
                + "/SkillServlet");

        return;
}

int totalQuestions =
        questionIds.length;

int correctAnswers = 0;

        // CHECK ANSWERS

    for (String id : questionIds) {

    int questionId;

    try {
        questionId = Integer.parseInt(id);
    } catch (NumberFormatException e) {
        continue;
    }

    Question question =
            questionDAO.getQuestionById(
                    questionId);

    if (question == null) {
        continue;
    }

    String userAnswer =
            request.getParameter(
                    "question_" + questionId
            );

    if (userAnswer != null
            && userAnswer.equals(
                    question.getCorrectAnswer())) {

        correctAnswers++;
    }
}


        // CALCULATE PERCENTAGE

        double percentage =
                ((double) correctAnswers / totalQuestions) * 100;

        // SKILL LEVEL

        String skillLevel;

        if (percentage >= 80) {

            skillLevel = "Advanced";

        } else if (percentage >= 50) {

            skillLevel = "Intermediate";

        } else {

            skillLevel = "Beginner";

        }
        
//        Skill Level

        String range;

        if (percentage <= 40) {

            range = "0-40";

        } else if (percentage <= 60) {

           range = "41-60";

        } else if (percentage <= 80) {

           range = "61-80";

        } else {

           range = "81-100";
}

        // GET LOGGED-IN USER

        HttpSession session =
        request.getSession(false);

        if(session == null
                || session.getAttribute("user") == null) {

            response.sendRedirect(
                   request.getContextPath()
                   + "/student/login.jsp");

        return;
}

User user =
        (User) session.getAttribute("user");

        // SAVE RESULT

        Result result = new Result();

        result.setUserId(
                user.getUserId()
        );

        String skillIdParam =
        request.getParameter(
                "skill_id");

        if(skillIdParam == null
                || skillIdParam.trim().isEmpty()) {

            response.sendRedirect(
                request.getContextPath()
                + "/SkillServlet");

        return;
}

int skillId;

try {

    skillId =
            Integer.parseInt(
                    skillIdParam);

} catch (NumberFormatException e) {

    response.sendRedirect(
            request.getContextPath()
            + "/SkillServlet");

    return;
}

        Recommendation recommendation =
        recommendationService
        .getRecommendationByRange(
                skillId,
                range);
        
        List<Resource> resourceList =
        resourceService
        .getResourcesBySkillIdAndRange(
        skillId,
        range);
        
        System.out.println("Skill ID = " + skillId);
        System.out.println("Range = " + range);

       if(recommendation == null){

           System.out.println("Recommendation Not Found");

        }else{

            System.out.println(
            recommendation.getSuggestionText());
}
        
        result.setSkillId(skillId);

        result.setPercentage(
                percentage
        );

        result.setSkillLevel(
        skillLevel
         );

        Result bestResult =
        resultService.getBestResult(
                user.getUserId(),
                skillId);
        
    if (bestResult != null
            && percentage
            <= bestResult.getPercentage()) {
        
        request.setAttribute(
        "resourceList",
        resourceList);

    request.setAttribute(
            "percentage",
            percentage);

    request.setAttribute(
            "skillLevel",
            skillLevel);

    request.setAttribute(
            "bestPercentage",
            bestResult.getPercentage());

    request.setAttribute(
           "bestSkillLevel",
           bestResult.getSkillLevel());

    request.setAttribute(
            "recommendation",
            recommendation);

    request.setAttribute(
            "correctAnswers",
            correctAnswers);

    request.setAttribute(
            "totalQuestions",
            totalQuestions);

    request.setAttribute(
            "message",
            "Your previous score was better. "
            + "Best score retained.");
    
    request.setAttribute(
        "skillId",
        skillId);

    request.getRequestDispatcher(
        "student/assessment-result.jsp")
        .forward(
                request,
                response);

    return;

}
        resultService.saveResult(
        result);
        
        if(percentage >= 80){

            CertificateService certificateService =
                new CertificateService();

            String existingCode =
                certificateService.getCertificateCode(
                    user.getUserId(),
                    skillId);

        if(existingCode == null){

            String certificateCode =
                "SSMS-"
                + skillId
                + "-"
                + user.getUserId()
                + "-"
                + System.currentTimeMillis();

        certificateService.saveCertificate(
                user.getUserId(),
                skillId,
                percentage,
                certificateCode);
    }
}

        // SEND DATA TO JSP

        request.setAttribute(
                "percentage",
                percentage
        );

        request.setAttribute(
                "correctAnswers",
                correctAnswers
        );

        request.setAttribute(
                "totalQuestions",
                totalQuestions
        );

        request.setAttribute(
                "skillLevel",
                skillLevel
        );
        
        request.setAttribute(
        "bestPercentage",
        percentage
        );

        request.setAttribute(
        "bestSkillLevel",
        skillLevel
        );   
        
        request.setAttribute(
               "recommendation",
               recommendation);
        
        request.setAttribute(
        "resourceList",
        resourceList);

        // FORWARD
        
        request.setAttribute(
        "skillId",
        skillId);

        request.getRequestDispatcher(
        "student/assessment-result.jsp"
                 ).forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request,
        HttpServletResponse response)
        throws ServletException, IOException {

    response.sendRedirect(
            request.getContextPath()
            + "/SkillServlet");
}

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        processRequest(request, response);

    }

}