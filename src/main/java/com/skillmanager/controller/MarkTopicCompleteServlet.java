package com.skillmanager.controller;

import com.skillmanager.model.User;
import com.skillmanager.service.ProgressService;

import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author mohdgufran
 */
public class MarkTopicCompleteServlet extends HttpServlet {

    ProgressService progressService =
        new ProgressService();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session =
        request.getSession();

User user =
        (User) session.getAttribute(
                "user");

if(user == null) {

    response.sendRedirect(
            request.getContextPath()
            + "/student/login.jsp");

    return;
}

int topicId =
        Integer.parseInt(
                request.getParameter(
                        "topicId"));

progressService
        .markCompleted(
                user.getUserId(),
                topicId);

response.sendRedirect(
        request.getContextPath()
        + "/TopicServlet?topicId="
        + topicId);
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
