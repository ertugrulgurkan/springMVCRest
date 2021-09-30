package com.ertugrul.springmvcrest.controllers.v1;

import com.ertugrul.springmvcrest.api.v1.model.CategoryDTO;
import com.ertugrul.springmvcrest.api.v1.model.CustomerDTO;
import com.ertugrul.springmvcrest.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class CustomerControllerTest {
    public static final String FIRSTNAME = "Jim";
    public static final String LASTNAME = "Carry";

    @InjectMocks
    CustomerController customerController;

    @Mock
    CustomerService customerService;

    MockMvc mockMvc;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
    }

    @Test
    public void getAllCustomers() throws Exception {
        CustomerDTO customer1 = new CustomerDTO();
        customer1.setId(1L);
        customer1.setFirstName(FIRSTNAME);
        customer1.setLastName(LASTNAME);
        customer1.setCustomerUrl("/api/v1/customer/1");

        CustomerDTO customer2 = new CustomerDTO();
        customer2.setId(2L);
        customer2.setFirstName("Bob");
        customer1.setLastName(LASTNAME);
        customer2.setCustomerUrl("/api/v1/customer/2");

        List<CustomerDTO> customers = Arrays.asList(customer1, customer2);

        when(customerService.getAllCustomers()).thenReturn(customers);

        mockMvc.perform(get("/api/v1/customers/")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.customers", hasSize(2)));
    }

    @Test
    public void getCustomerByFirstName() throws Exception {
        CustomerDTO customer1 = new CustomerDTO();
        customer1.setId(1L);
        customer1.setFirstName(FIRSTNAME);
        customer1.setLastName(LASTNAME);
        customer1.setCustomerUrl("/api/v1/customer/1");

        when(customerService.getCustomerByFirstName(anyString())).thenReturn(customer1);

        mockMvc.perform(get("/api/v1/customers/customer/"+ FIRSTNAME)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName", equalTo(FIRSTNAME)));
    }

    @Test
    public void getCustomerById() throws Exception{
        CustomerDTO customer1 = new CustomerDTO();
        customer1.setId(1L);
        customer1.setFirstName(FIRSTNAME);
        customer1.setLastName(LASTNAME);
        customer1.setCustomerUrl("/api/v1/customer/1");

        when(customerService.getCustomerById(anyLong())).thenReturn(customer1);

        mockMvc.perform(get("/api/v1/customers/"+ 1L)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName", equalTo(FIRSTNAME)));
    }
}