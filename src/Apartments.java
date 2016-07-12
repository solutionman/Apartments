
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

        int apartmentsOnFloor = 4;
        int apartments = entrances * floors * apartmentsOnFloor;

        System.out.println();
        System.out.printf("Well, this building contains %d  entrances  %d floors  and %d apartments", entrances, floors, apartments);

        System.out.println();
        int amountOfApartments = floors * apartmentsOnFloor;
        int numbersOfApartments = 1;

        for (int i = 1; i <= entrances; i++) {
            System.out.printf("Apartments in %2d entrance  %3d", i, numbersOfApartments);   // %2d  two signs always
            numbersOfApartments = (numbersOfApartments + amountOfApartments);
            System.out.println(" - " + (numbersOfApartments - 1));
        }

        System.out.println();
        System.out.print("Please enter the number of apartment ");
        int apartmentToSearch = userInput.nextInt();

        if (apartmentToSearch > apartments || apartmentToSearch < 1) {
            System.out.println("In this building no such apartment.");
            return;
        }

        int yourEntrance = 0;
        for (int i = 1; i <= apartmentToSearch; i = i + amountOfApartments) {
            yourEntrance = yourEntrance + 1;
        }

        System.out.print("Your entrance is " + yourEntrance);

        int apartmentsInPreviousEntrances = (yourEntrance - 1) * floors * apartmentsOnFloor;
        int apartmentsInYourEntrance = apartmentToSearch - apartmentsInPreviousEntrances;
        int beforeYourFloor = apartmentsInYourEntrance / apartmentsOnFloor;
        int checkYourFloor = apartmentsInYourEntrance % apartmentsOnFloor;
        if (checkYourFloor == 0) {
            System.out.printf(" and your floor is %d %nYour apartment is closest to right", beforeYourFloor);   // %n - next line in printf
            return;
        }
        System.out.println(" and your floor is " + (beforeYourFloor + 1));

        int apartmentsBeforeYourFloor = beforeYourFloor * apartmentsOnFloor;
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