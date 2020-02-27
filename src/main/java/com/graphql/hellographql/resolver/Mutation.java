package com.graphql.hellographql.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.graphql.hellographql.dao.entity.Vehicle;
import com.graphql.hellographql.dao.entity.VehicleType;
import com.graphql.hellographql.dao.repository.VehicleRepository;
import com.graphql.hellographql.dao.repository.VehicleTypeRepository;

import java.time.LocalDate;

public class Mutation implements GraphQLMutationResolver {
    private VehicleRepository vehicleRepository;
    private VehicleTypeRepository vehicleTypeRepository;

    public Mutation(VehicleRepository vehicleRepository, VehicleTypeRepository vehicleTypeRepository) {
        this.vehicleRepository = vehicleRepository;
        this.vehicleTypeRepository = vehicleTypeRepository;
    }

    public Vehicle createVehicle(final Integer typeId, final String modelCode, final String brandName,
                                 final String launchDate) {
        Vehicle vehicle = new Vehicle();
        VehicleType vehicleType = vehicleTypeRepository.getOne(typeId);
        vehicle.setTypeId(vehicleType);
        vehicle.setModelCode(modelCode);
        vehicle.setBrandName(brandName);
        vehicle.setLaunchDate(LocalDate.parse(launchDate));
        return this.vehicleRepository.save(vehicle);
    }

    public VehicleType createVehicleType(Integer id, String typeName) {
        VehicleType vehicleType = new VehicleType();
        vehicleType.setId(id);
        vehicleType.setTypeName(typeName);
        return this.vehicleTypeRepository.save(vehicleType);
    }

    public boolean deleteVehicle(Integer id) {
        this.vehicleRepository.deleteById(id);
        return true;
    }
}
