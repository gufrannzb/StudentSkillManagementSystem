package com.skillmanager.service;

import com.skillmanager.dao.ResourceDAO;
import com.skillmanager.model.Resource;

import java.util.List;

public class ResourceService {
   

    ResourceDAO resourceDAO =
            new ResourceDAO();

    public List<Resource>
    getResourcesBySkillId(
            int skillId) {

        return resourceDAO
                .getResourcesBySkillId(
                        skillId);
    }

    public boolean addResource(
            Resource resource) {

        return resourceDAO
                .addResource(
                        resource);
    }
    
    public Resource getResourceById(
        int resourceId) {

    return resourceDAO
            .getResourceById(
                    resourceId);
}
    
    public List<Resource> getResourcesBySkillIdAndRange(
        int skillId,
        String percentageRange) {

    return resourceDAO
            .getResourcesBySkillIdAndRange(
                    skillId,
                    percentageRange);
}
    
    public boolean updateResource(
        Resource resource) {

    return resourceDAO
            .updateResource(
                    resource);
}
    
    public boolean deleteResource(
        int resourceId) {

    return resourceDAO
            .deleteResource(
                    resourceId);
}
    

}