package com.skillmanager.dao;

import com.skillmanager.model.Result;
import com.skillmanager.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

public class ResultDAO {

    Connection con;

    // SAVE RESULT

    public boolean saveResult(Result result) {

    boolean status = false;

    try {

        con = DBConnection.getConnection();

        boolean certificateIssued = false;

        java.sql.Timestamp nextAttemptDate = null;

        if (result.getPercentage() >= 80) {

            certificateIssued = true;

            long tenDays =
                    10L * 24 * 60 * 60 * 1000;

            nextAttemptDate =
                    new java.sql.Timestamp(
                            System.currentTimeMillis()
                            + tenDays);

        }

        String query =
        "INSERT INTO test_results "
        + "(user_id, skill_id, percentage, "
        + "skill_level, certificate_issued, "
        + "next_attempt_date) "
        + "VALUES (?, ?, ?, ?, ?, ?)";

        PreparedStatement ps =
                con.prepareStatement(query);

        ps.setInt(
                1,
                result.getUserId());

        ps.setInt(
                2,
                result.getSkillId());

        ps.setDouble(
                3,
                result.getPercentage());

        ps.setString(
                4,
                result.getSkillLevel());

        ps.setBoolean(
                5,
                certificateIssued);

        ps.setTimestamp(
                6,
                nextAttemptDate);

        int rows =
                ps.executeUpdate();

        if (rows > 0) {

            status = true;

        }

    } catch (Exception e) {

        e.printStackTrace();

    }

    return status;

}

    // GET RESULTS BY USER ID

