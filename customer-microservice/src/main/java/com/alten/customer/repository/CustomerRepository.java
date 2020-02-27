package com.alten.customer.repository;

import com.alten.customer.model.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
    @Query("SELECT c from Customer c where c.name LIKE  CONCAT( '%', :name, '%') ")
    List<Customer> findCustomerByPartOfName(@Param("name") String name);
}
