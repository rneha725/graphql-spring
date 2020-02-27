package com.graphql.hellographql.dao.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@EqualsAndHashCode
@Entity
public class VehicleType {

    @Id
    @Column(name = "ID", nullable = false)
    private int id;


    @Column(name = "type_name", nullable = false)
    private String typeName;

    public VehicleType(Integer id) {
        this.id = id;
    }

    public VehicleType() {}
}
