package com.example.demo.bootstrap;

import com.example.demo.dao.CustomerRepository;
import com.example.demo.dao.DivisionRepository;
import com.example.demo.entities.Customer;
import com.example.demo.entities.Division;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final CustomerRepository customerRepository;
    private final DivisionRepository divisionRepository;

    public BootStrapData(CustomerRepository customerRepository, DivisionRepository divisionRepository) {
        this.customerRepository = customerRepository;
        this.divisionRepository = divisionRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        // Division divOne = new Division();
        // divOne.setId(29L);
        Division divOne = divisionRepository.findById(26L).orElse(null);
        Customer adam = new Customer("Adam", "Avery", "3125 Arlington Avenue", "94523", "510-812-5621", divOne);

        customerRepository.save(adam);


        Customer omid = new Customer("Omid", "Ershad", "32562 Lake Bridgecoin", "78210", "231-920-3921", divOne);

        customerRepository.save(omid);

        Customer jake = new Customer("Jake", "Crandal", "4111 Gary Street", "71231", "510-764-6860", divOne);

        customerRepository.save(jake);

        Customer hayeda = new Customer("Hayeda", "Danishwar", "3020 Baxter Drive", "21023", "920-492-9230", divOne);

        customerRepository.save(hayeda);

        Customer arshad = new Customer("Arshad", "Dashra", "2010 Yekta Lane", "50125", "291-2021-4921", divOne);

        customerRepository.save(arshad);
        //if (customerRepository.count() < 2) {
        //    customerRepository.save(adam);
        //}

        System.out.println("Started in Bootstrap:");

        System.out.println("Number of customers: " + customerRepository.count());

        /* Customer omid = new Customer("Omid", "Ershad", "32562 Lake Summer Drive", "94537", "5108156543");
        Division one = new Division(53451L);
        //omid.getDivision().add(one);
        //one.getCustomers().add(omid);

        customerRepository.save(omid);
        divisionRepository.save(one);

        Customer hamed = new Customer("Hamed", "Point", "10234 Brown Lane", "67832", "3206542310");
        Division two = new Division(123512L);
        //omid.getDivision().add(two);
        //one.getCustomers().add(hamed);

        customerRepository.save(hamed);
        divisionRepository.save(two);

        Customer hayeda = new Customer("Hayeda", "Crandal", "650 Berry Farm Lane", "10345", "5107646860");
        Division three = new Division(3425233L);
        //omid.getDivision().add(three);
        //one.getCustomers().add(hayeda);

        customerRepository.save(hayeda);
        divisionRepository.save(three);

        Customer arshad = new Customer("Arshad", "Dasheed", "4405 Cofo Drive", "48504", "5102857602");
        Division four = new Division(857334L);
        //omid.getDivision().add(four);
        //one.getCustomers().add(arshad);

        customerRepository.save(arshad);
        divisionRepository.save(four);

        Customer tim = new Customer("Tim", "Dave", "2452 Camping See", "68203", "2816028502");
        Division five = new Division(7321345L);
        //omid.getDivision().add(five);
        //one.getCustomers().add(tim);

        customerRepository.save(tim);
        divisionRepository.save(five);

        System.out.println("Bootstrap works");

        System.out.println("Number of people: " + customerRepository.count()); */

    }

}
