package com.skillmanager.model;

/**
 *
 * @author mohdgufran
 */
public class Resource
{
    private int resourceId;
    private int skillId;
    private String percentageRange;
    private String resourceType;
    private String title;
    private String link;
    private String description;
    
    // Default Constructor
    public Resource()
    {
        
    }
    
    // Parameterized constructor
    public Resource(int resourceId,
                int skillId,
                String percentageRange,
                String resourceType,
                String title,
                String link,
                String description)
{
    this.resourceId = resourceId;
    this.skillId = skillId;
    this.percentageRange = percentageRange;
    this.resourceType = resourceType;
    this.title = title;
    this.link = link;
    this.description = description;
}

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public int getSkillId() {
        return skillId;
    }

    public void setSkillId(int skillId) {
        this.skillId = skillId;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPercentageRange() {
        return percentageRange;
    }

    public void setPercentageRange(String percentageRange) {
        this.percentageRange = percentageRange;
    }
    
}
    
