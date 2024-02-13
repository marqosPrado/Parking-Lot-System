package br.com.marcosprado.customerservice.dtos;

import br.com.marcosprado.customerservice.domain.Customer.Customer;

public record CreateCustomerDTO(
        String cpf,
        String firstName,
        String lastName,
        String email,
        String password
) {
    public Customer toCustomer() {
        return new Customer(
                cpf,
                firstName,
                lastName,
                email,
                password
        );
    }
}
