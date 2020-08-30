package com.dunamis.leadManagement.persistence;  
import com.dunamis.leadManagement.domain.Organization;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {	 
    Organization findById(Integer id);
    List<Organization> findAll();  
   Page<Organization> findAll(Pageable pageable);

}