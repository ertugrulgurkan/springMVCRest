package com.ertugrul.springmvcrest.bootstrap;

import com.ertugrul.springmvcrest.domain.Category;
import com.ertugrul.springmvcrest.domain.Customer;
import com.ertugrul.springmvcrest.repositories.CategoryRepository;
import com.ertugrul.springmvcrest.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {
    CategoryRepository categoryRepository;
    CustomerRepository customerRepository;

    public Bootstrap(CategoryRepository categoryRepository, CustomerRepository customerRepository) {
        this.categoryRepository = categoryRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... args) {
        Category fruits = new Category();
        fruits.setName("Fruits");

        Category dried = new Category();
        dried.setName("Dried");

        Category fresh = new Category();
        fresh.setName("Fresh");

        Category exotic = new Category();
        exotic.setName("Exotic");

        Category nuts = new Category();
        nuts.setName("Nuts");


        Customer c1 = new Customer();
        c1.setName("Jimmy");

        Customer c2 = new Customer();
        c2.setName("Michael");

        Customer c3 = new Customer();
        c3.setName("Jasmine");



        categoryRepository.save(fruits);
        categoryRepository.save(dried);
        categoryRepository.save(fresh);
        categoryRepository.save(exotic);
        categoryRepository.save(nuts);

        customerRepository.save(c1);
        customerRepository.save(c2);
        customerRepository.save(c3);


        System.out.println("Data Loaded = " + categoryRepository.count() );

    }
}
