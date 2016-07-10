
// Find entrance, floor and position of apartment.

import java.util.Scanner;

public class Apartments {
    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);

        System.out.println("We are about to find the position of apartment.");
        System.out.print("Please enter amount of entrances ");
        int entrances = userInput.nextInt();

        System.out.print("Please enter amount of floors ");
        int floors = userInput.nextInt();

        int apartments = entrances * floors * 4;

        System.out.println("\nWell, this building contains " + entrances + " entrances  " + floors + " floors  and " + apartments + " apartments");

        System.out.print("Please enter the number of apartment ");
        int apartmentToSearch = userInput.nextInt();

        if (apartmentToSearch > apartments || apartmentToSearch < 1) {
            System.out.println("In this building no such apartment.");
            return;
        }

        int amountOfFloors = apartmentToSearch / 4;
        int numberOfEntrance = amountOfFloors / floors;
        System.out.print("your entrance is " + (numberOfEntrance + 1));

        int apartrmentsInPreviousEntrances = numberOfEntrance * floors * 4;
        int apartmentsInYourEntrance = apartmentToSearch - apartrmentsInPreviousEntrances;
        int beforeYourFloor = apartmentsInYourEntrance / 4;
        System.out.println(" and your floor is " + (beforeYourFloor + 1));

        int apartmentsBeforeYourFloor = beforeYourFloor * 4;
        int yourApartment = apartmentsInYourEntrance - apartmentsBeforeYourFloor;
        if (yourApartment == 1) {
            System.out.println("Your apartment is closest to left");
        } else if (yourApartment == 2) {
            System.out.println("Your apartment is far to left");
        } else if (yourApartment == 3) {
            System.out.println("Your apartment is far to the right");
        } else if (yourApartment == 4) {
            System.out.println("Your apartment is closest to the right");
        }
    }
}