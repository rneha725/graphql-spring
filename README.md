Please run following command for running the project:

* ```./mvnw spring-boot:run```

* open ```localhost:8080/graphiql```

* Mutations:

```
mutation {
  createVehicle(typeId:0, modelCode: "No Idea", brandName:"BMW", launchDate:"2016-08-16") {
    id
  }
}

mutation {
  createVehicleType(id:1, typeName:"1 tyre") {
    id
    typeName
  }
}
```

* Queries:
```
query {
  vehicles(count: 10) {
    modelCode
    typeId {
      typeName
    }
  } 
}

query {
  vehicleTypes {
    id
    typeName
    
  }
}

```
* Checkout 1046ee66b1604506819e9b09c9bf87bc2a0ccad4
Following are the queries:

* For writing: 
```
mutation {
  createVehicle(type: "car", modelCode: "XYZ0192", brandName: "XYZ", launchDate: "2016-08-16") 
  {
    id
  }
}
```

* For reading 
```
query {
  vehicles(count: 1) 
  {
    id, 
    type, 
    modelCode
  }
}
```