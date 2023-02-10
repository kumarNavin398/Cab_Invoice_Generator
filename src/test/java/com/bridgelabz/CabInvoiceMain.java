package com.bridgelabz;

public class CabInvoiceMain {
    private static final int COST_PER_TIME=1;
    private static final double MIN_COST_PER_KM=10;
    private static final double MIN_FARE=5;
    public double calculateFare(double distance, int time) {
        double totalFare = distance * MIN_COST_PER_KM + time * COST_PER_TIME;
        return Math.max(totalFare, MIN_FARE);
    }

    public double calculateFare(Ride[] ride1){
        double  totalFare=0;
        for (Ride ride:ride1){
            totalFare+=this.calculateFare(ride.distance, ride.time);
        }
        return totalFare;
    }
}
