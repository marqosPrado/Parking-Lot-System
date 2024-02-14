package br.com.marcosprado.customerservice.controller;

import br.com.marcosprado.customerservice.domain.Customer.Customer;
import br.com.marcosprado.customerservice.domain.Vehicle.Vehicle;
import br.com.marcosprado.customerservice.dtos.CreateCustomerDTO;
import br.com.marcosprado.customerservice.dtos.GetAllVehiclesDTO;
import br.com.marcosprado.customerservice.service.CustomerService;
import jakarta.websocket.server.PathParam;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    private final CustomerService customerService;

    CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/create")
    public ResponseEntity<Customer> create(@RequestBody CreateCustomerDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.create(dto));
    }

    @GetMapping("/details")
    public ResponseEntity<Customer> getCustomer(@RequestParam String cpf) {
        return ResponseEntity.status(HttpStatus.FOUND).body(customerService.getCustomer(cpf));
    }

    @GetMapping("/vehicles/get")
    public ResponseEntity<List<GetAllVehiclesDTO>> getAllVehicles(@RequestParam Long id) {
        return ResponseEntity.status(HttpStatus.FOUND).body(customerService.getAllVehicles(id));
    }
}
