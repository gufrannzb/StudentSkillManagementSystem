package com.skillmanager.controller;

import com.skillmanager.model.Skill;
import com.skillmanager.model.Topic;
import com.skillmanager.model.User;

import com.skillmanager.service.SkillService;
import com.skillmanager.service.TopicService;
import com.skillmanager.service.ProgressService;

import com.skillmanager.model.Resource;
import com.skillmanager.service.ResourceService;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.util.Set;
import java.util.HashSet;

public class CourseDetailsServlet
        extends HttpServlet {

    SkillService skillService =
            new SkillService();

    TopicService topicService =
            new TopicService();

    ProgressService progressService =
            new ProgressService();
    
    ResourceService resourceService =
        new ResourceService();

    protected void processRequest(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException,
            IOException {

        int skillId =
                Integer.parseInt(
                        request.getParameter(
                                "skillId"));

        Skill skill =
                skillService
                        .getSkillById(
                                skillId);
        
        System.out.println(
        "Skill Id = "
        + skillId);

        System.out.println(
        "Skill = "
        + skill);

        List<Topic> topicList =
                topicService
                        .getTopicsBySkillId(
                                skillId);

        int completedCount = 0;

        int totalCount =
                progressService
                        .getTotalTopicsCount(
                                skillId);

        HttpSession session =
                request.getSession(false);

        if(session != null
                && session.getAttribute(
                        "user") != null) {

            User user =
                    (User) session
                            .getAttribute(
                                    "user");

            completedCount =
                    progressService
                            .getCompletedTopicsCount(
                                    user.getUserId(),
                                    skillId);
        }

        int progressPercentage = 0;

        if(totalCount > 0) {

            progressPercentage =
                    (completedCount * 100)
                    / totalCount;
        }
        
        Set<Integer> completedTopics =
        new HashSet<>();

if(session != null
        && session.getAttribute(
                "user") != null) {

    User user =
            (User) session
                    .getAttribute(
                            "user");

    for(Topic topic : topicList) {

        if(progressService
                .isTopicCompleted(
                        user.getUserId(),
                        topic.getTopicId())) {

            completedTopics.add(
                    topic.getTopicId());
        }
    }
}

List<Resource> resourceList =
        resourceService
        .getResourcesBySkillId(
                skillId);

        request.setAttribute(
                "skill",
                skill);

        request.setAttribute(
                "topicList",
                topicList);

        request.setAttribute(
                "completedCount",
                completedCount);

        request.setAttribute(
                "totalCount",
                totalCount);

        request.setAttribute(
                "progressPercentage",
                progressPercentage);
        
        request.setAttribute(
        "completedTopics",
        completedTopics);
        
        request.setAttribute(
        "resourceList",
        resourceList);

        request.getRequestDispatcher(
                "student/course-details.jsp")
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
}