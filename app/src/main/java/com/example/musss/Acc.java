package com.example.musss;

import java.util.Scanner;

public class Acc {
    public static int[] accept() {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[4];
        System.out.print("guess the number:");
        //accept four digit number
        int fourDigitNumber = scanner.nextInt();
        // Check if the entered number is four digits
        if (fourDigitNumber >= 1000 && fourDigitNumber <= 9999) {
            // Convert each digit to an element in the array
            for (int i = 3; i >= 0; i--) {
                array[i] = fourDigitNumber % 10;
                fourDigitNumber /= 10;
            }
        }
        else {
            System.out.println("Invalid input. Please enter a four-digit number.");
        }
        return array;
    }
}