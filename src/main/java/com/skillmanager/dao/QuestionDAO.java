package com.skillmanager.dao;

import com.skillmanager.model.Question;
import com.skillmanager.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

public class QuestionDAO {

Connection con;

// GET QUESTIONS BY SKILL ID
public List<Question> getQuestionsBySkillId(int skillId) {

    List<Question> questionList = new ArrayList<>();

    try {

        con = DBConnection.getConnection();

        String query =
        "SELECT question_id, skill_id, question_text, "
        + "option_a, option_b, option_c, option_d, "
        + "correct_answer, topic, difficulty_level "
        + "FROM questions WHERE skill_id=?";

        PreparedStatement ps =
                con.prepareStatement(query);

        ps.setInt(1, skillId);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {

            Question question = new Question();

            question.setQuestionId(rs.getInt("question_id"));
            question.setSkillId(rs.getInt("skill_id"));
            question.setQuestionText(rs.getString("question_text"));
            question.setOptionA(rs.getString("option_a"));
            question.setOptionB(rs.getString("option_b"));
            question.setOptionC(rs.getString("option_c"));
            question.setOptionD(rs.getString("option_d"));
            question.setCorrectAnswer(rs.getString("correct_answer"));
            question.setTopic(rs.getString("topic"));
            question.setDifficultyLevel(
                    rs.getString("difficulty_level"));

            questionList.add(question);

        }

    } catch (Exception e) {

        e.printStackTrace();

    }

    return questionList;

}

// GET QUESTION BY QUESTION ID

public Question getQuestionById(int questionId) {

    Question question = null;

    try {

        con = DBConnection.getConnection();

        String query =
        "SELECT question_id, skill_id, question_text, "
        + "option_a, option_b, option_c, option_d, "
        + "correct_answer, topic, difficulty_level "
        + "FROM questions WHERE question_id=?";

        PreparedStatement ps =
                con.prepareStatement(query);

        ps.setInt(1, questionId);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {

            question = new Question();

            question.setQuestionId(rs.getInt("question_id"));
            question.setSkillId(rs.getInt("skill_id"));
            question.setQuestionText(rs.getString("question_text"));
            question.setOptionA(rs.getString("option_a"));
            question.setOptionB(rs.getString("option_b"));
            question.setOptionC(rs.getString("option_c"));
            question.setOptionD(rs.getString("option_d"));
            question.setCorrectAnswer(rs.getString("correct_answer"));
            question.setTopic(rs.getString("topic"));
            question.setDifficultyLevel(
                    rs.getString("difficulty_level"));

        }

    } catch (Exception e) {

        e.printStackTrace();

    }

    return question;

}

// ADD QUESTION

public boolean addQuestion(Question question) {

    boolean status = false;

    try {

        con = DBConnection.getConnection();

        String query =
        "INSERT INTO questions "
        + "(skill_id, question_text, option_a, option_b, "
        + "option_c, option_d, correct_answer, topic, "
        + "difficulty_level) "
        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement ps =
                con.prepareStatement(query);

        ps.setInt(1, question.getSkillId());
        ps.setString(2, question.getQuestionText());
        ps.setString(3, question.getOptionA());
        ps.setString(4, question.getOptionB());
        ps.setString(5, question.getOptionC());
        ps.setString(6, question.getOptionD());
        ps.setString(7, question.getCorrectAnswer());
        ps.setString(8, question.getTopic());
        ps.setString(9, question.getDifficultyLevel());

        int rows = ps.executeUpdate();

        if (rows > 0) {

            status = true;

        }
        
        

    } catch (Exception e) {

        e.printStackTrace();

    }

    return status;

}

// GET ALL QUESTIONS

public List<Question> getAllQuestions() {

    List<Question> questionList =
            new ArrayList<>();

    try {

        con = DBConnection.getConnection();

        String query =
                "SELECT * FROM questions "
                + "ORDER BY question_id DESC";

        PreparedStatement ps =
                con.prepareStatement(query);

        ResultSet rs =
                ps.executeQuery();

        while (rs.next()) {

            Question question =
                    new Question();

            question.setQuestionId(
                    rs.getInt("question_id"));

            question.setSkillId(
                    rs.getInt("skill_id"));

            question.setQuestionText(
                    rs.getString("question_text"));

            question.setOptionA(
                    rs.getString("option_a"));

            question.setOptionB(
                    rs.getString("option_b"));

            question.setOptionC(
                    rs.getString("option_c"));

            question.setOptionD(
                    rs.getString("option_d"));

            question.setCorrectAnswer(
                    rs.getString("correct_answer"));

            question.setTopic(
                    rs.getString("topic"));

            question.setDifficultyLevel(
                    rs.getString("difficulty_level"));

            questionList.add(question);

        }

    } catch (Exception e) {

        e.printStackTrace();

    }

    return questionList;

}

// DELETE QUESTION

public boolean deleteQuestion(
        int questionId) {

    boolean status = false;

    try {

        con = DBConnection.getConnection();

        String query =
                "DELETE FROM questions "
                + "WHERE question_id=?";

        PreparedStatement ps =
                con.prepareStatement(query);

        ps.setInt(1, questionId);

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

// UPDATE QUESTION

public boolean updateQuestion(
        Question question) {

    boolean status = false;

    try {

        con = DBConnection.getConnection();

        String query =
                "UPDATE questions SET "
                + "skill_id=?, "
                + "question_text=?, "
                + "option_a=?, "
                + "option_b=?, "
                + "option_c=?, "
                + "option_d=?, "
                + "correct_answer=?, "
                + "topic=?, "
                + "difficulty_level=? "
                + "WHERE question_id=?";

        PreparedStatement ps =
                con.prepareStatement(query);

        ps.setInt(1,
                question.getSkillId());

        ps.setString(2,
                question.getQuestionText());

        ps.setString(3,
                question.getOptionA());

        ps.setString(4,
                question.getOptionB());

        ps.setString(5,
                question.getOptionC());

        ps.setString(6,
                question.getOptionD());

        ps.setString(7,
                question.getCorrectAnswer());

        ps.setString(8,
                question.getTopic());

        ps.setString(9,
                question.getDifficultyLevel());

        ps.setInt(10,
                question.getQuestionId());

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

}
