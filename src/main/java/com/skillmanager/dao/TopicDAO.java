package com.skillmanager.dao;

import com.skillmanager.model.Topic;
import com.skillmanager.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.List;
import java.util.ArrayList;

public class TopicDAO {

    Connection con;

    public Topic getTopicById(
            int topicId) {

        Topic topic = null;

        try {

            con = DBConnection
                    .getConnection();

            String query =
                    "SELECT * "
                    + "FROM course_topics "
                    + "WHERE topic_id = ?";

            PreparedStatement ps =
                    con.prepareStatement(
                            query);

            ps.setInt(
                    1,
                    topicId);

            ResultSet rs =
                    ps.executeQuery();

            if(rs.next()) {

                topic = new Topic();

                topic.setTopicId(
                        rs.getInt(
                                "topic_id"));

                topic.setSkillId(
                        rs.getInt(
                                "skill_id"));

                topic.setTopicName(
                        rs.getString(
                                "topic_name"));

                topic.setTopicContent(
                        rs.getString(
                                "topic_content"));

                topic.setTopicOrder(
                        rs.getInt(
                                "topic_order"));
            }

        } catch(Exception e) {

            e.printStackTrace();

        }

        return topic;
    }
    
    public List<Topic> getTopicsBySkillId(
        int skillId) {

    List<Topic> topicList =
            new ArrayList<>();

    try {

        con = DBConnection
                .getConnection();

        String query =
                "SELECT * "
                + "FROM course_topics "
                + "WHERE skill_id = ? "
                + "ORDER BY topic_order";

        PreparedStatement ps =
                con.prepareStatement(
                        query);

        ps.setInt(
                1,
                skillId);

        ResultSet rs =
                ps.executeQuery();

        while(rs.next()) {

            Topic topic =
                    new Topic();

            topic.setTopicId(
                    rs.getInt(
                            "topic_id"));

            topic.setSkillId(
                    rs.getInt(
                            "skill_id"));

            topic.setTopicName(
                    rs.getString(
                            "topic_name"));

            topic.setTopicContent(
                    rs.getString(
                            "topic_content"));

            topic.setTopicOrder(
                    rs.getInt(
                            "topic_order"));

            topicList.add(
                    topic);
        }

    } catch(Exception e) {

        e.printStackTrace();

    }

    return topicList;
}
    
    public Topic getTopicByOrder(
        int skillId,
        int topicOrder) {

    Topic topic = null;

    try {

        con = DBConnection
                .getConnection();

        String query =
                "SELECT * "
                + "FROM course_topics "
                + "WHERE skill_id = ? "
                + "AND topic_order = ?";

        PreparedStatement ps =
                con.prepareStatement(
                        query);

        ps.setInt(
                1,
                skillId);

        ps.setInt(
                2,
                topicOrder);

        ResultSet rs =
                ps.executeQuery();

        if(rs.next()) {

            topic = new Topic();

            topic.setTopicId(
                    rs.getInt(
                            "topic_id"));

            topic.setSkillId(
                    rs.getInt(
                            "skill_id"));

            topic.setTopicName(
                    rs.getString(
                            "topic_name"));

            topic.setTopicContent(
                    rs.getString(
                            "topic_content"));

            topic.setTopicOrder(
                    rs.getInt(
                            "topic_order"));
        }

    } catch(Exception e) {

        e.printStackTrace();

    }

    return topic;
}
    
    public boolean addTopic(
        Topic topic) {

    try {

        con =
        DBConnection.getConnection();

        String query =
        "INSERT INTO course_topics "
        + "(skill_id,"
        + "topic_name,"
        + "topic_content,"
        + "topic_order) "
        + "VALUES(?,?,?,?)";

        PreparedStatement ps =
        con.prepareStatement(query);

        ps.setInt(
                1,
                topic.getSkillId());

        ps.setString(
                2,
                topic.getTopicName());

        ps.setString(
                3,
                topic.getTopicContent());

        ps.setInt(
                4,
                topic.getTopicOrder());

        return ps.executeUpdate()
                > 0;

    }

    catch(Exception e) {

        e.printStackTrace();

    }

    return false;
}
    
    public void updateTopic(
        Topic topic) {

    try {

        con =
        DBConnection.getConnection();

        String query =
        "UPDATE course_topics "
        + "SET topic_name=?, "
        + "topic_content=?, "
        + "topic_order=? "
        + "WHERE topic_id=?";

        PreparedStatement ps =
        con.prepareStatement(query);

        ps.setString(
                1,
                topic.getTopicName());

        ps.setString(
                2,
                topic.getTopicContent());

        ps.setInt(
                3,
                topic.getTopicOrder());

        ps.setInt(
                4,
                topic.getTopicId());

        ps.executeUpdate();

    }

    catch(Exception e) {

        e.printStackTrace();

    }
}
    
    public void deleteTopic(
        int topicId) {

    try {

        con =
        DBConnection.getConnection();

        String query =
        "DELETE FROM course_topics "
        + "WHERE topic_id=?";

        PreparedStatement ps =
        con.prepareStatement(
                query);

        ps.setInt(
                1,
                topicId);

        ps.executeUpdate();

    }

    catch(Exception e) {

        e.printStackTrace();

    }
}
}