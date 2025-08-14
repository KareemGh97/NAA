package Utilities.commonClasses;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.math.BigInteger;

import java.util.concurrent.ThreadLocalRandom;

import static oracle.sql.ZONEIDMAP.isValidID;

public class Helper {
    public static String randomNumber (String numberToBeGenerated){
        switch (numberToBeGenerated.toLowerCase(Locale.ROOT)) {
            case "nationality" -> {

                Random random = new Random();
                char type = random.nextBoolean() ? '1' : '2';

                while (true) {
                    AppConstants.OnboardNationalID .set(type + String.format("%09d",(int) (Math.random() * 1000000000)));
                    if(isValidID(Integer.parseInt(AppConstants.OnboardNationalID.get()))) {
                        return AppConstants.OnboardNationalID.get();
                    }
                }
            }
            case "phonenumber" -> {
                AppConstants.OnboardMobileNumber.set("5" + ThreadLocalRandom.current().nextInt(10000000,100000000));
                return AppConstants.OnboardMobileNumber.get();
            }
            case "passcode" -> {
                String passcode;
                do {
                    passcode = String.valueOf(ThreadLocalRandom.current().nextInt(100000, 1000000));
                } while (isWeak(passcode));
                AppConstants.Passcode.set(passcode);
                return AppConstants.Passcode.get();
            }
        }
        return "";
    }
    private static boolean isWeak(String code) {
        return code.matches("(\\d)\\1{5}") ||
                code.equals("123456") ||
                code.equals("654321") ||
                code.equals("000000") ||
                hasRepeatingPattern(code);
    }

    private static boolean hasRepeatingPattern(String code) {
        for (int i = 0; i < code.length() - 2; i++) {
            if (code.charAt(i) == code.charAt(i + 1) && code.charAt(i) == code.charAt(i + 2)) {
                return true;
            }
        }
        return false;
    }

    public static void addExtraInfoToDatafile (String info){

        String filePath = "onboardingData/SIT-UI-data.txt";
        try {
            FileWriter fileWriter = new FileWriter(filePath, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("' "+info+" ' ");
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String generateUniqueRandomString(int length) {
        List<Character> keys = new ArrayList<>();
        char[] chars = "RSEDHJKYGFKLMN11QRSTUVWXYZ".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            char c = chars[random.nextInt(chars.length)];
            if (keys.contains(c)) {
                i--;
            } else {
                keys.add(c);
                sb.append(c);
            }
        }
        String randomString = sb.toString();
        return randomString;
    }

    public static String generateUniqueRandomIntegerCharacter(int length) {
        List<Character> keys = new ArrayList<>();
        char[] chars = "1234567890".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            char c = chars[random.nextInt(chars.length)];
            if (keys.contains(c)) {
                i--;
            } else {
                keys.add(c);
                sb.append(c);
            }
        }
        String randomString = sb.toString();
        return randomString;
    }

    public static String generateUniqueRandomIntegerCharacter(int length, long maxVal) {
        if (maxVal <= 0) {
            throw new IllegalArgumentException("maxVal must be positive");
        }

        String maxStr = Long.toString(maxVal);

        length = Math.min(length, 10); // Max 10 unique digits (0-9)
        length = Math.min(length, maxStr.length());

        BigInteger minPossibleValue = BigInteger.TEN.pow(length - 1);
        if (BigInteger.valueOf(maxVal).compareTo(minPossibleValue) < 0) {
            throw new IllegalArgumentException("Impossible to generate a number with the given length and maxVal");
        }

        int maxAttempts = 100;
        int attempts = 0;

        List<Character> digits = new ArrayList<>();
        for (char c = '0'; c <= '9'; c++) {
            digits.add(c);
        }

        Random random = new Random();

        while (attempts < maxAttempts) {
            Collections.shuffle(digits, random);

            StringBuilder sb = new StringBuilder();
            for (char c : digits) {
                if (sb.length() == 0 && c == '0') {
                    continue;
                }
                sb.append(c);
                if (sb.length() == length) {
                    break;
                }
            }

            if (sb.length() != length) {
                attempts++;
                continue;
            }

            BigInteger number = new BigInteger(sb.toString());

            if (number.compareTo(BigInteger.valueOf(maxVal)) <= 0) {
                return sb.toString();
            }

            attempts++;
        }

        throw new RuntimeException("Unable to generate a valid number after " + maxAttempts + " attempts");
    }

}
