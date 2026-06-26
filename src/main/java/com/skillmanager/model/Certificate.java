package com.skillmanager.model;

// 1. Date class importing
import java.util.Date;

/**
 *
 * @author mohdgufran
 */
public class Certificate
{
    // 2. Attributes
    private String skillName;
    private int certificateId;
    private int userId;
    private int skillId;
    private double percentage;       // decimal(5,2)
    private Date issueDate;          // issue_date
    private String certificateCode;  // certificate_code
    
    private String studentName;

    // 3. Default Constructor
    public Certificate() {
    }

    // 4. Parameterized Constructor
    public Certificate(int certificateId, int userId, int skillId, double percentage, Date issueDate, String certificateCode) {
        this.certificateId = certificateId;
        this.userId = userId;
        this.skillId = skillId;
        this.percentage = percentage;
        this.issueDate = issueDate;
        this.certificateCode = certificateCode;
    }

    // 5. Getters and Setters
    public int getCertificateId() {
        return certificateId;
    }

    public void setCertificateId(int certificateId) {
        this.certificateId = certificateId;
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

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public String getCertificateCode() {
        return certificateCode;
    }

    public void setCertificateCode(String certificateCode) {
        this.certificateCode = certificateCode;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}
