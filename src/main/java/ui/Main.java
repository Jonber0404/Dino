package ui;

import models.Sauropod;
import utilities.FoodType;

import java.util.Scanner;

public class Main {
    private static void pterosaur() {}
    private static void sauropod(Scanner scanner) {

        Sauropod sauro = new Sauropod("Diplodocus", true, false, false, 20, 0, 35);
        sauro.setEnergy(50);
        while(true) {
            while(true) {
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
    private static void theropod() {}

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {

            System.out.println("Select dinosaur: \n1. Pterosaur\n2. Sauropod\n3. Theropod");
            String answer = scanner.nextLine();

            switch (answer) {
                case "1" -> pterosaur();
                case "2" -> sauropod(scanner);
                case "3" -> theropod();
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
