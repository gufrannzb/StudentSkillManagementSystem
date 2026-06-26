package com.skillmanager.dao;

import com.skillmanager.model.Skill;
import com.skillmanager.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

public class SkillDAO {

    Connection con;

    // GET ALL SKILLS

    public List<Skill> getAllSkills() {

        List<Skill> skillList = new ArrayList<>();

        try {

            con = DBConnection.getConnection();

            String query = "SELECT skill_id, skill_name, description, category FROM skills";

            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Skill skill = new Skill();

                skill.setSkillId(rs.getInt("skill_id"));
                skill.setSkillName(rs.getString("skill_name"));
                skill.setDescription(rs.getString("description"));
                skill.setCategory(rs.getString("category"));

                skillList.add(skill);

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

        return skillList;

    }
    
    public Skill getSkillById(int skillId) {

    Skill skill = null;

    try {

        con = DBConnection.getConnection();

        String query =
        "SELECT * FROM skills "
        + "WHERE skill_id = ?";

        PreparedStatement ps =
                con.prepareStatement(query);

        ps.setInt(1, skillId);

        ResultSet rs =
                ps.executeQuery();

        if (rs.next()) {

            skill = new Skill();

            skill.setSkillId(
                    rs.getInt("skill_id"));

            skill.setSkillName(
                    rs.getString("skill_name"));

            skill.setDescription(
                    rs.getString("description"));

            skill.setCategory(
                    rs.getString("category"));
        }

    } catch (Exception e) {

        e.printStackTrace();

    }

    return skill;
}
    
    public boolean addSkill(Skill skill) {

    try {

        con = DBConnection.getConnection();

        String query =
        "INSERT INTO skills(skill_name,description,category) VALUES(?,?,?)";

        PreparedStatement ps =
                con.prepareStatement(query);

        ps.setString(1, skill.getSkillName());
        ps.setString(2, skill.getDescription());
        ps.setString(3, skill.getCategory());

        return ps.executeUpdate() > 0;

    } catch(Exception e) {

        e.printStackTrace();
    }

    return false;
}

public boolean updateSkill(Skill skill) {

    try {

        con = DBConnection.getConnection();

        String query =
        "UPDATE skills SET skill_name=?, description=?, category=? WHERE skill_id=?";

        PreparedStatement ps =
                con.prepareStatement(query);

        ps.setString(1, skill.getSkillName());
        ps.setString(2, skill.getDescription());
        ps.setString(3, skill.getCategory());
        ps.setInt(4, skill.getSkillId());

        return ps.executeUpdate() > 0;

    } catch(Exception e) {

        e.printStackTrace();
    }

    return false;
}

public boolean deleteSkill(int skillId) {

    try {

        con = DBConnection.getConnection();

        String query =
        "DELETE FROM skills WHERE skill_id=?";

        PreparedStatement ps =
                con.prepareStatement(query);

        ps.setInt(1, skillId);

        return ps.executeUpdate() > 0;

    } catch(Exception e) {

        e.printStackTrace();
    }

    return false;
}

}