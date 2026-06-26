package com.skillmanager.controller;

import com.skillmanager.model.User;
import com.skillmanager.service.UserService;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@MultipartConfig(
        maxFileSize = 10 * 1024 * 1024
)
public class UpdateProfileServlet
        extends HttpServlet {

    UserService userService =
            new UserService();

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException,
            IOException {

        try {

            HttpSession session =
                    request.getSession();

            User loggedInUser =
                    (User) session.getAttribute(
                            "user");

            String name =
                    request.getParameter(
                            "name");

            String mobile =
                    request.getParameter(
                            "mobile");

            String gender =
                    request.getParameter(
                            "gender");

            Part imagePart =
                    request.getPart(
                            "profileImage");

            User user =
                    new User();

            user.setUserId(
                    loggedInUser.getUserId());

            user.setName(
                    name);

            user.setMobile(
                    mobile);

            user.setGender(
                    gender);

            user.setProfileImage(
                    loggedInUser.getProfileImage());

            String imagePath = null;

            if (imagePart != null
                    && imagePart.getSize() > 0) {

                String fileName =
                        "user_"
                        + loggedInUser.getUserId()
                        + "_"
                        + imagePart.getSubmittedFileName();

                String uploadPath =
                        getServletContext()
                        .getRealPath(
                                "/assets/images/profile");

                File uploadDir =
                        new File(uploadPath);

                if (!uploadDir.exists()) {

                    uploadDir.mkdirs();
                }

                imagePart.write(
                        uploadPath
                        + File.separator
                        + fileName);

                imagePath =
                        request.getContextPath()
                        + "/assets/images/profile/"
                        + fileName;

                user.setProfileImage(
                        imagePath);
            }

            // SAVE HISTORY

            if (loggedInUser.getName() == null
                    || !loggedInUser
                            .getName()
                            .equals(name)) {

                userService
                        .saveProfileHistory(
                                loggedInUser.getUserId(),
                                "Name",
                                loggedInUser.getName(),
                                name);
            }

            if (loggedInUser.getMobile() == null
                    || !loggedInUser
                            .getMobile()
                            .equals(mobile)) {

                userService
                        .saveProfileHistory(
                                loggedInUser.getUserId(),
                                "Mobile",
                                loggedInUser.getMobile(),
                                mobile);
            }

            if (gender != null
                    && !gender.trim().isEmpty()) {

                if (loggedInUser.getGender() == null
                        || !loggedInUser
                                .getGender()
                                .equals(gender)) {

                    userService
                            .saveProfileHistory(
                                    loggedInUser.getUserId(),
                                    "Gender",
                                    loggedInUser.getGender(),
                                    gender);
                }
            }

            boolean status =
                    userService
                            .updateProfile(
                                    user);

            if (status) {

                loggedInUser.setName(
                        name);

                loggedInUser.setMobile(
                        mobile);

                loggedInUser.setGender(
                        gender);

                if (imagePath != null) {

                    loggedInUser.setProfileImage(
                            imagePath);
                }

                session.setAttribute(
                        "user",
                        loggedInUser);

                response.sendRedirect(
                        request.getContextPath()
                        + "/student/profile.jsp");

            } else {

                response.getWriter().println(
                        "Profile Update Failed");
            }

        } catch (Exception e) {

            String msg = e.getMessage();

            if (msg != null
                    && msg.toLowerCase()
                            .contains("size")) {

                request.setAttribute(
                        "errorMessage",
                        "Profile image size must be less than 3 MB.");

            } else {

                request.setAttribute(
                        "errorMessage",
                        "Something went wrong. Please try again.");
            }

            request.getRequestDispatcher(
                    "/student/edit-profile.jsp")
                    .forward(
                            request,
                            response);
        }
    }
}