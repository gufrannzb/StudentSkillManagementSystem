package com.skillmanager.controller;

import com.skillmanager.model.Topic;
import com.skillmanager.service.TopicService;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.skillmanager.model.User;
import com.skillmanager.service.ProgressService;


public class TopicServlet
        extends HttpServlet {

    TopicService topicService =
            new TopicService();
    
    ProgressService progressService =
        new ProgressService();

    protected void processRequest(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException,
            IOException {

        int topicId =
                Integer.parseInt(
                        request.getParameter(
                                "topicId"));

        System.out.println(
                "Topic Id = "
                + topicId);

        Topic topic =
                topicService
                        .getTopicById(
                                topicId);

        System.out.println(
                "Topic = "
                + topic);

        if(topic == null) {

            response.getWriter().println(
                    "Topic Not Found");

            return;
        }
        
        boolean completed = false;

if(request.getSession(false) != null
        && request.getSession(false)
                .getAttribute("user") != null) {

    User user =
            (User) request
                    .getSession(false)
                    .getAttribute("user");

    completed =
            progressService
                    .isCompleted(
                            user.getUserId(),
                            topicId);
}

request.setAttribute(
        "completed",
        completed);
        
        Topic previousTopic =
                topicService
                        .getTopicByOrder(
                                topic.getSkillId(),
                                topic.getTopicOrder() - 1);

        Topic nextTopic =
                topicService
                        .getTopicByOrder(
                                topic.getSkillId(),
                                topic.getTopicOrder() + 1);

        request.setAttribute(
                "topic",
                topic);

        request.setAttribute(
                "previousTopic",
                previousTopic);

        request.setAttribute(
                "nextTopic",
                nextTopic);

        request.getRequestDispatcher(
                "student/topic-details.jsp")
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