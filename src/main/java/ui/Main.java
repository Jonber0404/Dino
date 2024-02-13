package ui;

import java.util.Scanner;

public class Main {
    private static void pterosaur() {}
    private static void sauropod() {}
    private static void theropod() {}

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {

            System.out.println("Select dinosaur: \n1. Pterosaur\n2. Sauropod\n3. Theropod");
            String answer = scanner.nextLine();

            switch (answer) {
                case "1" -> pterosaur();
                case "2" -> sauropod();
                case "3" -> theropod();
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
