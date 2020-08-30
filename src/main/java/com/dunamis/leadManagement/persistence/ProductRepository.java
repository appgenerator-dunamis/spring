package com.dunamis.leadManagement.persistence;  
import com.dunamis.leadManagement.domain.Product;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {	 
    Product findById(Integer id);
    List<Product> findAll();  
   Page<Product> findAll(Pageable pageable);

}