package com.dunamis.leadManagement.service.impl;
import com.dunamis.leadManagement.persistence.CustomerRepository;
import com.dunamis.leadManagement.domain.Customer;
import com.dunamis.leadManagement.service.CustomerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("CustomerService")
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    public CustomerServiceImpl() {
    }

    @Transactional
    public Customer findById(Integer id) {
        return customerRepository.findById(id);
    }

    @Transactional
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
     
    @Transactional
    public void saveCustomer(Customer customer) {
        Customer existingCustomer = customerRepository.findById(customer.getId());
        if (existingCustomer != null) {
        if (existingCustomer != customer) {      
        existingCustomer.setId(customer.getId());
                existingCustomer.setCustomer(customer.getCustomer());
        }
        customer = customerRepository.save(existingCustomer);
    }else{
        customer = customerRepository.save(customer);
        }
        customerRepository.flush();
    }

    public boolean deleteCustomer(Integer customerId) {
        Customer customer = customerRepository.findById(customerId);
        if(customer!=null) {
            customerRepository.delete(customer);
            return true;
        }else {
            return false;
        }
    }@Transactional
    public List<Customer> findAllByCustomerId(Integer  customerId) {
        return new java.util.ArrayList<Customer>(customerRepository.findAllByCustomerId(customerId));
    }

    

}