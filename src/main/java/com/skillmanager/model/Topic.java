package com.skillmanager.model;

public class Topic {

    private int topicId;
    private int skillId;
    private String topicName;
    private String topicContent;
    private int topicOrder;

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    public int getSkillId() {
        return skillId;
    }

    public void setSkillId(int skillId) {
        this.skillId = skillId;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getTopicContent() {
        return topicContent;
    }

    public void setTopicContent(String topicContent) {
        this.topicContent = topicContent;
    }

    public int getTopicOrder() {
        return topicOrder;
    }

    public void setTopicOrder(int topicOrder) {
        this.topicOrder = topicOrder;
    }
}