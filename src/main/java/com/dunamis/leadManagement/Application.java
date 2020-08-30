package com.dunamis.leadManagement;
import com.dunamis.leadManagement.security.MyCorsFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import javax.servlet.Filter;


@EnableAutoConfiguration

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

   	@Bean
    public FilterRegistrationBean myFilter() {	
        FilterRegistrationBean registration = new FilterRegistrationBean();
        Filter myFilter = new MyCorsFilter();
        registration.setFilter(myFilter);
        registration.addUrlPatterns("/*");
        registration.setOrder(-1000); 
        return registration;
    }
   	
  
}