package com.skillmanager.service;

import com.skillmanager.dao.SkillDAO;
import com.skillmanager.model.Skill;

import java.util.List;

public class SkillService {

    SkillDAO skillDAO = new SkillDAO();

    // GET ALL SKILLS

    public List<Skill> getAllSkills() {

        return skillDAO.getAllSkills();

    }
    
    public int getTotalSkills() {

    return skillDAO
            .getAllSkills()
            .size();
}
    
    public Skill getSkillById(
        int skillId) {

    return skillDAO
            .getSkillById(
                    skillId);
}
    
    public boolean addSkill(
        Skill skill) {

    return skillDAO
            .addSkill(skill);
}

public boolean updateSkill(
        Skill skill) {

    return skillDAO
            .updateSkill(skill);
}

public boolean deleteSkill(
        int skillId) {

    return skillDAO
            .deleteSkill(skillId);
}

}