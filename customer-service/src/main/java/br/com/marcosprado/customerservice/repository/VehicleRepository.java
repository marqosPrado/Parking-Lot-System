package br.com.marcosprado.customerservice.repository;

import br.com.marcosprado.customerservice.domain.Vehicle.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}
