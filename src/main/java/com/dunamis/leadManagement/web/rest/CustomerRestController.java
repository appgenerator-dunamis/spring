package com.dunamis.leadManagement.web.rest; 
import com.dunamis.leadManagement.domain.Customer;
import com.dunamis.leadManagement.persistence.CustomerRepository;
import com.dunamis.leadManagement.service.CustomerService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;


@Controller("CustomerRestController")
public class CustomerRestController {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/Customer", method = RequestMethod.PUT)
    @ResponseBody
    public Customer saveCustomer(@RequestBody Customer customer) {
    customerService.saveCustomer(customer);
        return customerRepository.findById(customer.getId());
    }

    @RequestMapping(value = "/Customer", method = RequestMethod.POST)
    @ResponseBody
    public Customer newCustomer(@RequestBody Customer customer) {
    customerService.saveCustomer(customer);
        return customerRepository.findById(customer.getId());
    }

    @RequestMapping(value = "/Customer", method = RequestMethod.GET)
    @ResponseBody
    public List<Customer> listCustomers() {
        return new java.util.ArrayList<Customer>(customerService.findAll());
    }

    @RequestMapping(value = "/Customer/{customer_id}", method = RequestMethod.GET)
    @ResponseBody
    public Customer loadCustomer(@PathVariable Integer customer_id) {
        return customerService.findById(customer_id);
    }

    @RequestMapping(value = "/Customer/Delete/{customer_id}", method = RequestMethod.GET)
    @ResponseBody
    public Boolean deleteCustomer(@PathVariable Integer customer_id) {
        return customerService.deleteCustomer(customer_id);
    }
    @RequestMapping(value = "/Customer/Page/{page}", method = RequestMethod.GET)
    @ResponseBody
    public Page<Customer> findAllPaged(@PathVariable Integer page){
    	Sort sort = new Sort(new Sort.Order(Direction.DESC, "id"));
		Pageable pageable = new PageRequest(page, 5, sort);
    	return (customerRepository.findAll(pageable));
    }

 @RequestMapping(value = "/Customer/Page/{page}/Sort/{sortField}/Direction/{direction}", method = RequestMethod.GET)
    @ResponseBody
    public Page<Customer> findAllPagedSorted(@PathVariable Integer page, @PathVariable String sortField, @PathVariable int direction){
				
		Sort sort;
		
		if(direction ==1)
			sort = Sort.by(sortField).descending();
		else
			sort = Sort.by(sortField).ascending();
		
		Pageable sortedPaged = PageRequest.of(page, 10, sort);
    	return (customerRepository.findAll(sortedPaged));
    }


    @RequestMapping(value = "/Customer/Customer/{customer_id}", method = RequestMethod.GET)
    @ResponseBody
    public List<Customer> getAllByCustomerId(@PathVariable("customer_id") Integer customerId) {
        return new java.util.ArrayList<Customer>(customerService.findAllByCustomerId(customerId));
    }

}