package br.com.marcosprado.customerservice.service;

import br.com.marcosprado.customerservice.domain.Vehicle.Vehicle;
import br.com.marcosprado.customerservice.dtos.CreateVehicleDTO;
import br.com.marcosprado.customerservice.repository.CustomerRepository;
import br.com.marcosprado.customerservice.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VehicleService {
    private final VehicleRepository vehicleRepository;
    private final CustomerRepository customerRepository;

    VehicleService(VehicleRepository vehicleRepository, CustomerRepository customerRepository) {
        this.vehicleRepository = vehicleRepository;
        this.customerRepository = customerRepository;
    }

    public Vehicle create(CreateVehicleDTO createVehicleDTO) {
        String licensePlate = createVehicleDTO.licensePlate();
        Long customerId = createVehicleDTO.customerId();

        if (findVehicleByLicensePlate(licensePlate).isPresent()) {
            throw new RuntimeException("Vehicle already registered with plate " + licensePlate);
        }

        if (!customerRepository.existsById(customerId)) {
            throw new RuntimeException("Customer with ID " + customerId + " not found");
        }

        Vehicle vehicle = createVehicleDTO.toVehicle();
        vehicle.setCustomerId(customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer with ID " + customerId + " not found")));

        return vehicleRepository.save(vehicle);
    }

    private Optional<Vehicle> findVehicleByLicensePlate(String licensePlate) {
        return vehicleRepository.findByLicensePlate(licensePlate);
    }
}

