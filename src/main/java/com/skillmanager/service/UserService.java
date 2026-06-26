package com.skillmanager.service;

import com.skillmanager.dao.UserDAO;
import com.skillmanager.model.User;

public class UserService {

    UserDAO userDAO =
            new UserDAO();

    public boolean updateProfile(
            User user) {

        return userDAO
                .updateProfile(
                        user);
    }
    
    public void saveProfileHistory(
        int userId,
        String fieldName,
        String oldValue,
        String newValue) {

    userDAO
            .saveProfileHistory(
                    userId,
                    fieldName,
                    oldValue,
                    newValue);
}
    
    public int getTotalStudents() {

    return userDAO
            .getAllStudents()
            .size();
}

}