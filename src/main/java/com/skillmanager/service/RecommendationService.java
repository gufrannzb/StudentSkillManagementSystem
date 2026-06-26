package com.skillmanager.service;

import com.skillmanager.dao.RecommendationDAO;
import com.skillmanager.model.Recommendation;
import java.util.List;

public class RecommendationService {

    RecommendationDAO recommendationDAO =
            new RecommendationDAO();

    public boolean addRecommendation(
            Recommendation recommendation) {

        return recommendationDAO
                .addRecommendation(
                        recommendation);
        
       
}
   
    public List<Recommendation>
getRecommendationsBySkillId(
        int skillId) {

    return recommendationDAO
            .getRecommendationsBySkillId(
                    skillId);
}
  
public Recommendation
getRecommendationById(
        int recommendationId) {

    return recommendationDAO
            .getRecommendationById(
                    recommendationId);
}

public boolean deleteRecommendation(
        int recommendationId) {

    return recommendationDAO
            .deleteRecommendation(
                    recommendationId);
}

public boolean updateRecommendation(
        Recommendation recommendation) {

    return recommendationDAO
            .updateRecommendation(
                    recommendation);
}

public Recommendation getRecommendationByRange(
        int skillId,
        String range) {

    return recommendationDAO
            .getRecommendationByRange(
                    skillId,
                    range);
}


}
    