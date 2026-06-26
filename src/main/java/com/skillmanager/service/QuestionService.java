package com.skillmanager.service;

import com.skillmanager.dao.QuestionDAO;
import com.skillmanager.model.Question;

import java.util.List;

public class QuestionService {

    QuestionDAO questionDAO = new QuestionDAO();

    // GET QUESTIONS BY SKILL ID

    public List<Question> getQuestionsBySkillId(int skillId) {

        return questionDAO.getQuestionsBySkillId(skillId);

    }

    // ADD QUESTION

    public boolean addQuestion(Question question) {

        return questionDAO.addQuestion(question);

    }
    
    // GET ALL QUESTIONS

public List<Question> getAllQuestions() {

    return questionDAO
            .getAllQuestions();
    
}
    
    // DELETE QUESTION

public boolean deleteQuestion(
        int questionId) {

    return questionDAO
            .deleteQuestion(
                    questionId);

}

// UPDATE QUESTION

public boolean updateQuestion(
        Question question) {

    return questionDAO
            .updateQuestion(
                    question);

}

// GET QUESTION BY ID

public Question getQuestionById(
        int questionId) {

    return questionDAO
            .getQuestionById(
                    questionId);

}

}
