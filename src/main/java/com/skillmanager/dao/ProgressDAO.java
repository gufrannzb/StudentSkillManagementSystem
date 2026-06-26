package com.skillmanager.dao;

import com.skillmanager.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProgressDAO {

    Connection con;

    public boolean isCompleted(
            int userId,
            int topicId) {

        try {

            con =
                    DBConnection
                    .getConnection();

            String query =
                    "SELECT * "
                    + "FROM topic_progress "
                    + "WHERE user_id = ? "
                    + "AND topic_id = ?";

            PreparedStatement ps =
                    con.prepareStatement(
                            query);

            ps.setInt(
                    1,
                    userId);

            ps.setInt(
                    2,
                    topicId);

            ResultSet rs =
                    ps.executeQuery();

            return rs.next();

        } catch(Exception e) {

            e.printStackTrace();

        }

        return false;
    }

    public void markCompleted(
            int userId,
            int topicId) {

        if(isCompleted(
                userId,
                topicId)) {

            return;
        }

        try {

            con =
                    DBConnection
                    .getConnection();

            String query =
                    "INSERT INTO "
                    + "topic_progress "
                    + "(user_id, topic_id) "
                    + "VALUES (?, ?)";

            PreparedStatement ps =
                    con.prepareStatement(
                            query);

            ps.setInt(
                    1,
                    userId);

            ps.setInt(
                    2,
                    topicId);

            ps.executeUpdate();

        } catch(Exception e) {

            e.printStackTrace();

        }
    }
    
    public int getCompletedTopicsCount(
        int userId,
        int skillId) {

    int count = 0;

    try {

        con =
                DBConnection
                .getConnection();

        String query =
                "SELECT COUNT(*) "
                + "FROM topic_progress tp "
                + "INNER JOIN course_topics ct "
                + "ON tp.topic_id = ct.topic_id "
                + "WHERE tp.user_id = ? "
                + "AND ct.skill_id = ?";

        PreparedStatement ps =
                con.prepareStatement(
                        query);

        ps.setInt(
                1,
                userId);

        ps.setInt(
                2,
                skillId);

        ResultSet rs =
                ps.executeQuery();

        if(rs.next()) {

            count =
                    rs.getInt(1);
        }

    } catch(Exception e) {

        e.printStackTrace();
    }

    return count;
}
    
    public int getTotalTopicsCount(
        int skillId) {

    int count = 0;

    try {

        con =
                DBConnection
                .getConnection();

        String query =
                "SELECT COUNT(*) "
                + "FROM course_topics "
                + "WHERE skill_id = ?";

        PreparedStatement ps =
                con.prepareStatement(
                        query);

        ps.setInt(
                1,
                skillId);

        ResultSet rs =
                ps.executeQuery();

        if(rs.next()) {

            count =
                    rs.getInt(1);
        }

    } catch(Exception e) {

        e.printStackTrace();
    }

    return count;
}
}