package com.example.demo.bootstrap;

import com.example.demo.dao.CountryRepository;
import com.example.demo.dao.CustomerRepository;
import com.example.demo.dao.DivisionRepository;
import com.example.demo.entities.Country;
import com.example.demo.entities.Customer;
import com.example.demo.entities.Division;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BootStrapData implements CommandLineRunner {
    private final CustomerRepository customerRepository;
    private final DivisionRepository divisionRepository;
    public BootStrapData(CustomerRepository customerRepository, DivisionRepository divisionRepository){
        this.customerRepository = customerRepository;
        this.divisionRepository = divisionRepository;
    }

    @Override
    public void run(String... args) throws Exception{
        List<Customer> customers = (List<Customer>) customerRepository.findAll();
        List<Division> divisions = (List<Division>) divisionRepository.findAll();
        if(customers.size() < 5) {
            Division division = divisions.get(0);

            Customer first = new Customer("748 N Genevieve Ln", "Justin", "Ham", "4085167761", "95128", division);
            Customer second = new Customer("308 N Arroyo Ln", "Walter", "White", "5555555555", "55555", division);
            Customer third = new Customer("123 Rainbow Dr", "John", "Smith", "1231231234", "12345", division);
            Customer fourth = new Customer("4324 Wow Avenue", "Frank", "Jones", "3213214321", "54321", division);
            Customer fifth = new Customer("1577 Brookvale Dr", "Anthony", "Freeman", "9099099900", "53921", division);

            division.addCustomer(first);
            division.addCustomer(second);
            division.addCustomer(third);
            division.addCustomer(fourth);
            division.addCustomer(fifth);

            customerRepository.save(first);
            customerRepository.save(second);
            customerRepository.save(third);
            customerRepository.save(fourth);
            customerRepository.save(fifth);
        }
    }
}
