package ui;

import models.Pterosaur;
import utilities.FoodType;

import java.util.Scanner;

public class Main {
    private static void printPterosaurStats(Pterosaur pterosaur) {
        System.out.printf("Altitude: %.2f km%nSpeed: %.2f km/h%nEnergy: %d%n",
                pterosaur.getAltitude(), pterosaur.getSpeed(), pterosaur.getEnergy());
    }

    private static void pterosaur(Scanner scanner) {
        Pterosaur pterosaur = new Pterosaur("hello", false, true, false, 3.9);
        loop:
        while (true) {
            System.out.println("\nChoose action\n1. Fly\n2. Stoop\n3. Forage\n4. Land\n5. Exit");
            String answer = scanner.nextLine();

            switch (answer) {
                case "1":
                    if (pterosaur.getEnergy() <= 0) {
                        System.out.println("Cannot fly. Energy too low");
                    } else {
                        pterosaur.fly();
                        System.out.println("*Pterosaur flies to the skies*");

                        if (pterosaur.getEnergy() <= 0) {
                            System.out.println("*Pterosaur is forced to land because of low energy*");
                        }
                        printPterosaurStats(pterosaur);
                    }
                    break;

                case "2":
                    if (pterosaur.getAltitude() <= 0) {
                        System.out.println("You have to be in the air to stoop");
                        printPterosaurStats(pterosaur);
                    } else {
                        pterosaur.stoop(FoodType.MEAT);
                        System.out.println("*Pterosaur catches it's prey*");
                        printPterosaurStats(pterosaur);
                    }
                    break;

                case "3":
                    if (pterosaur.getAltitude() <= 0) {
                        System.out.println("You have to be in the air to forage.");
                    } else {
                        System.out.println("Forage for carrion or fruit:\n1. Carrion\n2. Fruit");
                        String food = scanner.nextLine();

                        if (food.equals("1")) {

                            System.out.println("*Pterosaur lands and eats fruit after searching from the air*");
                            pterosaur.foraging(FoodType.MEAT);
                            printPterosaurStats(pterosaur);
                        } else if (food.equals("2")) {

                            System.out.println("*Pterosaur lands and eats carrion after searching from the air*");
                            pterosaur.foraging(FoodType.PLANT);
                            printPterosaurStats(pterosaur);
                        }
                    }
                    break;

                case "4":
                    if (pterosaur.getAltitude() <= 0) {

                        System.out.println("Already on the ground");
                        printPterosaurStats(pterosaur);
                    } else {

                        pterosaur.land();
                        System.out.println("*The Pterosaur lands on the ground*");
                        printPterosaurStats(pterosaur);
                    }
                    break;

                case "5":
                    System.out.println("Thanks for playing.");
                    break loop;
            }
        }
    }

    private static void sauropod() {
    }

    private static void theropod() {
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {

            System.out.println("Select dinosaur: \n1. Pterosaur\n2. Sauropod\n3. Theropod");
            String answer = scanner.nextLine();

            switch (answer) {
                case "1" -> pterosaur(scanner);
                case "2" -> sauropod();
                case "3" -> theropod();
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
