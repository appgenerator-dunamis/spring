package com.dunamis.leadManagement.web.rest; 
import com.dunamis.leadManagement.domain.Organization;
import com.dunamis.leadManagement.persistence.OrganizationRepository;
import com.dunamis.leadManagement.service.OrganizationService;
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


@Controller("OrganizationRestController")
public class OrganizationRestController {

    @Autowired
    private OrganizationRepository organizationRepository;

    @Autowired
    private OrganizationService organizationService;

    @RequestMapping(value = "/Organization", method = RequestMethod.PUT)
    @ResponseBody
    public Organization saveOrganization(@RequestBody Organization organization) {
    organizationService.saveOrganization(organization);
        return organizationRepository.findById(organization.getId());
    }

    @RequestMapping(value = "/Organization", method = RequestMethod.POST)
    @ResponseBody
    public Organization newOrganization(@RequestBody Organization organization) {
    organizationService.saveOrganization(organization);
        return organizationRepository.findById(organization.getId());
    }

    @RequestMapping(value = "/Organization", method = RequestMethod.GET)
    @ResponseBody
    public List<Organization> listOrganizations() {
        return new java.util.ArrayList<Organization>(organizationService.findAll());
    }

    @RequestMapping(value = "/Organization/{organization_id}", method = RequestMethod.GET)
    @ResponseBody
    public Organization loadOrganization(@PathVariable Integer organization_id) {
        return organizationService.findById(organization_id);
    }

    @RequestMapping(value = "/Organization/Delete/{organization_id}", method = RequestMethod.GET)
    @ResponseBody
    public Boolean deleteOrganization(@PathVariable Integer organization_id) {
        return organizationService.deleteOrganization(organization_id);
    }
    @RequestMapping(value = "/Organization/Page/{page}", method = RequestMethod.GET)
    @ResponseBody
    public Page<Organization> findAllPaged(@PathVariable Integer page){
    	Sort sort = new Sort(new Sort.Order(Direction.DESC, "id"));
		Pageable pageable = new PageRequest(page, 5, sort);
    	return (organizationRepository.findAll(pageable));
    }

 @RequestMapping(value = "/Organization/Page/{page}/Sort/{sortField}/Direction/{direction}", method = RequestMethod.GET)
    @ResponseBody
    public Page<Organization> findAllPagedSorted(@PathVariable Integer page, @PathVariable String sortField, @PathVariable int direction){
				
		Sort sort;
		
		if(direction ==1)
			sort = Sort.by(sortField).descending();
		else
			sort = Sort.by(sortField).ascending();
		
		Pageable sortedPaged = PageRequest.of(page, 10, sort);
    	return (organizationRepository.findAll(sortedPaged));
    }


}