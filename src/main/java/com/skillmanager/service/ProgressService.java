package com.skillmanager.service;

/**
 *
 * @author mohdgufran
 */

import com.skillmanager.dao.ProgressDAO;

public class ProgressService {

    ProgressDAO progressDAO =
            new ProgressDAO();

    public boolean isCompleted(
            int userId,
            int topicId) {

        return progressDAO
                .isCompleted(
                        userId,
                        topicId);
    }
    
    public boolean isTopicCompleted(
        int userId,
        int topicId) {

    return progressDAO
            .isCompleted(
                    userId,
                    topicId);
}

    public void markCompleted(
            int userId,
            int topicId) {

        progressDAO
                .markCompleted(
                        userId,
                        topicId);
    }
    
    public int getCompletedTopicsCount(
        int userId,
        int skillId) {

    return progressDAO
            .getCompletedTopicsCount(
                    userId,
                    skillId);
}
    
    public int getTotalTopicsCount(
        int skillId) {

    return progressDAO
            .getTotalTopicsCount(
                    skillId);
}
}