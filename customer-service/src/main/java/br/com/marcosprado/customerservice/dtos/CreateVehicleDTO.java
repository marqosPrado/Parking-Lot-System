package br.com.marcosprado.customerservice.dtos;

import br.com.marcosprado.customerservice.domain.Vehicle.Vehicle;
import br.com.marcosprado.customerservice.enums.VehicleType;

import java.time.Year;


public record CreateVehicleDTO(
        Long customerId,
        VehicleType vehicleType,
        String brand,
        String model,
        Year year,
        String color,
        String licensePlate
) {

    public Vehicle toVehicle() {
        return new Vehicle(
                vehicleType,
                brand,
                model,
                year,
                color,
                licensePlate
        );
    }
}
