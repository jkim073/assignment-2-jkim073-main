package assignment2;

import java.util.Random;
import java.util.Scanner;
public class Game {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    PlayerInputValidation inputValidator = new PlayerInputValidation(scanner);

    public void BullsAndCows(String playerName) {

        // generate a random secret code (AI)
        int[] secretCode = generateAISecretCode(random);

        //choose 1 random welcome message out of 4
        String[] welcomeMessage = {
                "***** Let's play Bulls and Cows! *****\n\nThe AI has picked a secret code.\nIt's your turn to choose a secret code, " + playerName + ".",
                "***** Get ready to play Bulls and Cows! *****\n\nThe AI has set a secret code.\nIt's now your turn to choose a secret code, " + playerName + ".",
                "***** Welcome to Bulls and Cows! *****\n\nThe AI has a chosen secret code.\nCan you choose yours, " + playerName + "?",
                "***** Bulls and Cows time! *****\n\nThe AI has chosen a secret code.\nPlease choose yours, " + playerName + "."
        };
        int index = random.nextInt(welcomeMessage.length);
        System.out.println("\n---------------------------------------------------------");
        System.out.println(welcomeMessage[index]);

        // receive secret code from the player
        System.out.println("Enter your 4-digit secret code:");

        String playerSecretCode = inputValidator.validateFourDigitInput();

        // choose difficulty level (AI)
        int difficultyLevel = chooseDifficulty(playerName);

        // play against chosen AI
        switch (difficultyLevel) {
            case 1:
                System.out.println("SwiftBot (Lv1) is unleashed!");
                break;
            case 2:
                System.out.println("Get ready to challenge the brilliance of MindBlazer (Lv2)!");
                break;
            case 3:
                System.out.println("GrandMaster (Lv3) awakens, ready to dominate!");
                break;
        }

        int numGuesses = 0;
        int guessCounter = 6;
        boolean gameWon = false;


    }

    public int[] generateAISecretCode(Random random) {
        int[] secretCode = new int[4];

        for (int i = 0; i < 4; i++) {
            boolean unique = false;
            while (!unique) {
                int digit = random.nextInt(9) + 1;
                unique = true;
                for (int j = 0; j < i; j++) {
                    if (secretCode[j] == digit) {
                        unique = false;
                        break;
                    }
                }
                if (unique) {
                    secretCode[i] = digit;
                }
            }
        }

        return secretCode;
    }

    private int chooseDifficulty(String playerName) {
        System.out.println("The stage is set, " + playerName + "! It's time to decide which opponent will put your skills to the test. Choose wisely!");

        System.out.println("\t -Enter \"1\" for 'SwiftBot' (Lv 1)");
        System.out.println("\t -Enter \"2\" for 'MindBlazer' (Lv 2)");
        System.out.println("\t -Enter \"3\" for 'GrandMaster' (Lv 3)");

        int[] validChoices = {1, 2, 3};
        return inputValidator.validatePlayerChoice("  >> ", validChoices);
    }
}