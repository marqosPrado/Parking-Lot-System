package br.com.marcosprado.customerservice.service;

import br.com.marcosprado.customerservice.domain.Customer.Customer;
import br.com.marcosprado.customerservice.domain.Vehicle.Vehicle;
import br.com.marcosprado.customerservice.dtos.CreateCustomerDTO;
import br.com.marcosprado.customerservice.dtos.CreateVehicleDTO;
import br.com.marcosprado.customerservice.dtos.GetAllVehiclesDTO;
import br.com.marcosprado.customerservice.repository.CustomerRepository;
import br.com.marcosprado.customerservice.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    private final VehicleRepository vehicleRepository;

    CustomerService(CustomerRepository repository, VehicleRepository vehicleRepository) {
        this.customerRepository = repository;
        this.vehicleRepository = vehicleRepository;
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

    public List<GetAllVehiclesDTO> getAllVehicles(Long id) {
        return customerRepository.findById(id)
                .map(customer -> vehicleRepository.findAllByCustomerId(customer).get())
                .orElse(List.of())
                .stream()
                .map(GetAllVehiclesDTO::toDto)
                .collect(Collectors.toList());
    }

    private Boolean existsByCpf(String cpf) {
        return customerRepository.findByCpf(cpf).isPresent();
    }
}
