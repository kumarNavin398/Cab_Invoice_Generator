package com.bridgelabz;

import java.util.HashMap;
import java.util.Map;

public class CabInvoiceMain {
    private static final int COST_PER_TIME=1;
    private static final double MIN_COST_PER_KM=10;
    private static final double MIN_FARE=5;

    public double calculateFare(double distance, int time) {
        double totalFare = distance * MIN_COST_PER_KM + time * COST_PER_TIME;
        return Math.max(totalFare, MIN_FARE);
    }

    public InVoiceSummary calculateFare(Ride[] ride1){
        double  totalFare=0;
        for (Ride ride:ride1){
            totalFare+=this.calculateFare(ride.getDistance, ride.getTime);
        }
        return new InVoiceSummary(ride1.length, totalFare);
    }

    public double calculateTotalFare(Ride[] ride1) {
        double totalFare = 0.0;
        for (Ride ride : ride1) {
            totalFare = calculateFare(ride.getDistance(), (int) ride.getTime());
        }
        return totalFare;

    }

    public InVoiceSummary getInvoice(int userId) {
        Map<Integer, Ride[]> map = new HashMap<Integer, Ride[]>();
        Ride[] rides2 = {new Ride(2.0, 5),
                new Ride(0.1, 1)
        };
        Ride[] rides3 = {new Ride(5.0, 10),
                new Ride(1, 1)
        };

        Ride[] rides4 = {new Ride(8.0, 15),
                new Ride(1, 10)
        };
        map.put(1, rides2);
        map.put(2, rides3);
        map.put(3, rides4);

        for (Map.Entry<Integer, Ride[]> entry : map.entrySet()) {
            if (userId == entry.getKey()) {
                System.out.println(entry.getKey());
                Ride[] ridesArray = entry.getValue();
                return calculateFare(ridesArray);
            }
        }
        return null;
    }
}