package Utilities.Helper;

import java.util.Random;

public class generateValidCredentials {
    public static String generateValidID(String prefix) {
        if (!prefix.matches("^[0-9]{2}$")) {
            throw new IllegalArgumentException("Prefix must be exactly two numeric digits.");
        }

        Random random = new Random();
        String id;

        while (true) {
            id = prefix + String.format("%08d", random.nextInt(100000000)); // Ensure 10-digit ID
            if (isValidID(id)) {
                return id;
            }
        }
    }


    private static boolean isValidID(String id) {
        int sum = 0;
        for (int i = 0; i < id.length(); i++) {
            int num = Character.digit(id.charAt(i), 10);
            // Apply the Luhn algorithm (or similar)
            if (i % 2 == 0) { // Double the value of digits in even positions
                int doubled = num * 2;
                sum += doubled / 10 + doubled % 10; // Add both digits of the result
            } else {
                sum += num;
            }
        }
        return sum % 10 == 0; // Valid if the sum modulo 10 is zero
    }


    public static String generatePhoneNumber() {
        Random random = new Random();
        StringBuilder phoneNumber = new StringBuilder("5"); // Start with 5

        for (int i = 0; i < 8; i++) { // Generate 8 more digits (total = 9)
            phoneNumber.append(random.nextInt(10)); // Append a random digit (0-9)
        }

        return phoneNumber.toString();
    }


}
