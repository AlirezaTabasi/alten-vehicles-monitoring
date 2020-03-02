package com.alten.customer.repository;

import com.alten.customer.model.Customer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@Rollback
@SpringBootTest
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void insert_customer_test() {
        Customer customer = new Customer();
        customer.setName("Alireza");
        customer.setAddress("Iran, Tehran");

        Customer insertedCustomer = customerRepository.save(customer);

        String customerName = customerRepository.findById(insertedCustomer.getId()).get().getName();

        Assert.assertEquals(customerName, customer.getName());
    }

    @Test
    public void find_customer_by_part_of_name_test() {
        Customer customer = new Customer();
        customer.setName("Alireza");
        customer.setAddress("Iran, Tehran");

        customerRepository.save(customer);

        List<Customer> customers = customerRepository.findCustomerByPartOfName("rez");

        Assert.assertEquals(customers.size(), 1);
    }
}
