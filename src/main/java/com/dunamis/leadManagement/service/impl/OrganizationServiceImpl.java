package com.dunamis.leadManagement.service.impl;
import com.dunamis.leadManagement.persistence.OrganizationRepository;
import com.dunamis.leadManagement.domain.Organization;
import com.dunamis.leadManagement.service.OrganizationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("OrganizationService")
@Transactional
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    private OrganizationRepository organizationRepository;
    public OrganizationServiceImpl() {
    }

    @Transactional
    public Organization findById(Integer id) {
        return organizationRepository.findById(id);
    }

    @Transactional
    public List<Organization> findAll() {
        return organizationRepository.findAll();
    }
     
    @Transactional
    public void saveOrganization(Organization organization) {
        Organization existingOrganization = organizationRepository.findById(organization.getId());
        if (existingOrganization != null) {
        if (existingOrganization != organization) {      
        existingOrganization.setId(organization.getId());
                existingOrganization.setOrganization(organization.getOrganization());
        }
        organization = organizationRepository.save(existingOrganization);
    }else{
        organization = organizationRepository.save(organization);
        }
        organizationRepository.flush();
    }

    public boolean deleteOrganization(Integer organizationId) {
        Organization organization = organizationRepository.findById(organizationId);
        if(organization!=null) {
            organizationRepository.delete(organization);
            return true;
        }else {
            return false;
        }
    }

    

}