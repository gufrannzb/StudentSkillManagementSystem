package com.skillmanager.dao;

import com.skillmanager.model.Recommendation;
import com.skillmanager.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RecommendationDAO {

    public boolean addRecommendation(
            Recommendation recommendation) {

        try {

            Connection con =
                    DBConnection.getConnection();

            String query =
                    "INSERT INTO recommendations("
                    + "skill_id,"
                    + "percentage_range,"
                    + "suggestion_text,"
                    + "next_topics,"
                    + "career_roles)"
                    + " VALUES(?,?,?,?,?)";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setInt(
                    1,
                    recommendation.getSkillId());

            ps.setString(
                    2,
                    recommendation.getPercentageRange());

            ps.setString(
                    3,
                    recommendation.getSuggestionText());

            ps.setString(
                    4,
                    recommendation.getNextTopics());

            ps.setString(
                    5,
                    recommendation.getCareerRoles());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {

            e.printStackTrace();
        }

        return false;
    }
    
    public List<Recommendation>
getRecommendationsBySkillId(
        int skillId) {

    List<Recommendation> recommendationList =
            new ArrayList<>();

    try {

        Connection con =
                DBConnection.getConnection();

        String query =
                "SELECT * FROM recommendations "
                + "WHERE skill_id=?";

        PreparedStatement ps =
                con.prepareStatement(query);

        ps.setInt(1, skillId);

        ResultSet rs =
                ps.executeQuery();

        while(rs.next()) {

            Recommendation recommendation =
                    new Recommendation();

            recommendation.setRecommendationId(
                    rs.getInt(
                            "recommendation_id"));

            recommendation.setSkillId(
                    rs.getInt(
                            "skill_id"));

            recommendation.setPercentageRange(
                    rs.getString(
                            "percentage_range"));

            recommendation.setSuggestionText(
                    rs.getString(
                            "suggestion_text"));

            recommendation.setNextTopics(
                    rs.getString(
                            "next_topics"));

            recommendation.setCareerRoles(
                    rs.getString(
                            "career_roles"));

            recommendationList.add(
                    recommendation);
        }

    } catch(Exception e) {

        e.printStackTrace();
    }

    return recommendationList;
}

public Recommendation getRecommendationById(
        int recommendationId) {

    Recommendation recommendation = null;

    try {

        Connection con =
                DBConnection.getConnection();

        String query =
                "SELECT * FROM recommendations "
                + "WHERE recommendation_id=?";

        PreparedStatement ps =
                con.prepareStatement(query);

        ps.setInt(1, recommendationId);

        ResultSet rs =
                ps.executeQuery();

        if(rs.next()) {

            recommendation =
                    new Recommendation();

            recommendation.setRecommendationId(
                    rs.getInt(
                            "recommendation_id"));

            recommendation.setSkillId(
                    rs.getInt(
                            "skill_id"));

            recommendation.setPercentageRange(
                    rs.getString(
                            "percentage_range"));

            recommendation.setSuggestionText(
                    rs.getString(
                            "suggestion_text"));

            recommendation.setNextTopics(
                    rs.getString(
                            "next_topics"));

            recommendation.setCareerRoles(
                    rs.getString(
                            "career_roles"));
        }

    } catch(Exception e) {

        e.printStackTrace();
    }

    return recommendation;
}

public boolean deleteRecommendation(
        int recommendationId) {

    try {

        Connection con =
                DBConnection.getConnection();

        String query =
                "DELETE FROM recommendations "
                + "WHERE recommendation_id=?";

        PreparedStatement ps =
                con.prepareStatement(query);

        ps.setInt(
                1,
                recommendationId);

        return ps.executeUpdate() > 0;

    } catch(Exception e) {

        e.printStackTrace();
    }

    return false;
}

public boolean updateRecommendation(
        Recommendation recommendation) {

    try {

        Connection con =
                DBConnection.getConnection();

        String query =
                "UPDATE recommendations SET "
                + "percentage_range=?, "
                + "suggestion_text=?, "
                + "next_topics=?, "
                + "career_roles=? "
                + "WHERE recommendation_id=?";

        PreparedStatement ps =
                con.prepareStatement(query);

        ps.setString(
                1,
                recommendation.getPercentageRange());

        ps.setString(
                2,
                recommendation.getSuggestionText());

        ps.setString(
                3,
                recommendation.getNextTopics());

        ps.setString(
                4,
                recommendation.getCareerRoles());

        ps.setInt(
                5,
                recommendation.getRecommendationId());

        return ps.executeUpdate() > 0;

    } catch(Exception e) {

        e.printStackTrace();
    }

    return false;
}

public Recommendation getRecommendationByRange(
        int skillId,
        String range) {

    Recommendation recommendation = null;

    try {

        Connection con =
                DBConnection.getConnection();

        String query =
                "SELECT * FROM recommendations "
                + "WHERE skill_id=? "
                + "AND percentage_range=?";

        PreparedStatement ps =
                con.prepareStatement(query);

        ps.setInt(1, skillId);
        ps.setString(2, range);

        ResultSet rs =
                ps.executeQuery();

        if(rs.next()) {

            recommendation =
                    new Recommendation();

            recommendation.setRecommendationId(
                    rs.getInt("recommendation_id"));

            recommendation.setSkillId(
                    rs.getInt("skill_id"));

            recommendation.setPercentageRange(
                    rs.getString("percentage_range"));

            recommendation.setSuggestionText(
                    rs.getString("suggestion_text"));

            recommendation.setNextTopics(
                    rs.getString("next_topics"));

            recommendation.setCareerRoles(
                    rs.getString("career_roles"));
        }

    } catch(Exception e) {

        e.printStackTrace();
    }

    return recommendation;
}

}