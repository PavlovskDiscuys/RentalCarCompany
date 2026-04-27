import java.util.*;

public class RentalCarCalculatorApp {
    public static void main(String[] args) {
        // set up scanner
        Scanner input = new Scanner(System.in);

        //prompt user
        /*
        a. pickup date (store as a string)
        b. number of days for the rental
        c. whether they want an electronic toll tag at $3.95/day (yes/no)
        d. whether they want a GPS at $2.95/day (yes/no)
        e. whether they want roadside assistance at $3.95/day (yes/no)
        f. their current age
         */

        final double price = 29.99;
        final double surchargeRate = 0.3;
        final double tollTagAmount = 3.95;
        final double gpsPerDay = 2.95;
        final double roadPerDay = 3.95;

        System.out.println("What day would you like for pick-up?: ");
        String pickupDate = input.nextLine();

        System.out.println("What is your age?: ");
        int age = input.nextInt();

        System.out.println("How many days are you renting?: ");
        int rentalDay = input.nextInt();

        input.nextLine();

        double surchargePerDay = (age < 25) ? price * surchargeRate : 0.0;

        // toll tag
        System.out.println("Do you want a electronic toll tag at $3.95/day (yes/no)?: ");
        String tollTagInput = input.nextLine().toLowerCase();
        double tollTagCost = (tollTagInput.equals("y") || tollTagInput.equals("yes")) ? rentalDay * tollTagAmount : 0.0;

        //GPS
        System.out.println("Would you like GPS? (yes/no): ");
        String gpsInput = input.nextLine().toLowerCase();
        double gpsCost = (gpsInput.equals("y") || gpsInput.equals("yes")) ? rentalDay * gpsPerDay : 0.0;

        //roadside assistance
        System.out.println("Would you like roadside assistance $3.95/day (yes/no)?: ");
        String roadInput = input.nextLine().toLowerCase();
        double roadCost = (roadInput.equals("y") || roadInput.equals("yes")) ? rentalDay * roadPerDay : 0.0;

        double baseRental = rentalDay * price;
        double totalSurcharge = rentalDay * surchargePerDay;
        double optionsCost = tollTagCost + gpsCost + roadCost;
        double totalCost = baseRental + totalSurcharge + tollTagCost + gpsCost + roadCost;

        System.out.printf("Base rental: $%.2f%n", baseRental);
        System.out.printf("Young driver surcharge: $%.2f%n", totalSurcharge);
        System.out.printf("Options cost: $%.2f%n", optionsCost);
        System.out.printf("Total cost: $%.2f%n", totalCost);

        input.close();

    }
}
