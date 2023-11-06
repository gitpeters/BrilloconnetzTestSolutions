package com.peters.shopkeeper;

import java.util.Random;

public class NonConcurrent {

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        long endTimeMillis = startTimeMillis + 30000; // 30 seconds

        int totalPancakesMade = 0;
        int totalPancakesEaten = 0;
        int totalUsersServed = 0;
        int totalPancakesWasted = 0;
        int remainingPancakes = 0;

        long startTimeSeconds = startTimeMillis / 1000;
        long endTimeSeconds = endTimeMillis / 1000;
        int startSeconds = (int) (startTimeSeconds % 60);
        int endSeconds = (int) (endTimeSeconds % 60);

        System.out.println("Starting time: " + startSeconds + " seconds");
        System.out.println("Ending time: " + endSeconds + " seconds");

        while (System.currentTimeMillis() < endTimeMillis) {
            int pancakesMade = new ShopKeeper().makePancakes();
            totalPancakesMade += pancakesMade;

            int user1Pancakes = new User().eatPancakes();
            int user2Pancakes = new User().eatPancakes();
            int user3Pancakes = new User().eatPancakes();
            int totalPancakesEatenInSlot = user1Pancakes + user2Pancakes + user3Pancakes;
            int pancakesToServe = Math.min(pancakesMade, Math.min(totalPancakesEatenInSlot, 15)); // Maximum 15 pancakes in total (5 per user)

            totalUsersServed++;
            remainingPancakes += (pancakesMade - pancakesToServe);
            totalPancakesWasted += (pancakesMade - pancakesToServe);
            totalPancakesEaten += pancakesToServe;
        }

        System.out.println("Total Pancakes Made: " + totalPancakesMade);
        System.out.println("Total Pancakes Eaten: " + totalPancakesEaten);
        System.out.println("Total Users Served: " + totalUsersServed);
        System.out.println("Total Pancakes Wasted: " + totalPancakesWasted);
        System.out.println("Remaining Pancakes: " + remainingPancakes);
    }
}
