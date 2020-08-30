package com.dunamis.leadManagement.persistence;  
import com.dunamis.leadManagement.domain.Lead;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

@Repository
public interface LeadRepository extends JpaRepository<Lead, Long> {	 
    Lead findById(Integer id);
    List<Lead> findAll();
    public List<Lead> findAllByProductId(Integer productId);
    public List<Lead> findAllByCustomerId(Integer customerId);
    public List<Lead> findAllByOrganizationId(Integer organizationId);  
   Page<Lead> findAll(Pageable pageable);

}