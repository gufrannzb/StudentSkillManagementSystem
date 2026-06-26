package com.skillmanager.dao;

import com.skillmanager.model.User;
import com.skillmanager.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.mindrot.jbcrypt.BCrypt;

public class UserDAO {

    Connection con;

    // REGISTER USER
    public boolean registerUser(User user) {
        boolean status = false;
        try {
            con = DBConnection.getConnection();
            String query = "INSERT INTO users(name,email,password,role,college_id,department,mobile,dob,gender,profile_image) VALUES(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            
//            ps.setString(3, user.getPassword());
            String hashedPassword =
                    BCrypt.hashpw(
                        user.getPassword(),
                        BCrypt.gensalt());

            ps.setString(
                3,
                hashedPassword);
            
            ps.setString(4, "student");
            ps.setString(5, user.getCollegeId());
            ps.setString(6, user.getDepartment());
            ps.setString(7, user.getMobile());
            ps.setDate(8, user.getDob());
            ps.setString(9, user.getGender());
            ps.setString(10, user.getProfileImage());

            int rowCount = ps.executeUpdate();
            if (rowCount > 0) {
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    // LOGIN USER
    public User loginUser(String email, String password) {
        User user = null;
        try {
            con = DBConnection.getConnection();
            
            // String query = "SELECT * FROM users WHERE email=? AND password=?";
            
            String query =
            "SELECT * FROM users "
            + "WHERE email=?";
            
            PreparedStatement ps = con.prepareStatement(query);
            
            
            // ps.setString(1, email);
           //  ps.setString(2, password);
           ps.setString(
              1,
              email);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                
                //  Add new for bCcrpyt pasowrd:
                String dbPassword =
                        rs.getString(
                        "password");

                if(dbPassword.startsWith("$2a$")) {

                    if(!BCrypt.checkpw(
                                password,
                                dbPassword)) {

                        return null;
    }

}
else {

    if(!password.equals(
            dbPassword)) {

        return null;
    }
}
                user = new User();
                user.setUserId(rs.getInt("user_id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));
                user.setCollegeId(rs.getString("college_id"));
                user.setDepartment(rs.getString("department"));
                user.setMobile(rs.getString("mobile"));
                user.setDob(rs.getDate("dob"));
                user.setGender(rs.getString("gender"));
                user.setProfileImage(rs.getString("profile_image"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
    
    // GET ALL STUDENTS
    public java.util.List<User> getAllStudents() {
        java.util.List<User> studentList = new java.util.ArrayList<>();
        try {
            con = DBConnection.getConnection();
            String query = "SELECT * FROM users WHERE role='student'";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                User user = new User();
                user.setUserId(rs.getInt("user_id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setRole(rs.getString("role"));
                user.setCollegeId(rs.getString("college_id"));
                user.setDepartment(rs.getString("department"));
                user.setMobile(rs.getString("mobile"));
                user.setDob(rs.getDate("dob"));
                user.setGender(rs.getString("gender"));
                user.setProfileImage(rs.getString("profile_image"));
                studentList.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentList;
    }
    
    
    public User getStudentById(
        int userId) {

    User user = null;

    try {

        con = DBConnection.getConnection();

        String query =
        "SELECT * FROM users "
        + "WHERE user_id=?";

        PreparedStatement ps =
                con.prepareStatement(
                        query);

        ps.setInt(
                1,
                userId);

        ResultSet rs =
                ps.executeQuery();

        if(rs.next()) {

            user = new User();

            user.setUserId(
                    rs.getInt(
                            "user_id"));

            user.setName(
                    rs.getString(
                            "name"));

            user.setEmail(
                    rs.getString(
                            "email"));

            user.setRole(
                    rs.getString(
                            "role"));

            user.setCollegeId(
                    rs.getString(
                            "college_id"));

            user.setDepartment(
                    rs.getString(
                            "department"));

            user.setMobile(
                    rs.getString(
                            "mobile"));

            user.setDob(
                    rs.getDate(
                            "dob"));

            user.setGender(
                    rs.getString(
                            "gender"));

            user.setProfileImage(
                    rs.getString(
                            "profile_image"));
        }

    } catch(Exception e) {

        e.printStackTrace();
    }

    return user;
}
    

    // DELETE STUDENT
    public boolean deleteStudent(int userId) {

    try {

        con = DBConnection.getConnection();

        PreparedStatement ps1 =
        con.prepareStatement(
        "DELETE FROM topic_progress "
        + "WHERE user_id=?");

        ps1.setInt(1, userId);

        ps1.executeUpdate();

        PreparedStatement ps2 =
        con.prepareStatement(
        "DELETE FROM certificates "
        + "WHERE user_id=?");

        ps2.setInt(1, userId);

        ps2.executeUpdate();

        PreparedStatement ps3 =
        con.prepareStatement(
        "DELETE FROM test_results "
        + "WHERE user_id=?");

        ps3.setInt(1, userId);

        ps3.executeUpdate();

        PreparedStatement ps4 =
        con.prepareStatement(
        "DELETE FROM users "
        + "WHERE user_id=?");

        ps4.setInt(1, userId);

        return ps4.executeUpdate() > 0;

    } catch(Exception e) {

        e.printStackTrace();
    }

    return false;
}

    // CHECK EMAIL EXISTS
    public boolean emailExists(String email) {
        boolean status = false;
        try {
            con = DBConnection.getConnection();
            String query = "SELECT * FROM users WHERE email=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    // UPDATE PROFILE
    public boolean updateProfile(User user) {
        boolean status = false;
        try {
            con = DBConnection.getConnection();
            String query = "UPDATE users SET name=?, mobile=?, gender=?, profile_image=? WHERE user_id=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, user.getName());
            ps.setString(2, user.getMobile());
            ps.setString(3, user.getGender());
            ps.setString(4, user.getProfileImage());
            ps.setInt(5, user.getUserId());

            int rows = ps.executeUpdate();
            if(rows > 0) {
                status = true;
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    // SAVE PROFILE HISTORY
    public void saveProfileHistory(int userId, String fieldName, String oldValue, String newValue) {
        try {
            con = DBConnection.getConnection();
            String query = "INSERT INTO profile_update_history (user_id, field_name, old_value, new_value) VALUES(?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, userId);
            ps.setString(2, fieldName);
            ps.setString(3, oldValue);
            ps.setString(4, newValue);
            ps.executeUpdate();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    // GET USER BY EMAIL (for forgot password)
    public User getUserByEmail(String email) {
        User user = null;
        try {
            con = DBConnection.getConnection();
            String query = "SELECT * FROM users WHERE email=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setUserId(rs.getInt("user_id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setRole(rs.getString("role"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    // UPDATE PASSWORD
    public boolean updatePassword(int userId, String newPassword) {
        boolean status = false;
        try {
            con = DBConnection.getConnection();
            String query = "UPDATE users SET password=?, failed_attempts=0, account_locked=0, lock_time=NULL WHERE user_id=?";
            PreparedStatement ps = con.prepareStatement(query);
            
            
            //ps.setString(1, newPassword);
            String hashedPassword =
                    BCrypt.hashpw(
                        newPassword,
                        BCrypt.gensalt());

            ps.setString(
                   1,
                   hashedPassword);
            
            
            ps.setInt(2, userId);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    // ---------- LOGIN LOCKING METHODS ----------

    public void incrementFailedAttempts(String email) {
        try {
            con = DBConnection.getConnection();
            String query = "UPDATE users SET failed_attempts = failed_attempts + 1 WHERE email=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, email);
            ps.executeUpdate();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void resetFailedAttempts(String email) {
        try {
            con = DBConnection.getConnection();
            String query = "UPDATE users SET failed_attempts=0 WHERE email=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, email);
            ps.executeUpdate();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void lockAccount(String email) {
        try {
            con = DBConnection.getConnection();
            String query = "UPDATE users SET account_locked=1, lock_time=NOW() WHERE email=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, email);
            ps.executeUpdate();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isAccountLocked(String email) {
        boolean locked = false;
        try {
            con = DBConnection.getConnection();
            String query = "SELECT account_locked, lock_time FROM users WHERE email=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                boolean accountLocked = rs.getBoolean("account_locked");
                java.sql.Timestamp lockTime = rs.getTimestamp("lock_time");

                if(accountLocked && lockTime != null) {
                    long diff = System.currentTimeMillis() - lockTime.getTime();

                    // 1800000 ms = 30 minutes
                    if(diff >= 1800000) {
                        String unlockQuery = "UPDATE users SET account_locked=0, failed_attempts=0, lock_time=NULL WHERE email=?";
                        PreparedStatement unlockPs = con.prepareStatement(unlockQuery);
                        unlockPs.setString(1, email);
                        unlockPs.executeUpdate();
                        locked = false;
                    } else {
                        locked = true;
                    }
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return locked;
    }

    public int getFailedAttempts(String email) {
        int attempts = 0;
        try {
            con = DBConnection.getConnection();
            String query = "SELECT failed_attempts FROM users WHERE email=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                attempts = rs.getInt("failed_attempts");
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return attempts;
    }
}