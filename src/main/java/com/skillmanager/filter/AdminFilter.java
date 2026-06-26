package com.skillmanager.filter;

/**
 *
 * @author mohdgufran
 */

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class AdminFilter
        implements Filter {

    @Override
    public void init(
            FilterConfig filterConfig)
            throws ServletException {

    }

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain)
            throws IOException,
            ServletException {

        HttpServletRequest req =
                (HttpServletRequest) request;

        HttpServletResponse res =
                (HttpServletResponse) response;

        HttpSession session =
                req.getSession(false);

        if (session == null
                || session.getAttribute(
                        "admin") == null) {

            res.sendRedirect(
                    req.getContextPath()
                    + "/admin/admin-login.jsp");

            return;
        }

        chain.doFilter(
                request,
                response);
    }

    @Override
    public void destroy() {

    }

}