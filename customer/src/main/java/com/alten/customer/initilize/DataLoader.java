package com.alten.customer.initilize;

import com.alten.customer.model.Customer;
import com.alten.customer.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DataLoader implements ApplicationRunner {

    private final CustomerRepository customerRepository;

    public void run(ApplicationArguments args) {
        customerRepository.deleteAll();
        Customer customer = new Customer(1L, "Kalles Grustransporter AB", "Cementvägen 8, 111 11 Södertälje");
        customerRepository.save(customer);
        customer = new Customer(2L, "Johans Bulk AB", "Balkvägen 12, 222 22 Stockholm");
        customerRepository.save(customer);
        customer = new Customer(3L, "Haralds Värdetransporter AB", "Budgetvägen 1, 333 33 Uppsala");
        customerRepository.save(customer);
    }
}
