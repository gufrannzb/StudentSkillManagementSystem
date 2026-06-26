package com.skillmanager.service;

import com.skillmanager.dao.TopicDAO;
import com.skillmanager.model.Topic;

import java.util.List;

public class TopicService {

    TopicDAO topicDAO =
            new TopicDAO();

    public Topic getTopicById(
            int topicId) {

        return topicDAO
                .getTopicById(
                        topicId);
    }

    public List<Topic> getTopicsBySkillId(
            int skillId) {

        return topicDAO
                .getTopicsBySkillId(
                        skillId);
    }

    public Topic getTopicByOrder(
            int skillId,
            int topicOrder) {

        return topicDAO
                .getTopicByOrder(
                        skillId,
                        topicOrder);
    }
    
    public boolean addTopic(
        Topic topic) {

    return topicDAO
            .addTopic(
                    topic);
}
    
    public void updateTopic(
        Topic topic) {

    topicDAO
            .updateTopic(
                    topic);
}
    
    public void deleteTopic(
        int topicId) {

    topicDAO
            .deleteTopic(
                    topicId);
}
    
}