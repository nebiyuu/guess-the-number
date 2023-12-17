package com.example.musss;

import java.util.Random;

public class Generator {
    public static int[] gen() {
        Random random = new Random();
        int numberOfUniqueNumbers = 4;
        int[] uniqueNumbers = new int[numberOfUniqueNumbers];
        int currentIndex = 0;

        while (currentIndex < numberOfUniqueNumbers) {
            int randomNumber = random.nextInt(10);

            // Check if the number is already in the array
            boolean isDuplicate = false;
            for (int i = 0; i < currentIndex; i++) {
                if (uniqueNumbers[i] == randomNumber) {
                    isDuplicate = true;
                    break;
                }
            }

            // If the number is not a duplicate, add it to the array
            if (!isDuplicate) {
                uniqueNumbers[currentIndex] = randomNumber;
                currentIndex++;

            }
        }
        return uniqueNumbers;
    }
}