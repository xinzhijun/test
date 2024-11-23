package com.wq.leetcode;

import java.util.Arrays;

/**
 * @author cristiano
 * @create 2024/4/24
 */
public class 空调匹数AirConditionerCoverage {
    public static void main(String[] args) {
        int[] roomLocations = {1, 2, 3, 4};
        int[] acLocations = {3}; // Air conditioner locations
        int coverage = 1; // Number of rooms an air conditioner can cover

        int minAirConditioners = getMinAirConditioners(roomLocations, acLocations, coverage);
        System.out.println("Minimum number of air conditioners needed: " + minAirConditioners);

    }

    // Method to calculate the minimum number of air conditioners needed
    public static int getMinAirConditioners(int[] roomLocations, int[] acLocations, int coverage) {
        Arrays.sort(roomLocations);
        Arrays.sort(acLocations);

        int minAirConditioners = 0;
        int currentAC = 0;

        for (int room : roomLocations) {
            // If the current room is not covered by the current air conditioner
            while (currentAC < acLocations.length && Math.abs(room - acLocations[currentAC]) > coverage) {
                // Move to the next air conditioner
                currentAC++;
            }
            if (currentAC >= acLocations.length) {
                minAirConditioners++;
                currentAC--;
            }
        }

        return minAirConditioners + 1; // Add 1 for the last air conditioner
    }


}
