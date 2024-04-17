package com.example.demo.bootstrap;

import com.example.demo.dao.CustomerRepository;
import com.example.demo.entities.Customer;
import com.example.demo.entities.Division;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private final CustomerRepository customerRepository;

    public BootStrapData(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... args) throws Exception{
        Division division = new Division();
        Customer first = new Customer("748 N Genevieve Ln", "Justin", "Ham", "4085167761", "95128", division);
        Customer second = new Customer("308 N Arroyo Ln", "Walter", "White", "5555555555", "55555", division);
        Customer third = new Customer("123 Rainbow Dr", "John", "Smith", "1231231234", "12345", division);
        Customer fourth = new Customer("4324 Wow Avenue", "Frank", "Jones", "3213214321", "54321", division);
        Customer fifth = new Customer("1577 Brookvale Dr", "Anthony", "Freeman", "9099099900", "53921", division);

        //customerRepository.save(first);
        //customerRepository.save(second);
        //customerRepository.save(third);
        //customerRepository.save(fourth);
        //customerRepository.save(fifth);
    }
}
