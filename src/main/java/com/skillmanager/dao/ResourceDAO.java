package com.skillmanager.dao;

import com.skillmanager.model.Resource;
import com.skillmanager.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ResourceDAO {

    Connection con;

    public List<Resource> getResourcesBySkillId(
            int skillId) {
        
        

        List<Resource> resourceList =
                new ArrayList<>();

        try {

            con =
            DBConnection.getConnection();

            String query =
            "SELECT * FROM resources "
            + "WHERE skill_id=?";

            PreparedStatement ps =
            con.prepareStatement(query);

            ps.setInt(1, skillId);

            ResultSet rs =
            ps.executeQuery();

            while(rs.next()) {

                Resource resource =
                new Resource();

                resource.setResourceId(
                rs.getInt("resource_id"));

                resource.setSkillId(
                rs.getInt("skill_id"));
                
                resource.setPercentageRange(
                rs.getString("percentage_range"));

                resource.setResourceType(
                rs.getString("resource_type"));

                resource.setTitle(
                rs.getString("title"));

                resource.setLink(
                rs.getString("link"));

                resource.setDescription(
                rs.getString("description"));

                resourceList.add(resource);
            }

        } catch(Exception e) {

            e.printStackTrace();

        }

        return resourceList;
    }
    
    public boolean addResource(
        Resource resource) {

    try {

        con =
        DBConnection.getConnection();

        String query =
        "INSERT INTO resources(skill_id, "
        + "percentage_range, resource_type, title, link, description) "
        + "VALUES(?,?,?,?,?,?)";

        PreparedStatement ps =
        con.prepareStatement(query);

       ps.setInt(
        1,
        resource.getSkillId());

        ps.setString(
        2,
        resource.getPercentageRange());

        ps.setString(
        3,
        resource.getResourceType());

        ps.setString(
        4,
        resource.getTitle());

        ps.setString(
        5,
        resource.getLink());

        ps.setString(
        6,
        resource.getDescription());

        return ps.executeUpdate() > 0;

    } catch(Exception e) {

        e.printStackTrace();
    }

    return false;
}
    
    public Resource getResourceById(int resourceId) {

    Resource resource = null;

    try {

        con = DBConnection.getConnection();

        String query =
                "SELECT * FROM resources WHERE resource_id=?";

        PreparedStatement ps =
                con.prepareStatement(query);

        ps.setInt(1, resourceId);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {

            resource = new Resource();

            resource.setResourceId(
                    rs.getInt("resource_id"));

            resource.setSkillId(
                    rs.getInt("skill_id"));
            
            resource.setPercentageRange(
            rs.getString("percentage_range"));

            resource.setResourceType(
                    rs.getString("resource_type"));

            resource.setTitle(
                    rs.getString("title"));

            resource.setLink(
                    rs.getString("link"));

            resource.setDescription(
                    rs.getString("description"));
        }

    } catch (Exception e) {

        e.printStackTrace();
    }

    return resource;
}
    

    public boolean updateResource(Resource resource) {

    try {

        con = DBConnection.getConnection();

        String query =
        "UPDATE resources SET "
        + "skill_id=?, "
        + "percentage_range=?, "
        + "resource_type=?, "
        + "title=?, "
        + "link=?, "
        + "description=? "
        + "WHERE resource_id=?";

        PreparedStatement ps =
                con.prepareStatement(query);

        ps.setInt(
        1,
        resource.getSkillId());

        ps.setString(
        2,
        resource.getPercentageRange());

        ps.setString(
        3,
        resource.getResourceType());

        ps.setString(
        4,
        resource.getTitle());

        ps.setString(
        5,
        resource.getLink());

        ps.setString(
        6,
        resource.getDescription());

        ps.setInt(
        7,
        resource.getResourceId());

        return ps.executeUpdate() > 0;

    } catch (Exception e) {

        e.printStackTrace();
    }

    return false;
}
    
    public List<Resource> getResourcesBySkillIdAndRange(
        int skillId,
        String percentageRange) {

    List<Resource> resourceList =
            new ArrayList<>();

    try {

        con = DBConnection.getConnection();

        String query =
                "SELECT * FROM resources "
                + "WHERE skill_id=? AND percentage_range=?";

        PreparedStatement ps =
                con.prepareStatement(query);

        ps.setInt(1, skillId);
        ps.setString(2, percentageRange);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {

            Resource resource =
                    new Resource();

            resource.setResourceId(
                    rs.getInt("resource_id"));

            resource.setSkillId(
                    rs.getInt("skill_id"));

            resource.setPercentageRange(
                    rs.getString("percentage_range"));

            resource.setResourceType(
                    rs.getString("resource_type"));

            resource.setTitle(
                    rs.getString("title"));

            resource.setLink(
                    rs.getString("link"));

            resource.setDescription(
                    rs.getString("description"));

            resourceList.add(resource);
        }

    } catch (Exception e) {

        e.printStackTrace();
    }

    return resourceList;
}
    
    
    public boolean deleteResource(int resourceId) {

    try {

        con = DBConnection.getConnection();

        String query =
                "DELETE FROM resources "
                + "WHERE resource_id=?";

        PreparedStatement ps =
                con.prepareStatement(query);

        ps.setInt(1, resourceId);

        return ps.executeUpdate() > 0;

    } catch (Exception e) {

        e.printStackTrace();
    }

    return false;
}
    
}