package week01.method;

import java.util.Scanner;

public class OtpGenrator {

    //6-digit OTP using Math.random()
    public static int generateOTP() {
        return (int) (Math.random() * 900000) + 100000;
    }

    // Method to check if all OTPs are unique
    public static boolean oTPsUnique(int[] otps) {
        for (int i = 0; i < otps.length; i++) {
            for (int j = i + 1; j < otps.length; j++) {
                if (otps[i] == otps[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

        int[] otpArray = new int[10];

        // Generate 10 OTPs
        System.out.println("Generated OTPs:");
        for (int i = 0; i < otpArray.length; i++) {
            otpArray[i] = generateOTP();
            System.out.println("OTP " + (i + 1) + ": " + otpArray[i]);
        }
        boolean isUnique = oTPsUnique(otpArray);
        if (isUnique) {
            System.out.println("All OTPs are unique");
        } else {
            System.out.println("Duplicate OTP found");
        }
    }
}
