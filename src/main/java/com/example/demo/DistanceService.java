package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DistanceService {
    private final EuclideanDistanceCalculator distanceCalculator;

    @Autowired
    public DistanceService(EuclideanDistanceCalculator distanceCalculator) {
        this.distanceCalculator = distanceCalculator;
    }

    public double calculateDistance(Point point1, Point point2) {
        return distanceCalculator.calculateDistance(point1, point2);
    }
}
