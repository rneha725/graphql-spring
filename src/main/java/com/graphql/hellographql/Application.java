package com.graphql.hellographql;

import com.graphql.hellographql.dao.entity.VehicleType;
import com.graphql.hellographql.dao.repository.VehicleRepository;
import com.graphql.hellographql.dao.repository.VehicleTypeRepository;
import com.graphql.hellographql.resolver.Mutation;
import com.graphql.hellographql.resolver.Query;
import com.graphql.hellographql.resolver.VehicleResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public VehicleResolver vehicleTypeResolver(VehicleTypeRepository vehicleTypeRepository) {
		return new VehicleResolver(vehicleTypeRepository);
	}

	@Bean
	public Query query(VehicleRepository vehicleRepository, VehicleTypeRepository vehicleTypeRepository) {
		return new Query(vehicleRepository, vehicleTypeRepository);
	}

	@Bean
	public Mutation mutation(VehicleRepository vehicleRepository, VehicleTypeRepository vehicleTypeRepository) {
		return new Mutation(vehicleRepository, vehicleTypeRepository);
	}
}
