package utilities;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Random;

public class Utilities {

    public static String getCurrentUser() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.isAuthenticated()) {
            return authentication.getName();
        } else {
            return "No user authenticated";
        }
    }

    public static String generateRandomID() {
        // Create a Random object
        Random random = new Random();

        // Generate a random integer between 1000 and 9999 (inclusive)
        int randomIDInt = random.nextInt(9000) + 1000;

        // Convert the integer to a string
        String randomID = Integer.toString(randomIDInt);

        return randomID;
    }

}
