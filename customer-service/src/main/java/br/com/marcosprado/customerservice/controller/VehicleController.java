package br.com.marcosprado.customerservice.controller;

import br.com.marcosprado.customerservice.domain.Vehicle.Vehicle;
import br.com.marcosprado.customerservice.dtos.CreateVehicleDTO;
import br.com.marcosprado.customerservice.service.VehicleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vehicle")
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping("/create")
    public ResponseEntity<Vehicle> create(@RequestBody CreateVehicleDTO vehicleDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(vehicleService.create(vehicleDto));
    }
}
