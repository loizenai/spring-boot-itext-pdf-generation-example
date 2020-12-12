package com.loizenai.pdfreport.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grokonez.pdfreport.model.Customer;
import com.grokonez.pdfreport.repository.CustomerRepository;
import com.grokonez.pdfreport.util.PDFGenerator;

@RestController
@RequestMapping("/api/pdf")
public class CustomerRestAPIs {
	
    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value = "/customers",
            produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> customerReport() throws IOException {
        List<Customer> customers = (List<Customer>) customerRepository.findAll();

        ByteArrayInputStream bis = PDFGenerator.customerPDFReport(customers);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=customers.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }
}