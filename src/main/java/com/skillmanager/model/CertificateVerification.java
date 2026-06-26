package com.skillmanager.model;

public class CertificateVerification {

    private String studentName;
    private String skillName;
    private double percentage;
    private String issueDate;
    private String certificateCode;
    private String level;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(
            String studentName) {

        this.studentName = studentName;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(
            String skillName) {

        this.skillName = skillName;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(
            double percentage) {

        this.percentage = percentage;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(
            String issueDate) {

        this.issueDate = issueDate;
    }

    public String getCertificateCode() {
        return certificateCode;
    }

    public void setCertificateCode(
            String certificateCode) {

        this.certificateCode = certificateCode;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}