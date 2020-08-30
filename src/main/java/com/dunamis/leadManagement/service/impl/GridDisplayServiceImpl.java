package com.dunamis.leadManagement.service.impl;
import com.dunamis.leadManagement.domain.GridDisplay;
import com.dunamis.leadManagement.service.GridDisplayService; 
import com.dunamis.leadManagement.domain.Lead;
import com.dunamis.leadManagement.persistence.LeadRepository;import com.dunamis.leadManagement.domain.Person;
import com.dunamis.leadManagement.persistence.PersonRepository;import com.dunamis.leadManagement.domain.Customer;
import com.dunamis.leadManagement.persistence.CustomerRepository;import com.dunamis.leadManagement.domain.Product;
import com.dunamis.leadManagement.persistence.ProductRepository;import com.dunamis.leadManagement.domain.Organization;
import com.dunamis.leadManagement.persistence.OrganizationRepository;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("GridDisplayService")
@Transactional
public class GridDisplayServiceImpl implements GridDisplayService {

    public GridDisplayServiceImpl() {
    }
   
@Autowired
	private LeadRepository leadRepository;@Autowired
	private PersonRepository personRepository;@Autowired
	private CustomerRepository customerRepository;@Autowired
	private ProductRepository productRepository;@Autowired
	private OrganizationRepository organizationRepository;

    @Transactional
    public GridDisplay getListItems(String gridTag, Integer param1, Integer param2, Integer param3) {
       switch (gridTag){

       case "Lead":{
				List<Lead> leads = leadRepository.findAll();
				 GridDisplay gridDisplay = new GridDisplay(); 
			     gridDisplay.setContent(leads);
			     return gridDisplay;	
			}case "Person":{
				List<Person> persons = personRepository.findAll();
				 GridDisplay gridDisplay = new GridDisplay(); 
			     gridDisplay.setContent(persons);
			     return gridDisplay;	
			}case "Customer":{
				List<Customer> customers = customerRepository.findAll();
				 GridDisplay gridDisplay = new GridDisplay(); 
			     gridDisplay.setContent(customers);
			     return gridDisplay;	
			}case "Product":{
				List<Product> products = productRepository.findAll();
				 GridDisplay gridDisplay = new GridDisplay(); 
			     gridDisplay.setContent(products);
			     return gridDisplay;	
			}case "Organization":{
				List<Organization> organizations = organizationRepository.findAll();
				 GridDisplay gridDisplay = new GridDisplay(); 
			     gridDisplay.setContent(organizations);
			     return gridDisplay;	
			}     

       }
      return null;
    }

}