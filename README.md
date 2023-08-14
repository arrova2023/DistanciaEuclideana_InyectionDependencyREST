# Euclidean Distance RESTful API with Dependency Injection

This project implements a RESTful service in Spring Boot to calculate the Euclidean distance between two points on a plane. Use dependency injection and error handling to provide a reliable and efficient user experience.

## Design patterns

### Dependency Injection

The dependency injection pattern is used to achieve low maintenance between system components. The different components, such as the controller, the service, and the distance calculator, are injected where needed.

In the `DistanceController` class, the `DistanceService` dependency is injected via the `@Autowired` annotation.

In the `DistanceService` class, the dependency on `EuclideanDistanceCalculator` is injected via the `@Autowired` annotation.

### Controller Pattern

The controller pattern is applied to handle incoming HTTP requests and direct them to the corresponding service for processing. This maintains a clear separation between the presentation layer and the business logic.

The `DistanceController` class acts as the controller in this pattern. Define request routes, handle inputs, and direct requests to the appropriate service.

### Service Pattern

The service pattern is used to encapsulate business logic and provide a consistent interface for interacting with that logic. The services act as intermediaries between the controller and other layers of the system.

In the `DistanceService` class, the service pattern is implemented. Contains the logic for calculating the Euclidean distance and acts as a bridge between the controller and the distance calculator.

### Error Handling

Robust error handling is implemented using Spring's exception handling annotations. This ensures that error responses are consistent and useful to API clients.

The `DistanceController` class uses the `@ExceptionHandler` annotation to catch and handle exceptions, and returns detailed error responses using the `ApiError` class.

## Directory structure
```
origin/
└── main/
      └──java/
          └──com/
              └── example/
                  └── demo/
                      ├── controller/
                      │ └── Distance controller.java
                      ├── service/
                      │ ├── DistanceService.java
                      │ └── Euclidean Distance Calculator.java
                      ├── model/
                      │ ├── Point.java
                      │ ├── DistanceRequest.java
                      │ └── DistanceResponse.java
                      ├── error/
                      │ └── ApiError.java
                      └── EuclideanDistanceSingletonApplication.java
```

## How to test with Postman

1. Make sure the project is running.

2. Open Postman and create a new POST request.

3. Set the request URL to `http://localhost:8080/calculate-distances`.

4. Make sure the headers are set correctly:
     - `Content-type`: `application/json`
     - `OK`: `application/json`

5. In the "Body" tab, select "Raw" and choose "JSON (application/json)" as the content type.

6. Enter a sample JSON request body, for example:
     ```json
     {
         "x1": 1,
         "y1": 2,
         "x2": 4,
         "y2": 6
     }