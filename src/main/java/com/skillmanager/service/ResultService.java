package com.skillmanager.service;

import com.skillmanager.dao.ResultDAO;
import com.skillmanager.model.Result;

import java.util.List;

public class ResultService {

    ResultDAO resultDAO =
            new ResultDAO();

    // SAVE RESULT

    public boolean saveResult(
            Result result) {

        return resultDAO
                .saveResult(
                        result);

    }

    // GET RESULTS BY USER ID

    public List<Result>
            getResultsByUserId(
                    int userId) {

        return resultDAO
                .getResultsByUserId(
                        userId);

    }

    // GET ALL RESULTS

    public List<Result>
            getAllResults() {

        return resultDAO
                .getAllResults();

    }
    
    // Get Total results:
    
    public int getTotalTests() {

        return resultDAO
            .getAllResults()
            .size();
}
            
            
            // GET BEST RESULT

public Result getBestResult(
        int userId,
        int skillId) {

    return resultDAO
            .getBestResult(
                    userId,
                    skillId);

}

// CHECK COOLDOWN

public boolean canAttemptTest(
        int userId,
        int skillId) {

    return resultDAO
            .canAttemptTest(
                    userId,
                    skillId);

}

public Result getBestResultByUser(
        int userId) {

    return resultDAO
            .getBestResultByUser(
                    userId);

}

public List<Result>
getAttemptsBySkill(
        int userId,
        int skillId) {

    return resultDAO
            .getAttemptsBySkill(
                    userId,
                    skillId);
}

}