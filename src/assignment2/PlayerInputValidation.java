package assignment2;

import java.util.Scanner;
public class PlayerInputValidation {

    private Scanner scanner = new Scanner(System.in);

    protected PlayerInputValidation(Scanner scanner) {this.scanner = scanner; }

    protected String validateFourDigitInput() {
        boolean isValidInput = false;
        String playerInput = null;

        while (!isValidInput) {
            System.out.print(">> ");
            playerInput = scanner.next();

            // Check if the input contains only digits. exactly 4 digits
            if (!playerInput.matches("\\d+")) {
                System.out.println("Uh-oh! You need to enter a 4-digit number. Give it another shot. \n-------------------");
            }
            // Check if the input contains exactly 4 digits.
            else if (playerInput.length() != 4) {
                System.out.println("Error: Your input must consist of exactly 4 digits. Let's give it another try. \n-------------------");
            }
            // Check if the input has all different digits
            else if (!hasAllDifferentDigits(playerInput)) {
                System.out.println("Oops! 4 digits must be all different. Please try again. \n-------------------");
            } else {
                isValidInput = true;
            }
        }

        return playerInput;
    }

    private boolean hasAllDifferentDigits(String num) {
        // Check if each digit in the input number is different
        for (int i = 0; i < num.length(); i++) {
            for (int j = i + 1; j < num.length(); j++) {
                if (num.charAt(i) == num.charAt(j)) {
                    return false;
                }
            }
        } return true;
    }

    public int validatePlayerChoice(String prompt, int[] validChoices) {
        while (true) {
            System.out.print(prompt);
            String userInput = scanner.nextLine().trim();

            // Check if user input is a valid integer
            try {
                int userChoice = Integer.parseInt(userInput);

                // Check if choice is within validChoices
                for (int i = 0; i < validChoices.length; i++) {
                    if (userChoice == validChoices[i]) {
                        return userChoice;
                    }
                }

                System.out.println("  Invalid input. Please choose from the valid options.");
            } catch (NumberFormatException e) {
                System.out.println("  Invalid input. Please enter a valid number.");
            }
        }
    }

}

