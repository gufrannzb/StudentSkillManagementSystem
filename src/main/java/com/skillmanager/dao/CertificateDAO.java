package com.skillmanager.dao;

import com.skillmanager.model.CertificateVerification;

import com.skillmanager.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.List;
import java.util.ArrayList;
import com.skillmanager.model.Certificate;

public class CertificateDAO {

    Connection con;

    // SAVE CERTIFICATE

    public boolean saveCertificate(
            int userId,
            int skillId,
            double percentage,
            String certificateCode) {

        boolean status = false;

        try {

            con = DBConnection.getConnection();

            String query =
            "INSERT INTO certificates "
            + "(user_id, skill_id, percentage, certificate_code) "
            + "VALUES (?, ?, ?, ?)";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setInt(1, userId);

            ps.setInt(2, skillId);

            ps.setDouble(3, percentage);

            ps.setString(4, certificateCode);

            int rows =
                    ps.executeUpdate();

            if (rows > 0) {

                status = true;

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

        return status;

    }

    // CHECK CERTIFICATE

    public boolean certificateExists(
            String certificateCode) {

        boolean status = false;

        try {

            con = DBConnection.getConnection();

            String query =
            "SELECT * FROM certificates "
            + "WHERE certificate_code = ?";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setString(
                    1,
                    certificateCode);

            ResultSet rs =
                    ps.executeQuery();

            if (rs.next()) {

                status = true;

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

        return status;

    }
    public CertificateVerification
getCertificateByCode(
        String certificateCode) {

    CertificateVerification certificate =
            null;

    try {

        con = DBConnection.getConnection();

        String query =
"SELECT u.name, "
+ "s.skill_name, "
+ "c.percentage, "
+ "c.issue_date, "
+ "c.certificate_code, "
+ "tr.skill_level "
+ "FROM certificates c "
+ "JOIN users u "
+ "ON c.user_id = u.user_id "
+ "JOIN skills s "
+ "ON c.skill_id = s.skill_id "
+ "JOIN test_results tr "
+ "ON tr.user_id = c.user_id "
+ "AND tr.skill_id = c.skill_id "
+ "WHERE c.certificate_code = ? "
+ "ORDER BY tr.percentage DESC "
+ "LIMIT 1";

        PreparedStatement ps =
                con.prepareStatement(
                        query);

        ps.setString(
                1,
                certificateCode);

        ResultSet rs =
                ps.executeQuery();

        if (rs.next()) {

            certificate =
                    new CertificateVerification();

            certificate.setStudentName(
                    rs.getString(
                            "name"));

            certificate.setSkillName(
                    rs.getString(
                            "skill_name"));

            certificate.setPercentage(
                    rs.getDouble(
                            "percentage"));

            certificate.setIssueDate(
                    rs.getString(
                            "issue_date"));

            certificate.setCertificateCode(
                    rs.getString(
                            "certificate_code"));
            
            certificate.setLevel(
        rs.getString(
                "skill_level"));
        }

    } catch (Exception e) {

        e.printStackTrace();

    }

    return certificate;
}

public String getCertificateCode(
        int userId,
        int skillId) {

    String code = null;

    try {

        con = DBConnection.getConnection();

        String query =
        "SELECT certificate_code "
        + "FROM certificates "
        + "WHERE user_id = ? "
        + "AND skill_id = ?";

        PreparedStatement ps =
                con.prepareStatement(
                        query);

        ps.setInt(
                1,
                userId);

        ps.setInt(
                2,
                skillId);

        ResultSet rs =
                ps.executeQuery();

        if (rs.next()) {

            code =
                    rs.getString(
                            "certificate_code");

        }

    } catch (Exception e) {

        e.printStackTrace();

    }

    return code;
}

public List<Certificate>
getCertificatesByUserId(
        int userId) {

    List<Certificate> certificateList =
            new ArrayList<>();

    try {

        con = DBConnection.getConnection();

        String query =
        "SELECT c.*, s.skill_name "
        + "FROM certificates c "
        + "JOIN skills s "
        + "ON c.skill_id = s.skill_id "
        + "WHERE c.user_id = ? "
        + "ORDER BY c.issue_date DESC";

        PreparedStatement ps =
                con.prepareStatement(
                        query);

        ps.setInt(
                1,
                userId);

        ResultSet rs =
                ps.executeQuery();

        while (rs.next()) {

            Certificate certificate =
                    new Certificate();

            certificate.setCertificateId(
                    rs.getInt(
                            "certificate_id"));

            certificate.setUserId(
                    rs.getInt(
                            "user_id"));

            certificate.setSkillId(
                    rs.getInt(
                            "skill_id"));

            certificate.setPercentage(
                    rs.getDouble(
                            "percentage"));

            certificate.setIssueDate(
                    rs.getTimestamp(
                            "issue_date"));

            certificate.setCertificateCode(
                    rs.getString(
                            "certificate_code"));
            

            certificate.setSkillName(
                    rs.getString(
                            "skill_name"));

            certificateList.add(
                    certificate);
        }

    } catch (Exception e) {

        e.printStackTrace();

    }

    return certificateList;
}

public List<Certificate>
getAllCertificates() {

    List<Certificate> certificateList =
            new ArrayList<>();

    try {

        con = DBConnection.getConnection();

        String query =
        "SELECT c.*, u.name, s.skill_name "
        + "FROM certificates c "
        + "JOIN users u "
        + "ON c.user_id=u.user_id "
        + "JOIN skills s "
        + "ON c.skill_id=s.skill_id";

        PreparedStatement ps =
                con.prepareStatement(
                        query);

        ResultSet rs =
                ps.executeQuery();

        while(rs.next()) {

            Certificate certificate =
                    new Certificate();

            certificate.setCertificateId(
                    rs.getInt(
                            "certificate_id"));

            certificate.setStudentName(
                    rs.getString(
                            "name"));

            certificate.setSkillName(
                    rs.getString(
                            "skill_name"));

            certificate.setPercentage(
                    rs.getDouble(
                            "percentage"));

            certificate.setIssueDate(
                    rs.getTimestamp(
                            "issue_date"));

            certificate.setCertificateCode(
                    rs.getString(
                            "certificate_code"));

            certificateList.add(
                    certificate);
        }

    } catch(Exception e) {

        e.printStackTrace();
    }

    return certificateList;
}

public boolean deleteCertificate(
        int certificateId) {

    try {

        con = DBConnection.getConnection();

        String query =
        "DELETE FROM certificates "
        + "WHERE certificate_id=?";

        PreparedStatement ps =
                con.prepareStatement(
                        query);

        ps.setInt(
                1,
                certificateId);

        return ps.executeUpdate() > 0;

    } catch(Exception e) {

        e.printStackTrace();
    }

    return false;
}

}