    public List<Result> getResultsByUserId(int userId) {

        List<Result> resultList =
                new ArrayList<>();

        try {

            con = DBConnection.getConnection();

            String query =
            "SELECT tr.*, s.skill_name "
            + "FROM test_results tr "
            + "INNER JOIN skills s "
            + "ON tr.skill_id = s.skill_id "
            + "INNER JOIN ( "
            + "SELECT skill_id, "
            + "MAX(percentage) AS best_score "
            + "FROM test_results "
            + "WHERE user_id=? "
            + "GROUP BY skill_id "
            + ") best "
            + "ON tr.skill_id = best.skill_id "
            + "AND tr.percentage = best.best_score "
            + "WHERE tr.user_id=? "
            + "ORDER BY tr.percentage DESC";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setInt(1, userId);
            ps.setInt(2, userId);

            ResultSet rs =
                    ps.executeQuery();

            while (rs.next()) {

                Result result =
                        new Result();

                result.setResultId(
                        rs.getInt("result_id"));
                
                result.setSkillName(
                        rs.getString("skill_name"));

                result.setUserId(
                        rs.getInt("user_id"));

                result.setSkillId(
                        rs.getInt("skill_id"));

                result.setPercentage(
                        rs.getDouble("percentage"));

                result.setSkillLevel(
                        rs.getString("skill_level"));

                result.setTestDate(
                        rs.getTimestamp("test_date"));

                resultList.add(result);

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

        return resultList;

    }
    
    // GET ALL RESULTS

public List<Result> getAllResults() {

    List<Result> resultList =
            new ArrayList<>();

    try {

        con = DBConnection.getConnection();

        String query =
        "SELECT tr.*, "
        + "u.name, "
        + "s.skill_name "
        + "FROM test_results tr "
        + "INNER JOIN users u "
        + "ON tr.user_id = u.user_id "
        + "INNER JOIN skills s "
        + "ON tr.skill_id = s.skill_id "
        + "WHERE u.role='student' "
        + "ORDER BY tr.test_date DESC";

        PreparedStatement ps =
                con.prepareStatement(query);

        ResultSet rs =
                ps.executeQuery();

        while (rs.next()) {

            Result result =
                    new Result();

            result.setResultId(
                    rs.getInt("result_id"));

            result.setUserId(
                    rs.getInt("user_id"));

            result.setSkillId(
                    rs.getInt("skill_id"));

            result.setPercentage(
                    rs.getDouble("percentage"));

            result.setSkillLevel(
                    rs.getString("skill_level"));

            result.setTestDate(
                    rs.getTimestamp("test_date"));

            result.setSkillName(
                    rs.getString("skill_name"));

            result.setUserName(
                    rs.getString("name"));

            resultList.add(result);

        }

    } catch (Exception e) {

        e.printStackTrace();

    }

    return resultList;

}

// GET BEST RESULT

public Result getBestResult(
        int userId,
        int skillId) {

    Result result = null;

    try {

        con = DBConnection.getConnection();

        String query =
                "SELECT tr.*, s.skill_name "
                + "FROM test_results tr "
                + "INNER JOIN skills s "
                + "ON tr.skill_id = s.skill_id "
                + "WHERE tr.user_id=? "
                + "AND tr.skill_id=? "
                + "ORDER BY tr.percentage DESC "
                + "LIMIT 1";

        PreparedStatement ps =
                con.prepareStatement(query);

        ps.setInt(1, userId);
        ps.setInt(2, skillId);

        ResultSet rs =
                ps.executeQuery();

        if (rs.next()) {

            result = new Result();

            result.setResultId(
                    rs.getInt("result_id"));

            result.setUserId(
                    rs.getInt("user_id"));

            result.setSkillId(
                    rs.getInt("skill_id"));

            result.setPercentage(
                    rs.getDouble("percentage"));

            result.setSkillLevel(
                    rs.getString("skill_level"));

            result.setTestDate(
                    rs.getTimestamp("test_date"));

            result.setSkillName(
                    rs.getString("skill_name"));
        }

    } catch (Exception e) {

        e.printStackTrace();

    }

    return result;
}

// CHECK COOLDOWN

public boolean canAttemptTest(
        int userId,
        int skillId) {

    try {

        con = DBConnection.getConnection();

        String query =
                "SELECT next_attempt_date "
                + "FROM test_results "
                + "WHERE user_id=? "
                + "AND skill_id=? "
                + "AND certificate_issued=true "
                + "ORDER BY percentage DESC "
                + "LIMIT 1";

        PreparedStatement ps =
                con.prepareStatement(query);

        ps.setInt(1, userId);
        ps.setInt(2, skillId);

        ResultSet rs =
                ps.executeQuery();

        if (rs.next()) {

            java.sql.Timestamp nextDate =
                    rs.getTimestamp(
                            "next_attempt_date");

            if (nextDate != null
                    && new java.util.Date()
                            .before(nextDate)) {

                return false;

            }

        }

    } catch (Exception e) {

        e.printStackTrace();

    }

    return true;

}

// GET BEST RESULT BY USER

public Result getBestResultByUser(
        int userId) {

    Result result = null;

    try {

        con = DBConnection.getConnection();

        String query =
        "SELECT * "
        + "FROM test_results "
        + "WHERE user_id=? "
        + "ORDER BY percentage DESC "
        + "LIMIT 1";

        PreparedStatement ps =
                con.prepareStatement(query);

        ps.setInt(1, userId);

        ResultSet rs =
                ps.executeQuery();

        if (rs.next()) {

            result = new Result();

            result.setResultId(
                   rs.getInt("result_id"));

            result.setSkillId(
                   rs.getInt("skill_id"));

            result.setPercentage(
                   rs.getDouble("percentage"));

            result.setSkillLevel(
                   rs.getString("skill_level"));

            result.setTestDate(
                   rs.getTimestamp("test_date"));

}
    } catch (Exception e) {

        e.printStackTrace();

    }

    return result;

}

// GET ATTEMPTS BY SKILL

public List<Result> getAttemptsBySkill(
        int userId,
        int skillId) {

    List<Result> attempts =
            new ArrayList<>();

    try {

        con = DBConnection.getConnection();

        String query =
                "SELECT * "
                + "FROM test_results "
                + "WHERE user_id=? "
                + "AND skill_id=? "
                + "ORDER BY test_date ASC";

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

        while (rs.next()) {

            Result result =
                    new Result();

            result.setResultId(
                    rs.getInt(
                            "result_id"));

            result.setUserId(
                    rs.getInt(
                            "user_id"));

            result.setSkillId(
                    rs.getInt(
                            "skill_id"));

            result.setPercentage(
                    rs.getDouble(
                            "percentage"));

            result.setSkillLevel(
                    rs.getString(
                            "skill_level"));

            result.setTestDate(
                    rs.getTimestamp(
                            "test_date"));

            attempts.add(
                    result);
        }

    } catch (Exception e) {

        e.printStackTrace();

    }

    return attempts;
}
    

}