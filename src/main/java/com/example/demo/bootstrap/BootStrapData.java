package com.example.demo.bootstrap;

import com.example.demo.dao.CustomerRepository;
import com.example.demo.dao.DivisionRepository;
import com.example.demo.entities.Customer;
import com.example.demo.entities.Division;
import org.springframework.boot.CommandLineRunner;

public class BootStrapData implements CommandLineRunner {

    private final CustomerRepository customerRepository;
    private final DivisionRepository divisionRepository;

    public BootStrapData(CustomerRepository customerRepository, DivisionRepository divisionRepository) {
        this.customerRepository = customerRepository;
        this.divisionRepository = divisionRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Customer omid = new Customer("Omid", "Ershad", "32562 Lake Summer Drive", "94537", "5108156543");
        Division one = new Division(53451L);
        omid.getDivision().add(one);
        one.getCustomers().add(omid);

        customerRepository.save(omid);
        divisionRepository.save(one);

        Customer hamed = new Customer("Hamed", "Point", "10234 Brown Lane", "67832", "3206542310");
        Division two = new Division(123512L);
        omid.getDivision().add(two);
        one.getCustomers().add(hamed);

        customerRepository.save(hamed);
        divisionRepository.save(two);

        Customer hayeda = new Customer("Hayeda", "Crandal", "650 Berry Farm Lane". "10345", "5107646860");
        Division three = new Division(3425233L);
        omid.getDivision().add(three);
        one.getCustomers().add(hayeda);

        customerRepository.save(hayeda);
        divisionRepository.save(three);

        Customer arshad = new Customer("Arshad", "Dasheed", "4405 Cofo Drive", "48504", "5102857602");
        Division four = new Division(857334L);
        omid.getDivision().add(four);
        one.getCustomers().add(arshad);

        Customer tim = new Customer("Tim", "Dave", "2452 Camping See", "68203", "2816028502");
        Division five = new Division(7321345L);
        omid.getDivision().add(five);
        one.getCustomers().add(tim);


    }

}
