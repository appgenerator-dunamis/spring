package com.dunamis.leadManagement.web.rest; 
import com.dunamis.leadManagement.domain.Product;
import com.dunamis.leadManagement.persistence.ProductRepository;
import com.dunamis.leadManagement.service.ProductService;
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


@Controller("ProductRestController")
public class ProductRestController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/Product", method = RequestMethod.PUT)
    @ResponseBody
    public Product saveProduct(@RequestBody Product product) {
    productService.saveProduct(product);
        return productRepository.findById(product.getId());
    }

    @RequestMapping(value = "/Product", method = RequestMethod.POST)
    @ResponseBody
    public Product newProduct(@RequestBody Product product) {
    productService.saveProduct(product);
        return productRepository.findById(product.getId());
    }

    @RequestMapping(value = "/Product", method = RequestMethod.GET)
    @ResponseBody
    public List<Product> listProducts() {
        return new java.util.ArrayList<Product>(productService.findAll());
    }

    @RequestMapping(value = "/Product/{product_id}", method = RequestMethod.GET)
    @ResponseBody
    public Product loadProduct(@PathVariable Integer product_id) {
        return productService.findById(product_id);
    }

    @RequestMapping(value = "/Product/Delete/{product_id}", method = RequestMethod.GET)
    @ResponseBody
    public Boolean deleteProduct(@PathVariable Integer product_id) {
        return productService.deleteProduct(product_id);
    }
    @RequestMapping(value = "/Product/Page/{page}", method = RequestMethod.GET)
    @ResponseBody
    public Page<Product> findAllPaged(@PathVariable Integer page){
    	Sort sort = new Sort(new Sort.Order(Direction.DESC, "id"));
		Pageable pageable = new PageRequest(page, 5, sort);
    	return (productRepository.findAll(pageable));
    }

 @RequestMapping(value = "/Product/Page/{page}/Sort/{sortField}/Direction/{direction}", method = RequestMethod.GET)
    @ResponseBody
    public Page<Product> findAllPagedSorted(@PathVariable Integer page, @PathVariable String sortField, @PathVariable int direction){
				
		Sort sort;
		
		if(direction ==1)
			sort = Sort.by(sortField).descending();
		else
			sort = Sort.by(sortField).ascending();
		
		Pageable sortedPaged = PageRequest.of(page, 10, sort);
    	return (productRepository.findAll(sortedPaged));
    }


}