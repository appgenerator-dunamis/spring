package com.dunamis.leadManagement.service.impl;
import com.dunamis.leadManagement.persistence.ProductRepository;
import com.dunamis.leadManagement.domain.Product;
import com.dunamis.leadManagement.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("ProductService")
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    public ProductServiceImpl() {
    }

    @Transactional
    public Product findById(Integer id) {
        return productRepository.findById(id);
    }

    @Transactional
    public List<Product> findAll() {
        return productRepository.findAll();
    }
     
    @Transactional
    public void saveProduct(Product product) {
        Product existingProduct = productRepository.findById(product.getId());
        if (existingProduct != null) {
        if (existingProduct != product) {      
        existingProduct.setId(product.getId());
                existingProduct.setProduct(product.getProduct());
        }
        product = productRepository.save(existingProduct);
    }else{
        product = productRepository.save(product);
        }
        productRepository.flush();
    }

    public boolean deleteProduct(Integer productId) {
        Product product = productRepository.findById(productId);
        if(product!=null) {
            productRepository.delete(product);
            return true;
        }else {
            return false;
        }
    }

    

}