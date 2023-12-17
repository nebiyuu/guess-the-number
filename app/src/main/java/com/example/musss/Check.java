package com.example.musss;

public class Check {
    public static int[] answer(int[] result, int[] array) {
        int order = 0, unorder = 0;

        // Arrays to keep track of matched indices to avoid duplicate matching
        boolean[] resultMatched = new boolean[4];
        boolean[] arrayMatched = new boolean[4];

        // Check for ordered numbers
        for (int i = 0; i < 4; i++) {
            if (result[i] == array[i]) {
                order++;
            }
        }

        // Check for unordered matches
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (result[i] == array[j] && result[i] != array[i]) {
                    unorder++;
                    break;
                }
            }
        }

        // Return ordered and unordered counts
        return new int[]{order, unorder};
    }
}
