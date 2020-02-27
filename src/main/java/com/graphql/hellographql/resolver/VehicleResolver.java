package com.graphql.hellographql.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.graphql.hellographql.dao.entity.Vehicle;
import com.graphql.hellographql.dao.entity.VehicleType;
import com.graphql.hellographql.dao.repository.VehicleTypeRepository;

public class VehicleResolver implements GraphQLResolver<Vehicle> {
    private VehicleTypeRepository vehicleTypeRepository;

    public VehicleResolver(VehicleTypeRepository vehicleTypeRepository) {
        this.vehicleTypeRepository = vehicleTypeRepository;
    }

    public VehicleType getVehicleType(Vehicle vehicle) {
        return this.vehicleTypeRepository.getOne(vehicle.getTypeId().getId());
    }
}
