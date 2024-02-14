package ui;

import models.Pterosaur;

import models.Sauropod;

import models.Theropod;

import utilities.FoodType;

import java.util.Scanner;

public class Main {
    private static void printPterosaurStats(Pterosaur pterosaur) {
        System.out.printf("Altitude: %.2f km%nSpeed: %.2f km/h%nEnergy: %d%n",
                pterosaur.getAltitude(), pterosaur.getSpeed(), pterosaur.getEnergy());
    }

    private static void pterosaur(Scanner scanner) {
        Pterosaur pterosaur = new Pterosaur("Quetzalcoatlus", false, true, false, 11.0);
        loop:
        while (true) {
            System.out.println("\nChoose action\n1. Info\n2. Fly\n3. Stoop\n4. Forage\n5. Land\n6. Exit");
            String answer = scanner.nextLine();

            switch (answer) {
                case "1":
                    System.out.println(pterosaur);
                    break;
                case "2":
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

                case "3":
                    if (pterosaur.getAltitude() <= 0) {
                        System.out.println("You have to be in the air to stoop");
                        printPterosaurStats(pterosaur);
                    } else {
                        pterosaur.stoop(FoodType.MEAT);
                        System.out.println("*Pterosaur catches it's prey*");
                        printPterosaurStats(pterosaur);
                    }
                    break;

                case "4":
                    if (pterosaur.getAltitude() <= 0) {
                        System.out.println("You have to be in the air to forage.");
                    } else {
                        System.out.println("Forage for carrion or fruit:\n1. Carrion\n2. Fruit");
                        String food = scanner.nextLine();

                        if (food.equals("1")) {

                            System.out.println("*Pterosaur lands and eats carrion after searching from the air*");
                            pterosaur.foraging(FoodType.MEAT);
                            printPterosaurStats(pterosaur);
                        } else if (food.equals("2")) {

                            System.out.println("*Pterosaur lands and eats fruit after searching from the air*");
                            pterosaur.foraging(FoodType.PLANT);
                            printPterosaurStats(pterosaur);
                        }
                    }
                    break;

                case "5":
                    if (pterosaur.getAltitude() <= 0) {

                        System.out.println("Already on the ground");
                        printPterosaurStats(pterosaur);
                    } else {

                        pterosaur.land();
                        System.out.println("*The Pterosaur lands on the ground*");
                        printPterosaurStats(pterosaur);
                    }
                    break;

                case "6":
                    System.out.println("Thanks for playing.");
                    break loop;
            }
        }
    }

    private static void sauropod(Scanner scanner) {

        Sauropod sauro = new Sauropod("Diplodocus", true, false, false, 20, 0, 35);
        sauro.setEnergy(50);
        while (true) {
            while (true) {
                System.out.println("\nWhat do you want it to do?\n1. Info\n2. Walk\n3. Eat\n4. Sleep\n5. Exit");
                int answer = scanner.nextInt();

                switch (answer) {
                    case 1:
                        System.out.println("This is the Diplodocus: \n" + sauro);
                        break;
                    case 2:
                        System.out.println("You selected Walk");

                        double previousWalkSpeed = sauro.getWalkingSpeed();
                        double previousEnergy = sauro.getEnergy();
                        sauro.walk();
                        double newWalkSpeed = sauro.getWalkingSpeed();
                        double newEnergy = sauro.getEnergy();
                        System.out.printf("\nBefore walking, its walk speed was %.2f km/h and its previous energy was %.2f", previousWalkSpeed, previousEnergy);
                        System.out.printf("\nNow, its current walking speed is %.2f km/h and its current energy is %.2f\n ", newWalkSpeed, newEnergy);
                        break;
                    case 3:
                        System.out.println("You selected Eat");
                        while (true) {
                            System.out.printf("What do you want it to eat?\n1. Meat\n2. Plant\n");

                            int eatAnswer = scanner.nextInt();

                            switch (eatAnswer) {
                                case 1:
                                    System.out.println("You chose Meat");
                                    previousEnergy = sauro.getEnergy();
                                    sauro.eat(FoodType.MEAT);
                                    newEnergy = sauro.getEnergy();

                                    System.out.printf("\nIts previous energy was %.2f\n" +
                                            "After eating meat, its energy is %.2f\n", previousEnergy, newEnergy);

                                    break;
                                case 2:
                                    System.out.println("You chose Plant");
                                    previousEnergy = sauro.getEnergy();
                                    sauro.eat(FoodType.PLANT);
                                    newEnergy = sauro.getEnergy();

                                    System.out.printf("\nIts previous energy was %.2f\n" +
                                            "After eating plant, its energy is %.2f\n", previousEnergy, newEnergy);
                                    break;
                                default:
                                    System.out.printf("Invalid answer\n");
                                    continue;
                            }
                            break;
                        }
                        break;


                    case 4:
                        System.out.println("You selected Sleep");

                        System.out.println("How many hours do you want it to sleep?");
                        int sleepAnswer = scanner.nextInt();
                        previousEnergy = sauro.getEnergy();
                        sauro.sleep(sleepAnswer);
                        newEnergy = sauro.getEnergy();

                        System.out.printf("\nIts previous energy was %.2f\n" +
                                "After sleeping for %d hours, its energy is %.2f\n", previousEnergy, sleepAnswer, newEnergy);
                        break;
                    case 5:
                        System.out.println("Exiting");
                        return;
                    default:
                        System.out.println("Invalid answer");
                        break;


                }

            }
        }
    }

    private static void theropod(Scanner scanner) {
        Theropod theropod = new Theropod("Tyrannosaurus", false, true, false, 8);
        theropod.setEnergy(80);

        while (true) {
            System.out.println("\nChoose action\n1. Info\n2. Hunt\n3. Eat\n4. Sleep\n5. Exit");
            String answer = scanner.nextLine();

            switch (answer) {
                case "1":
                    System.out.println(theropod);
                    break;
                case "2":
                    theropod.hunt();
                    break;
                case "3":
                    theropod.eat(FoodType.MEAT);
                    System.out.println("The Theropod feasts on meat.");
                    break;
                case "4":
                    System.out.println("How many hours does the Theropod want to sleep?");
                    int hours = scanner.nextInt();
                    theropod.sleep(hours);
                    System.out.println("The Theropod sleeps deeply.");
                    break;
                case "5":
                    System.out.println("Exiting Theropod simulation.");
                    return;
                default:
                    System.out.println("Invalid option. Please choose again.");
                    break;
            }
        }
    }


    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {

            System.out.println("Select dinosaur: \n1. Pterosaur\n2. Sauropod\n3. Theropod");
            String answer = scanner.nextLine();

            switch (answer) {
                case "1" -> pterosaur(scanner);
                case "2" -> sauropod(scanner);
                case "3" -> theropod(scanner);
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
