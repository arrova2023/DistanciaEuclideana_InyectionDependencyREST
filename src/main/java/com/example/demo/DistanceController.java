package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DistanceController {
    private final DistanceService distanceService;

    @Autowired
    public DistanceController(DistanceService distanceService) {
        this.distanceService = distanceService;
    }

    @PostMapping(value = "/calcule-distances", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> calculateDistance(@RequestBody DistanceRequest distanceRequest) {
        Point point1 = new Point(distanceRequest.getX1(), distanceRequest.getY1());
        Point point2 = new Point(distanceRequest.getX2(), distanceRequest.getY2());

        if (point1.getX() < 0 || point1.getY() < 0 || point2.getX() < 0 || point2.getY() < 0) {
            return ResponseEntity.badRequest().body(new ApiError(HttpStatus.BAD_REQUEST.value(), "Bad Request", "Coordinates must be non-negative"));
        }

        double distance = distanceService.calculateDistance(point1, point2);
        return ResponseEntity.ok(new DistanceResponse(distance));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ApiError> handleIllegalArgumentException(IllegalArgumentException ex) {
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST.value(), "Bad Request", ex.getMessage());
        return ResponseEntity.badRequest().body(apiError);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ApiError> handleException(Exception ex) {
        ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Internal Server Error", ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiError);
    }
}
