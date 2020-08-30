package com.dunamis.leadManagement.service.impl;
import com.dunamis.leadManagement.persistence.LeadRepository;
import com.dunamis.leadManagement.domain.Lead;
import com.dunamis.leadManagement.service.LeadService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("LeadService")
@Transactional
public class LeadServiceImpl implements LeadService {

    @Autowired
    private LeadRepository leadRepository;
    public LeadServiceImpl() {
    }

    @Transactional
    public Lead findById(Integer id) {
        return leadRepository.findById(id);
    }

    @Transactional
    public List<Lead> findAll() {
        return leadRepository.findAll();
    }
     
    @Transactional
    public void saveLead(Lead lead) {
        Lead existingLead = leadRepository.findById(lead.getId());
        if (existingLead != null) {
        if (existingLead != lead) {      
        existingLead.setId(lead.getId());
                existingLead.setLead(lead.getLead());
                existingLead.setProduct(lead.getProduct());
                existingLead.setCustomer(lead.getCustomer());
                existingLead.setDate(lead.getDate());
                existingLead.setOrganization(lead.getOrganization());
        }
        lead = leadRepository.save(existingLead);
    }else{
        lead = leadRepository.save(lead);
        }
        leadRepository.flush();
    }

    public boolean deleteLead(Integer leadId) {
        Lead lead = leadRepository.findById(leadId);
        if(lead!=null) {
            leadRepository.delete(lead);
            return true;
        }else {
            return false;
        }
    }@Transactional
    public List<Lead> findAllByProductId(Integer  productId) {
        return new java.util.ArrayList<Lead>(leadRepository.findAllByProductId(productId));
    }@Transactional
    public List<Lead> findAllByCustomerId(Integer  customerId) {
        return new java.util.ArrayList<Lead>(leadRepository.findAllByCustomerId(customerId));
    }@Transactional
    public List<Lead> findAllByOrganizationId(Integer  organizationId) {
        return new java.util.ArrayList<Lead>(leadRepository.findAllByOrganizationId(organizationId));
    }

    

}