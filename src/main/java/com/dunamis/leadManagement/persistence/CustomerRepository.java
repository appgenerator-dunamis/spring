package com.dunamis.leadManagement.persistence;  
import com.dunamis.leadManagement.domain.Customer;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {	 
    Customer findById(Integer id);
    List<Customer> findAll();
    public List<Customer> findAllByCustomerId(Integer customerId);  
   Page<Customer> findAll(Pageable pageable);

}