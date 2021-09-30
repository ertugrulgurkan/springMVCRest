package com.ertugrul.springmvcrest.service;

import com.ertugrul.springmvcrest.api.v1.model.CustomerDTO;

import java.util.List;

public interface CustomerService {

    List<CustomerDTO> getAllCustomers();

    CustomerDTO getCustomerByFirstName(String firstName);

    CustomerDTO getCustomerById(Long id);
}
