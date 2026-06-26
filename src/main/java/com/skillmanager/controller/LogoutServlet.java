package com.skillmanager.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet {

    protected void processRequest(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session =
        request.getSession(false);

boolean isAdmin =
        session != null
        && session.getAttribute("admin") != null;

if(session != null){
    session.invalidate();
}

if(isAdmin){

    response.sendRedirect(
            request.getContextPath()
            + "/admin/admin-login.jsp");

}
else{

    response.sendRedirect(
            request.getContextPath()
            + "/student/login.jsp");

}
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