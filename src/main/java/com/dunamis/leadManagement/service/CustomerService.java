package com.dunamis.leadManagement.service;
import com.dunamis.leadManagement.domain.Customer;
import java.util.List;

public interface CustomerService {
    public Customer findById(Integer id);
    public void saveCustomer(Customer customer_1);
    public boolean deleteCustomer(Integer customerId);
    public List<Customer> findAll();
    public List<Customer> findAllByCustomerId(Integer  customer);
}