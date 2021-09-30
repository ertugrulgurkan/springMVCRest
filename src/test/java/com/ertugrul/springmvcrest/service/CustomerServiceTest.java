package com.ertugrul.springmvcrest.service;

import com.ertugrul.springmvcrest.api.v1.mapper.CustomerMapper;
import com.ertugrul.springmvcrest.api.v1.model.CustomerDTO;
import com.ertugrul.springmvcrest.domain.Customer;
import com.ertugrul.springmvcrest.repositories.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

class CustomerServiceTest {

    public static final Long ID = 2L;
    public static final String NAME = "Jimmy";

    @Mock
    CustomerRepository customerRepository;

    CustomerService customerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        customerService = new CustomerServiceImpl(customerRepository, CustomerMapper.INSTANCE);
    }


    @Test
    public void getAllCustomers(){

        //given
        List<Customer> customers = Arrays.asList(new Customer(), new Customer(), new Customer());

        when(customerRepository.findAll()).thenReturn(customers);

        //when
        List<CustomerDTO> customerDTOS = customerService.getAllCustomers();

        //then
        assertEquals(3, customerDTOS.size());
    }


    @Test
    public void getCustomerByFirstName(){
        //given
        Customer customer = new Customer();
        customer.setFirstName(NAME);
        customer.setId(ID);

        //when
        when(customerRepository.findByFirstName(anyString())).thenReturn(customer);

        //when
        CustomerDTO customerDTO = customerService.getCustomerByFirstName(NAME);

        //then
        assertEquals(ID, customerDTO.getId());
        assertEquals(NAME, customerDTO.getFirstName());

    }

    @Test
    void getCustomerById() {
        //given
        Customer customer = new Customer();
        customer.setFirstName(NAME);
        customer.setId(ID);

        //when
        when(customerRepository.findById(anyLong())).thenReturn(java.util.Optional.of(customer));

        //when
        CustomerDTO customerDTO = customerService.getCustomerById(ID);

        //then
        assertEquals(ID, customerDTO.getId());
        assertEquals(NAME, customerDTO.getFirstName());
    }
}