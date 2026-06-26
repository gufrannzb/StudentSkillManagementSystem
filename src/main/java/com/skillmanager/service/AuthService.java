package com.skillmanager.service;

import com.skillmanager.dao.UserDAO;
import com.skillmanager.model.User;

public class AuthService {

    UserDAO userDAO = new UserDAO();

    public boolean registerUser(User user) {

        return userDAO.registerUser(user);

    }

    public User loginUser(String email, String password) {

        return userDAO.loginUser(email, password);

    }
    
    // GET ALL STUDENTS

public java.util.List<User>
        getAllStudents() {

    return userDAO
            .getAllStudents();

}
        
        // DELETE STUDENT

public boolean deleteStudent(
        int userId) {

    return userDAO
            .deleteStudent(
                    userId);

}

public User getStudentById(
        int userId) {

    return userDAO
            .getStudentById(
                    userId);
}



public boolean emailExists(
        String email) {

    return userDAO
            .emailExists(
                    email);

}

// GET USER BY EMAIL
public User getUserByEmail(String email) {
    return userDAO.getUserByEmail(email);
}

// UPDATE PASSWORD
public boolean updatePassword(
        int userId, String newPassword) {
    return userDAO.updatePassword(
            userId, newPassword);
}

// Login attempts and after 5 attemts account locked autoamtically

public void incrementFailedAttempts(
        String email) {

    userDAO.incrementFailedAttempts(
            email);
}

public void resetFailedAttempts(
        String email) {

    userDAO.resetFailedAttempts(
            email);
}

public void lockAccount(
        String email) {

    userDAO.lockAccount(
            email);
}

public boolean isAccountLocked(
        String email) {

    return userDAO.isAccountLocked(
            email);
}

public int getFailedAttempts(
        String email) {

    return userDAO.getFailedAttempts(
            email);
}

}
