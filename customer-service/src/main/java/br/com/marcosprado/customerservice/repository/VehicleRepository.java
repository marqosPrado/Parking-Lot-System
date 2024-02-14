package br.com.marcosprado.customerservice.repository;

import br.com.marcosprado.customerservice.domain.Customer.Customer;
import br.com.marcosprado.customerservice.domain.Vehicle.Vehicle;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    Optional<Vehicle> findByLicensePlate(String licensePlate);
    Optional<List<Vehicle>> findAllByCustomerId(Customer customer);
}
