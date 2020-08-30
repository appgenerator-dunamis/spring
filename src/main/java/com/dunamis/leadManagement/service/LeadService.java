package com.dunamis.leadManagement.service;
import com.dunamis.leadManagement.domain.Lead;
import java.util.List;

public interface LeadService {
    public Lead findById(Integer id);
    public void saveLead(Lead lead_1);
    public boolean deleteLead(Integer leadId);
    public List<Lead> findAll();
    public List<Lead> findAllByProductId(Integer  product);
    public List<Lead> findAllByCustomerId(Integer  customer);
    public List<Lead> findAllByOrganizationId(Integer  organization);
}