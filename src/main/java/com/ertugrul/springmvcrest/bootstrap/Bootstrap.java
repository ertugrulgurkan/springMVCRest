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
        initCategories();
        initCustomers();
    }

    private void initCategories() {
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

        categoryRepository.save(fruits);
        categoryRepository.save(dried);
        categoryRepository.save(fresh);
        categoryRepository.save(exotic);
        categoryRepository.save(nuts);

        System.out.println("Categories Loaded = " + categoryRepository.count() );

    }

    private void initCustomers() {
        Customer c1 = new Customer();
        c1.setFirstName("Jimmy");
        c1.setLastName("Bob");

        Customer c2 = new Customer();
        c2.setFirstName("Michael");
        c2.setLastName("Jackson");

        Customer c3 = new Customer();
        c3.setFirstName("Jasmine");
        c3.setLastName("Blue");

        customerRepository.save(c1);
        customerRepository.save(c2);
        customerRepository.save(c3);

        System.out.println("Customers Loaded = " + customerRepository.count() );
    }
}
