package com.dunamis.leadManagement.web.rest; 
import com.dunamis.leadManagement.domain.Lead;
import com.dunamis.leadManagement.persistence.LeadRepository;
import com.dunamis.leadManagement.service.LeadService;
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


@Controller("LeadRestController")
public class LeadRestController {

    @Autowired
    private LeadRepository leadRepository;

    @Autowired
    private LeadService leadService;

    @RequestMapping(value = "/Lead", method = RequestMethod.PUT)
    @ResponseBody
    public Lead saveLead(@RequestBody Lead lead) {
    leadService.saveLead(lead);
        return leadRepository.findById(lead.getId());
    }

    @RequestMapping(value = "/Lead", method = RequestMethod.POST)
    @ResponseBody
    public Lead newLead(@RequestBody Lead lead) {
    leadService.saveLead(lead);
        return leadRepository.findById(lead.getId());
    }

    @RequestMapping(value = "/Lead", method = RequestMethod.GET)
    @ResponseBody
    public List<Lead> listLeads() {
        return new java.util.ArrayList<Lead>(leadService.findAll());
    }

    @RequestMapping(value = "/Lead/{lead_id}", method = RequestMethod.GET)
    @ResponseBody
    public Lead loadLead(@PathVariable Integer lead_id) {
        return leadService.findById(lead_id);
    }

    @RequestMapping(value = "/Lead/Delete/{lead_id}", method = RequestMethod.GET)
    @ResponseBody
    public Boolean deleteLead(@PathVariable Integer lead_id) {
        return leadService.deleteLead(lead_id);
    }
    @RequestMapping(value = "/Lead/Page/{page}", method = RequestMethod.GET)
    @ResponseBody
    public Page<Lead> findAllPaged(@PathVariable Integer page){
    	Sort sort = new Sort(new Sort.Order(Direction.DESC, "id"));
		Pageable pageable = new PageRequest(page, 5, sort);
    	return (leadRepository.findAll(pageable));
    }

 @RequestMapping(value = "/Lead/Page/{page}/Sort/{sortField}/Direction/{direction}", method = RequestMethod.GET)
    @ResponseBody
    public Page<Lead> findAllPagedSorted(@PathVariable Integer page, @PathVariable String sortField, @PathVariable int direction){
				
		Sort sort;
		
		if(direction ==1)
			sort = Sort.by(sortField).descending();
		else
			sort = Sort.by(sortField).ascending();
		
		Pageable sortedPaged = PageRequest.of(page, 10, sort);
    	return (leadRepository.findAll(sortedPaged));
    }


    @RequestMapping(value = "/Lead/Product/{product_id}", method = RequestMethod.GET)
    @ResponseBody
    public List<Lead> getAllByProductId(@PathVariable("product_id") Integer productId) {
        return new java.util.ArrayList<Lead>(leadService.findAllByProductId(productId));
    }

    @RequestMapping(value = "/Lead/Customer/{customer_id}", method = RequestMethod.GET)
    @ResponseBody
    public List<Lead> getAllByCustomerId(@PathVariable("customer_id") Integer customerId) {
        return new java.util.ArrayList<Lead>(leadService.findAllByCustomerId(customerId));
    }

    @RequestMapping(value = "/Lead/Organization/{organization_id}", method = RequestMethod.GET)
    @ResponseBody
    public List<Lead> getAllByOrganizationId(@PathVariable("organization_id") Integer organizationId) {
        return new java.util.ArrayList<Lead>(leadService.findAllByOrganizationId(organizationId));
    }

}