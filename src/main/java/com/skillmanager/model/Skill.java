package com.skillmanager.model;

/**
 *
 * @author mohdgufran
 */
public class Skill
{
    private int skillId;
    private String skillName;
    private String description;
    private String category;
    
    
    // Default Constructor
    public Skill() {
    }

    // 2. Parametrized Constructor
    public Skill(int skillId, String skillName, String description, String category) {
        this.skillId = skillId;
        this.skillName = skillName;
        this.description = description;
        this.category = category;
    }

    public int getSkillId() {
        return skillId;
    }

    public void setSkillId(int skillId) {
        this.skillId = skillId;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    
}
