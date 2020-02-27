package com.graphql.hellographql.dao.repository;

import com.graphql.hellographql.dao.entity.VehicleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleTypeRepository extends JpaRepository<VehicleType, Integer> {
}
