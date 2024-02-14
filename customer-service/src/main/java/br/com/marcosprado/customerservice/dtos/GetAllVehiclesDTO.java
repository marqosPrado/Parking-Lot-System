package br.com.marcosprado.customerservice.dtos;

import br.com.marcosprado.customerservice.domain.Vehicle.Vehicle;
import br.com.marcosprado.customerservice.enums.VehicleType;

import java.time.Year;

public record GetAllVehiclesDTO(VehicleType vehicleType, String brand, String model, Year releaseYear, String color,
                                String licensePlate) {

    public static GetAllVehiclesDTO toDto(Vehicle vehicle) {
        return new GetAllVehiclesDTO(
                vehicle.getType(),
                vehicle.getBrand(),
                vehicle.getModel(),
                vehicle.getReleaseYear(),
                vehicle.getColor(),
                vehicle.getLicensePlate()
        );
    }
}
