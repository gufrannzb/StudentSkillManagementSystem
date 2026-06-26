package com.skillmanager.model;

public class Recommendation {

    private int recommendationId;
    private int skillId;
    private String percentageRange;
    private String suggestionText;
    private String nextTopics;
    private String careerRoles;

    public Recommendation() {
    }

    public int getRecommendationId() {
        return recommendationId;
    }

    public void setRecommendationId(
            int recommendationId) {
        this.recommendationId =
                recommendationId;
    }

    public int getSkillId() {
        return skillId;
    }

    public void setSkillId(int skillId) {
        this.skillId = skillId;
    }

    public String getPercentageRange() {
        return percentageRange;
    }

    public void setPercentageRange(
            String percentageRange) {
        this.percentageRange =
                percentageRange;
    }

    public String getSuggestionText() {
        return suggestionText;
    }

    public void setSuggestionText(
            String suggestionText) {
        this.suggestionText =
                suggestionText;
    }

    public String getNextTopics() {
        return nextTopics;
    }

    public void setNextTopics(
            String nextTopics) {
        this.nextTopics =
                nextTopics;
    }

    public String getCareerRoles() {
        return careerRoles;
    }

    public void setCareerRoles(
            String careerRoles) {
        this.careerRoles =
                careerRoles;
    }
}