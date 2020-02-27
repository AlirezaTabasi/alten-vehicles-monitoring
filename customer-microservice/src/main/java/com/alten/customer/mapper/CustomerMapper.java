package com.alten.customer.mapper;

import com.alten.customer.dto.AddressDTO;
import com.alten.customer.dto.CustomerDTO;
import com.alten.customer.model.Address;
import com.alten.customer.model.Customer;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CustomerMapper {

    private final ModelMapper modelMapper;

    public Customer convertToEntity(CustomerDTO customerDTO) {
        if (customerDTO.getAddress() == null)
            customerDTO.setAddress(new AddressDTO());
        Customer customer = modelMapper.map(customerDTO, Customer.class);
        customer.setAddress(convertToEntity(customerDTO.getAddress()));
        return customer;
    }

    public CustomerDTO convertToDto(Customer customer) {
        if (customer.getAddress() == null)
            customer.setAddress(new Address());
        CustomerDTO customerDTO = modelMapper.map(customer, CustomerDTO.class);
        customerDTO.setAddress(convertToDto(customer.getAddress()));
        return customerDTO;
    }

    public Address convertToEntity(AddressDTO addressDTO) {
        return modelMapper.map(addressDTO, Address.class);
    }

    public AddressDTO convertToDto(Address address) {
        return modelMapper.map(address, AddressDTO.class);
    }
}
