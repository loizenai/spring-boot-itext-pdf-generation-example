package com.loizenai.pdfreport;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.grokonez.pdfreport.model.Customer;
import com.grokonez.pdfreport.repository.CustomerRepository;

@SpringBootApplication
public class SpringJpaPdfReportApplication  implements CommandLineRunner{

	@Autowired
	CustomerRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringJpaPdfReportApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
    	
    	if(repository.count() == 0) {
    		// save a list of Customers
    		repository.saveAll(Arrays.asList(new Customer("Jack", "Smith"), 
    										new Customer("Adam", "Johnson"), 
    										new Customer("Kim", "Smith"),
    										new Customer("David", "Williams"), 
    										new Customer("Peter", "Davis")));
    	}

    }
}
