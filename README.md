Please run following command for running the project:

* ```./mvnw spring-boot:run```

* open ```localhost:8080/graphiql```

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