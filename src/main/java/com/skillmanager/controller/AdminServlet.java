package com.skillmanager.controller;

import com.skillmanager.model.Question;
import com.skillmanager.service.QuestionService;

import com.skillmanager.model.User;
import com.skillmanager.service.AuthService;
import com.skillmanager.service.ResultService;
import com.skillmanager.model.Result;

import com.skillmanager.service.SkillService;
import com.skillmanager.model.Skill;
import com.skillmanager.model.Topic;
import com.skillmanager.service.TopicService;

import com.skillmanager.service.UserService;
import com.skillmanager.model.CertificateVerification;

import com.skillmanager.service.ProgressService;




import com.skillmanager.model.Resource;
import com.skillmanager.service.ResourceService;

import com.skillmanager.service.CertificateService;
import com.skillmanager.model.Certificate;

import com.skillmanager.model.Recommendation;
import java.util.List;

import com.skillmanager.service.RecommendationService;


import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AdminServlet extends HttpServlet {
    
    
    
 UserService userService =
        new UserService();   
    
SkillService skillService =
        new SkillService();

TopicService topicService =
        new TopicService();

ResourceService resourceService =
        new ResourceService();

RecommendationService recommendationService =
        new RecommendationService();

QuestionService questionService =
        new QuestionService();

AuthService authService =
        new AuthService();

ResultService resultService =
        new ResultService();

CertificateService certificateService =
        new CertificateService();

protected void processRequest(
        HttpServletRequest request,
        HttpServletResponse response)
        throws ServletException, IOException {

    String action =
            request.getParameter("action");
    
    if(action == null){

    request.setAttribute(
            "totalStudents",
            authService
            .getAllStudents()
            .size());

    request.setAttribute(
            "totalSkills",
            skillService
            .getAllSkills()
            .size());

    request.setAttribute(
            "totalTests",
            resultService
            .getAllResults()
            .size());

    request.setAttribute(
            "totalCertificates",
            certificateService
            .getAllCertificates()
            .size());

    request.getRequestDispatcher(
            "admin/admin-dashboard.jsp")
            .forward(
                    request,
                    response);

    return;
}
    
    else if("dashboard".equals(action)) {

    request.setAttribute(
            "totalStudents",
            authService
            .getAllStudents()
            .size());

    request.setAttribute(
            "totalSkills",
            skillService
            .getAllSkills()
            .size());

    request.setAttribute(
            "totalTests",
            resultService
            .getAllResults()
            .size());

    request.setAttribute(
            "totalCertificates",
            certificateService
            .getAllCertificates()
            .size());

    request.getRequestDispatcher(
            "admin/admin-dashboard.jsp")
            .forward(
                    request,
                    response);
    
    return;
}

    if ("addQuestion".equals(action)) {

        Question question =
                new Question();

        question.setSkillId(
                Integer.parseInt(
                        request.getParameter("skill_id")));

        question.setQuestionText(
                request.getParameter("question_text"));

        question.setOptionA(
                request.getParameter("option_a"));

        question.setOptionB(
                request.getParameter("option_b"));

        question.setOptionC(
                request.getParameter("option_c"));

        question.setOptionD(
                request.getParameter("option_d"));

        question.setCorrectAnswer(
                request.getParameter("correct_answer"));

        question.setTopic(
                request.getParameter("topic"));

        question.setDifficultyLevel(
                request.getParameter("difficulty_level"));
        
        

        boolean status =
                questionService.addQuestion(
                        question);

        if (status) {

            response.getWriter().println(
                    "Question Added Successfully!"
            );

        } else {

            response.getWriter().println(
                    "Failed To Add Question!"
            );

        }

    }
    
    else if ("viewStudents".equals(action)) {

    List<User> studentList =
            authService
                    .getAllStudents();

    request.setAttribute(
            "studentList",
            studentList);

    request.getRequestDispatcher(
            "admin/manage-students.jsp")
            .forward(
                    request,
                    response);
    

}
    
    else if ("deleteStudent".equals(action)) {

    int userId =
            Integer.parseInt(
                    request.getParameter(
                            "userId"));

    authService
            .deleteStudent(
                    userId);

    response.sendRedirect(
            request.getContextPath()
            + "/AdminServlet?action=viewStudents");

}   
    
  else if("viewStudent".equals(
        action)) {

    int userId =
            Integer.parseInt(
                    request.getParameter(
                            "userId"));

    User student =
            authService
            .getStudentById(
                    userId);
    
    List<Result> resultList =
        resultService
        .getResultsByUserId(
                userId);

    List<Certificate> certificateList =
        certificateService
        .getCertificatesByUserId(
                userId);
    
    ProgressService progressService =
        new ProgressService();

int completedTopics = 0;
int totalTopics = 0;

if(resultList != null
        && !resultList.isEmpty()) {

    int skillId =
            resultList.get(0)
            .getSkillId();

    completedTopics =
            progressService
            .getCompletedTopicsCount(
                    userId,
                    skillId);

    totalTopics =
            progressService
            .getTotalTopicsCount(
                    skillId);
}
    

    request.setAttribute(
            "student",
            student);
    
    request.setAttribute(
        "completedTopics",
        completedTopics);

    request.setAttribute(
        "totalTopics",
        totalTopics);
    
    request.setAttribute(
        "resultList",
        resultList);

    request.setAttribute(
        "certificateList",
        certificateList);


    request.getRequestDispatcher(
            "admin/student-details.jsp")
            .forward(
                    request,
                    response);
}
    

    
    else if ("viewQuestions".equals(action)) {

    List<Question> questionList =
            questionService
                    .getAllQuestions();

    request.setAttribute(
            "questionList",
            questionList);

    request.getRequestDispatcher(
            "admin/manage-questions.jsp")
            .forward(
                    request,
                    response);

}
    
    else if ("viewSkills".equals(action)) {

    List<Skill> skillList =
            skillService
                    .getAllSkills();

    request.setAttribute(
            "skillList",
            skillList);

    request.getRequestDispatcher(
            "admin/view-skills.jsp")
            .forward(
                    request,
                    response);
    
    

}
    
    else if ("manageTopics".equals(action)) {

    int skillId =
            Integer.parseInt(
                    request.getParameter(
                            "skillId"));

    List<Topic> topicList =
            topicService
            .getTopicsBySkillId(
                    skillId);

    request.setAttribute(
            "topicList",
            topicList);

    request.getRequestDispatcher(
            "admin/manage-topics.jsp")
            .forward(
                    request,
                    response);
}
    
    else if ("manageResources".equals(action)) {

    int skillId =
            Integer.parseInt(
                    request.getParameter(
                            "skillId"));

    List<Resource> resourceList =
            resourceService
            .getResourcesBySkillId(
                    skillId);

    request.setAttribute(
            "resourceList",
            resourceList);

    request.getRequestDispatcher(
            "admin/manage-resources.jsp")
            .forward(
                    request,
                    response);
}
    
    else if ("manageRecommendations".equals(action)) {

    int skillId =
            Integer.parseInt(
                    request.getParameter(
                            "skillId"));

    List<Recommendation> recommendationList =
            recommendationService
            .getRecommendationsBySkillId(
                    skillId);

    request.setAttribute(
            "recommendationList",
            recommendationList);

    request.setAttribute(
            "skillId",
            skillId);

    request.getRequestDispatcher(
            "admin/manage-recommendations.jsp")
            .forward(
                    request,
                    response);
}
    
 
    
    else if ("editResource".equals(action)) {

    int resourceId =
            Integer.parseInt(
                    request.getParameter(
                            "resourceId"));

    Resource resource =
            resourceService
            .getResourceById(
                    resourceId);

    request.setAttribute(
            "resource",
            resource);

    request.getRequestDispatcher(
            "admin/edit-resource.jsp")
            .forward(
                    request,
                    response);
}
    
    else if ("updateResource".equals(action)) {

    Resource resource =
            new Resource();

    resource.setResourceId(
            Integer.parseInt(
                    request.getParameter(
                            "resourceId")));

    resource.setSkillId(
            Integer.parseInt(
                    request.getParameter(
                            "skillId")));
    
    resource.setPercentageRange(
        request.getParameter(
                "percentageRange"));

    resource.setResourceType(
            request.getParameter(
                    "resourceType"));

    resource.setTitle(
            request.getParameter(
                    "title"));

    resource.setLink(
            request.getParameter(
                    "link"));

    resource.setDescription(
            request.getParameter(
                    "description"));

    resourceService
            .updateResource(
                    resource);

    response.sendRedirect(
            request.getContextPath()
            + "/AdminServlet?action=viewSkills");
}
    
    
    else if ("deleteResource".equals(action)) {

    int resourceId =
            Integer.parseInt(
                    request.getParameter(
                            "resourceId"));

    resourceService
            .deleteResource(
                    resourceId);

    response.sendRedirect(
            request.getContextPath()
            + "/AdminServlet?action=viewSkills");
}
    
    else if ("deleteRecommendation".equals(action)) {

    int recommendationId =
            Integer.parseInt(
                    request.getParameter(
                            "recommendationId"));

    recommendationService
            .deleteRecommendation(
                    recommendationId);

    response.sendRedirect(
            request.getContextPath()
            + "/AdminServlet?action=viewSkills");
}
    
    else if ("editRecommendation".equals(action)) {

    int recommendationId =
            Integer.parseInt(
                    request.getParameter(
                            "recommendationId"));

    Recommendation recommendation =
            recommendationService
            .getRecommendationById(
                    recommendationId);

    request.setAttribute(
            "recommendation",
            recommendation);

    request.getRequestDispatcher(
            "admin/edit-recommendation.jsp")
            .forward(
                    request,
                    response);
}
    
    else if ("updateRecommendation".equals(action)) {

    Recommendation recommendation =
            new Recommendation();

    recommendation.setRecommendationId(
            Integer.parseInt(
                    request.getParameter(
                            "recommendationId")));

    recommendation.setPercentageRange(
            request.getParameter(
                    "percentageRange"));

    recommendation.setSuggestionText(
            request.getParameter(
                    "suggestionText"));

    recommendation.setNextTopics(
            request.getParameter(
                    "nextTopics"));

    recommendation.setCareerRoles(
            request.getParameter(
                    "careerRoles"));

    recommendationService
            .updateRecommendation(
                    recommendation);

    response.sendRedirect(
            request.getContextPath()
            + "/AdminServlet?action=viewSkills");
}
    
    
    else if ("editTopic".equals(action)) {

    int topicId =
            Integer.parseInt(
                    request.getParameter(
                            "topicId"));

    Topic topic =
            topicService
            .getTopicById(
                    topicId);

    request.setAttribute(
            "topic",
            topic);

    request.getRequestDispatcher(
            "admin/edit-topic.jsp")
            .forward(
                    request,
                    response);
}
    
    else if ("updateTopic".equals(action)) {

    Topic topic =
            new Topic();

    topic.setTopicId(
            Integer.parseInt(
                    request.getParameter(
                            "topicId")));

    topic.setTopicName(
            request.getParameter(
                    "topicName"));

    topic.setTopicContent(
            request.getParameter(
                    "topicContent"));

    topic.setTopicOrder(
            Integer.parseInt(
                    request.getParameter(
                            "topicOrder")));

    topicService
            .updateTopic(
                    topic);

    response.sendRedirect(
            request.getContextPath()
            + "/AdminServlet?action=viewSkills");
}
    
    else if ("deleteTopic".equals(action)) {

    int topicId =
            Integer.parseInt(
                    request.getParameter(
                            "topicId"));

    topicService
            .deleteTopic(
                    topicId);

    response.sendRedirect(
            request.getContextPath()
            + "/AdminServlet?action=viewSkills");
}
    
    else if ("addTopic".equals(action)) {

    Topic topic =
            new Topic();

    topic.setSkillId(
            Integer.parseInt(
                    request.getParameter(
                            "skillId")));

    topic.setTopicName(
            request.getParameter(
                    "topicName"));

    topic.setTopicContent(
            request.getParameter(
                    "topicContent"));

    topic.setTopicOrder(
            Integer.parseInt(
                    request.getParameter(
                            "topicOrder")));

    topicService
            .addTopic(
                    topic);

    response.sendRedirect(
            request.getContextPath()
            + "/AdminServlet?action=viewSkills");
}
    
    
    else if ("addSkill".equals(action)) {

    Skill skill =
            new Skill();

    skill.setSkillName(
            request.getParameter(
                    "skillName"));

    skill.setCategory(
            request.getParameter(
                    "category"));

    skill.setDescription(
            request.getParameter(
                    "description"));

    skillService
            .addSkill(skill);

    response.sendRedirect(
            request.getContextPath()
            + "/AdminServlet?action=viewSkills");
}
    
    else if ("addResource".equals(action)) {

    Resource resource =
            new Resource();

    resource.setSkillId(
            Integer.parseInt(
            request.getParameter(
            "skillId")));
    
    resource.setPercentageRange(
        request.getParameter(
                "percentageRange"));

    resource.setResourceType(
            request.getParameter(
            "resourceType"));

    resource.setTitle(
            request.getParameter(
            "title"));

    resource.setLink(
            request.getParameter(
            "link"));

    resource.setDescription(
            request.getParameter(
            "description"));

    resourceService
            .addResource(
                    resource);

    response.sendRedirect(
            request.getContextPath()
            + "/AdminServlet?action=viewSkills");
}
    
    else if ("addRecommendation".equals(action)) {

    Recommendation recommendation =
            new Recommendation();

    recommendation.setSkillId(
            Integer.parseInt(
                    request.getParameter(
                            "skillId")));

    recommendation.setPercentageRange(
            request.getParameter(
                    "percentageRange"));

    recommendation.setSuggestionText(
            request.getParameter(
                    "suggestionText"));

    recommendation.setNextTopics(
            request.getParameter(
                    "nextTopics"));

    recommendation.setCareerRoles(
            request.getParameter(
                    "careerRoles"));

    recommendationService
            .addRecommendation(
                    recommendation);

    response.sendRedirect(
            request.getContextPath()
            + "/AdminServlet?action=viewSkills");
}
    
    
    else if ("updateSkill".equals(action)) {

    Skill skill =
            new Skill();

    skill.setSkillId(
            Integer.parseInt(
            request.getParameter(
            "skillId")));

    skill.setSkillName(
            request.getParameter(
            "skillName"));

    skill.setCategory(
            request.getParameter(
            "category"));

    skill.setDescription(
            request.getParameter(
            "description"));

    skillService
            .updateSkill(skill);

    response.sendRedirect(
            request.getContextPath()
            + "/AdminServlet?action=viewSkills");
}
    
    
    else if ("deleteQuestion".equals(action)) {

    int questionId =
            Integer.parseInt(
                    request.getParameter(
                            "questionId"));

    questionService
            .deleteQuestion(
                    questionId);

    response.sendRedirect(
            request.getContextPath()
            + "/AdminServlet?action=viewQuestions");

}
    
    else if ("editQuestion".equals(action)) {

    int questionId =
            Integer.parseInt(
                    request.getParameter(
                            "questionId"));

    Question question =
            questionService
                    .getQuestionById(
                            questionId);

    request.setAttribute(
            "question",
            question);

    request.getRequestDispatcher(
            "admin/edit-question.jsp")
            .forward(
                    request,
                    response);

}

    else if ("updateQuestion".equals(action)) {

    Question question =
            new Question();

    question.setQuestionId(
            Integer.parseInt(
                    request.getParameter(
                            "question_id")));

    question.setSkillId(
            Integer.parseInt(
                    request.getParameter(
                            "skill_id")));

    question.setQuestionText(
            request.getParameter(
                    "question_text"));

    question.setOptionA(
            request.getParameter(
                    "option_a"));

    question.setOptionB(
            request.getParameter(
                    "option_b"));

    question.setOptionC(
            request.getParameter(
                    "option_c"));

    question.setOptionD(
            request.getParameter(
                    "option_d"));

    question.setCorrectAnswer(
            request.getParameter(
                    "correct_answer"));

    question.setTopic(
            request.getParameter(
                    "topic"));

    question.setDifficultyLevel(
            request.getParameter(
                    "difficulty_level"));

    questionService
            .updateQuestion(
                    question);

    response.sendRedirect(
            request.getContextPath()
            + "/AdminServlet?action=viewQuestions");

}
    
    else if ("viewResults".equals(action)) {
        
    List<Result> resultList =
            resultService
                    .getAllResults();

    request.setAttribute(
            "resultList",
            resultList);

    request.getRequestDispatcher(
            "admin/manage-results.jsp")
            .forward(
                    request,
                    response);

}
    
    else if ("viewCertificates".equals(action)) {

    List<Certificate> certificateList =
            certificateService
            .getAllCertificates();

    request.setAttribute(
            "certificateList",
            certificateList);

    request.getRequestDispatcher(
            "admin/manage-certificates.jsp")
            .forward(
                    request,
                    response);
}
    
    else if("viewCertificate".equals(action)) {

    String certificateCode =
            request.getParameter(
                    "code");

    CertificateVerification certificate =
            certificateService
            .getCertificateByCode(
                    certificateCode);

    request.setAttribute(
            "certificate",
            certificate);

    request.getRequestDispatcher(
            "admin/certificate-preview.jsp")
            .forward(
                    request,
                    response);

    return;
}
    
    
    else if ("deleteCertificate".equals(action)) {

    int certificateId =
            Integer.parseInt(
                    request.getParameter(
                            "certificateId"));

    certificateService
            .deleteCertificate(
                    certificateId);

    response.sendRedirect(
            request.getContextPath()
            + "/AdminServlet?action=viewCertificates");
}
    
    else if ("editSkill".equals(action)) {

    int skillId =
            Integer.parseInt(
            request.getParameter(
            "skillId"));

    Skill skill =
            skillService
            .getSkillById(skillId);

    request.setAttribute(
            "skill",
            skill);

    request.getRequestDispatcher(
            "/admin/edit-skill.jsp")
            .forward(
                    request,
                    response);
}
    
    else if ("deleteSkill".equals(action)) {

    int skillId =
            Integer.parseInt(
            request.getParameter(
            "skillId"));

    request.getSession()
      .setAttribute(
            "successMessage",
            "Skill Deleted Successfully.");

skillService.deleteSkill(skillId);

response.sendRedirect(
        request.getContextPath()
        + "/AdminServlet?action=viewSkills");
}
    
   else {

    request.setAttribute(
            "totalStudents",
            authService
            .getAllStudents()
            .size());

    request.setAttribute(
            "totalSkills",
            skillService
            .getAllSkills()
            .size());

    request.setAttribute(
            "totalTests",
            resultService
            .getAllResults()
            .size());

    request.setAttribute(
            "totalCertificates",
            certificateService
            .getAllCertificates()
            .size());

    request.getRequestDispatcher(
            "admin/admin-dashboard.jsp")
            .forward(
                    request,
                    response);

}
    
   
}

@Override
protected void doGet(
        HttpServletRequest request,
        HttpServletResponse response)
        throws ServletException, IOException {

    processRequest(
            request,
            response);

}

@Override
protected void doPost(
        HttpServletRequest request,
        HttpServletResponse response)
        throws ServletException, IOException {

    processRequest(
            request,
            response);

}

}
