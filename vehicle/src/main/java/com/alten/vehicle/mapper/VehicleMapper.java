package com.alten.vehicle.mapper;

import com.alten.vehicle.dto.VehicleDTO;
import com.alten.vehicle.model.Vehicle;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class VehicleMapper {

    private final ModelMapper modelMapper;

    public VehicleDTO convertToDto(Vehicle vehicle) {
        return modelMapper.map(vehicle, VehicleDTO.class);
    }

    public Vehicle convertToEntity(VehicleDTO vehicleDto) {
        return modelMapper.map(vehicleDto, Vehicle.class);
    }
}
