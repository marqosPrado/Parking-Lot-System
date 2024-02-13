package br.com.marcosprado.customerservice.service;

import br.com.marcosprado.customerservice.domain.Customer.Customer;
import br.com.marcosprado.customerservice.dtos.CreateCustomerDTO;
import br.com.marcosprado.customerservice.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    CustomerService(CustomerRepository repository) {
        this.customerRepository = repository;
    }

    public Customer create(CreateCustomerDTO dto) {
        var customer = dto.toCustomer();
        if (existsByCpf(dto.cpf())) throw new RuntimeException("Customer already registered");
        return customerRepository.save(customer);
    }

    public Customer getCustomer(String cpf) {
        if (!existsByCpf(cpf)) throw new RuntimeException("Customer don't exists");
        return customerRepository.findByCpf(cpf).get();
    }

    private Boolean existsByCpf(String cpf) {
        return customerRepository.findByCpf(cpf).isPresent();
    }
}
