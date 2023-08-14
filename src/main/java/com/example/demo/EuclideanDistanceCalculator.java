package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class EuclideanDistanceCalculator {
    public double calculateDistance(Point point1, Point point2) {
        double deltaX = point2.getX() - point1.getX();
        double deltaY = point2.getY() - point1.getY();
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }
}
