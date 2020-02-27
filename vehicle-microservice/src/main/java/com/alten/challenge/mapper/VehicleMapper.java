package com.alten.challenge.mapper;

import com.alten.challenge.dto.VehicleDTO;
import com.alten.challenge.model.Vehicle;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VehicleMapper {
    @Autowired
    private ModelMapper modelMapper;

    public VehicleDTO convertToDto(Vehicle vehicle) {
        return modelMapper.map(vehicle, VehicleDTO.class);
    }

    public Vehicle convertToEntity(VehicleDTO vehicleDto) {
        return modelMapper.map(vehicleDto, Vehicle.class);
    }
}
