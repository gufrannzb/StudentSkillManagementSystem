package com.skillmanager.model;

import java.util.Date;

/**
 *
 * @author mohdgufran
 */

public class Result {
    // 1. Attributes
    private String skillName;
    private int resultId;
    private int userId;
    private int skillId;
    private double percentage;   // decimal(5,2)
    private String skillLevel;
    private Date testDate;       // timestamp
    private String userName;

    // 2. Default Constructor
    public Result() {
    }

    // 3. Parameterized Constructor
    public Result(int resultId, int userId, int skillId, double percentage, String skillLevel, Date testDate) {
        this.resultId = resultId;
        this.userId = userId;
        this.skillId = skillId;
        this.percentage = percentage;
        this.skillLevel = skillLevel;
        this.testDate = testDate;
    }

    // 4. Getters and Setters
    public int getResultId() {
        return resultId;
    }

    public void setResultId(int resultId) {
        this.resultId = resultId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getSkillId() {
        return skillId;
    }

    public void setSkillId(int skillId) {
        this.skillId = skillId;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public String getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(String skillLevel) {
        this.skillLevel = skillLevel;
    }

    public Date getTestDate() {
        return testDate;
    }

    public void setTestDate(Date testDate) {
        this.testDate = testDate;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
