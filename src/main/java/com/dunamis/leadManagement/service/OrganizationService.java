package com.dunamis.leadManagement.service;
import com.dunamis.leadManagement.domain.Organization;
import java.util.List;

public interface OrganizationService {
    public Organization findById(Integer id);
    public void saveOrganization(Organization organization_1);
    public boolean deleteOrganization(Integer organizationId);
    public List<Organization> findAll();
}