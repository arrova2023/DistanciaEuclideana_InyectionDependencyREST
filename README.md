# Euclidean Distance RESTful API with Dependency Injection

This project implements a RESTful service in Spring Boot to calculate the Euclidean distance between two points on a plane. Use dependency injection and error handling to provide a reliable and efficient user experience.

In mathematics, the Euclidean distance between two points in Euclidean space is the length of a line segment between the two points. It can be calculated from the Cartesian coordinates of the points using the Pythagorean theorem, therefore occasionally being called the Pythagorean distance. These names come from the ancient Greek mathematicians Euclid and Pythagoras, although Euclid did not represent distances as numbers, and the connection from the Pythagorean theorem to distance calculation was not made until the 18th century.

The distance between two objects that are not points is usually defined to be the smallest distance among pairs of points from the two objects. Formulas are known for computing distances between different types of objects, such as the distance from a point to a line. In advanced mathematics, the concept of distance has been generalized to abstract metric spaces, and other distances than Euclidean have been studied. In some applications in statistics and optimization, the square of the Euclidean distance is used instead of the distance itself.

The Euclidean distance in two dimensions is a measure of the length between two points on a Cartesian plane. Imagine you have a plane with two perpendicular axes: the horizontal axis (called the "x" axis) and the vertical axis (called the "y" axis). Each point in this plane can be represented by an ordered pair of coordinates (x, y), where "x" is the position on the horizontal axis and "y" is the position on the vertical axis.

The formula to calculate the Euclidean distance between two points P(x1, y1) and Q(x2, y2) on a Cartesian plane is as follows:

distance = √((x2 - x1)^2 + (y2 - y1)^2)

Let's break down this formula step by step:

Coordinate subtraction: First, we calculate the difference between the "x" coordinates of the two points (x2 - x1) and the difference between the "y" coordinates (y2 - y1).

Squaring: We then square these differences. This ensures that the differences are positive, since a negative number squared becomes positive.

Sum of squares: We add the differences raised to the square of the coordinates "x" and "y".

Square root: Finally, we take the square root of the sum of squares. This gives us the length of the straight line connecting the two points in the plane. It is the Euclidean distance.

In short, the Euclidean distance in two dimensions measures the length of a straight line between two points on a Cartesian plane. It is a "direct distance" measure that follows the shortest path between points. It is used in various fields such as mathematics, physics, data analysis, and geometry to measure the separation between points in two-dimensional space.

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
     - `Accept`: `application/json`

5. In the "Body" tab, select "Raw" and choose "JSON (application/json)" as the content type.

6. Enter a sample JSON request body, for example:
     ```json
     {
         "x1": 1,
         "y1": 2,
         "x2": 4,
         "y2": 6
     }