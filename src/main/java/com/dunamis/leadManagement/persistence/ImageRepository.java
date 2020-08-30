package com.dunamis.leadManagement.persistence;  
import com.dunamis.leadManagement.domain.Image;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {	 
    Image findById(Integer id);
    List<Image> findAll();
    
}