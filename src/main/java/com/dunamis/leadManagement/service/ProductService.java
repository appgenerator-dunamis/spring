package com.dunamis.leadManagement.service;
import com.dunamis.leadManagement.domain.Product;
import java.util.List;

public interface ProductService {
    public Product findById(Integer id);
    public void saveProduct(Product product_1);
    public boolean deleteProduct(Integer productId);
    public List<Product> findAll();
}