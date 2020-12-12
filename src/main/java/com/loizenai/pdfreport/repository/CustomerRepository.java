package com.loizenai.pdfreport.repository;

import org.springframework.data.repository.CrudRepository;

import com.grokonez.pdfreport.model.Customer;
 
public interface CustomerRepository extends CrudRepository<Customer, Long>{}