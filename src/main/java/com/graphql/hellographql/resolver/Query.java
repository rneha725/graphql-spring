package com.graphql.hellographql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.graphql.hellographql.dao.entity.Vehicle;
import com.graphql.hellographql.dao.entity.VehicleType;
import com.graphql.hellographql.dao.repository.VehicleRepository;
import com.graphql.hellographql.dao.repository.VehicleTypeRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class Query implements GraphQLQueryResolver {
    private VehicleRepository vehicleRepository;
    private VehicleTypeRepository vehicleTypeRepository;

    public Query(VehicleRepository vehicleRepository, VehicleTypeRepository vehicleTypeRepository) {
        this.vehicleRepository = vehicleRepository;
        this.vehicleTypeRepository = vehicleTypeRepository;
    }

    @Transactional(readOnly = true)
    public List<Vehicle> getVehicles(final int count) {
        return this.vehicleRepository.findAll().stream().limit(count).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Optional<Vehicle> getVehicle(final int id) {
        return this.vehicleRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public List<VehicleType> getVehicleTypes() {
        return this.vehicleTypeRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<VehicleType> getVehicleType(final int id) {
        return this.vehicleTypeRepository.findById(id);
    }
}
