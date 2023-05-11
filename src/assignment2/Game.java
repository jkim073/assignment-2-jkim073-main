package assignment2;

import java.util.Random;
import java.util.Scanner;
public class Game {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

    String computerName = null;
    PlayerInputValidation inputValidator = new PlayerInputValidation(scanner);

    public void BullsAndCows(String playerName) {

        //choose 1 random welcome message out of 4
        String[] welcomeMessage = {
                "***** Welcome to the ultimate Bulls and Cows challenge, " + playerName +"! *****\nGet ready for an adrenaline-pumping, mind-bending experience that will put your code-breaking skills to the test.",
                "***** Step into the thrilling world of Bulls and Cows, " + playerName + "! *****\nPrepare to unravel secret codes, decipher patterns, and outsmart your opponents.",
                "***** Greetings, " + playerName + "! *****\nWelcome to the Bulls and Cows arena, where sharp minds collide and strategic thinking reigns supreme.",
                "***** Welcome, fearless challenger " + playerName + "! *****\nGet ready to unleash your mental prowess in the captivating Bulls and Cows universe."
        };
        int index = random.nextInt(welcomeMessage.length);
        System.out.println("\n---------------------------------------------------------");
        System.out.println(welcomeMessage[index]);

        // receive secret code from the player
        System.out.println("If you are ready, Enter your 4-digit secret code:");

        String playerSecretCode = inputValidator.validateFourDigitInput();

        // choose difficulty level (AI)
        int difficultyLevel = chooseDifficulty(playerName);

        // play against chosen AI
        switch (difficultyLevel) {
            case 1:
                System.out.println(computerName + " is unleashed!");
                break;
            case 2:
                System.out.println("Get ready to challenge the brilliance of "+ computerName + "!");
                break;
            case 3:
                System.out.println(computerName + " awakens, ready to dominate!");
                break;
        }

        // generate a random secret code (AI)
        int[] secretCode = generateAISecretCode(random);
        System.out.println(computerName + " has chosen a secret code. Let's play!!");

        // player's turn to guess
        System.out.println("Your turn to guess: ");
        String playerGuess = inputValidator.validateFourDigitInput();
        System.out.println(playerGuess);

        // check the status of the game
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
        System.out.println("The stage is set, " + playerName + "!\n It's time to decide which opponent will put your skills to the test. Choose wisely!");

        System.out.println("\t -Enter \"1\" for 'SwiftBot' (Lv 1)");
        System.out.println("\t -Enter \"2\" for 'MindBlazer' (Lv 2)");
        System.out.println("\t -Enter \"3\" for 'GrandMaster' (Lv 3)");

        int[] validChoices = {1, 2, 3};
        int playerInput = inputValidator.validatePlayerChoice("  >> ", validChoices);
        switch (playerInput) {
            case 1:
                computerName = "SwiftBot-Lv1";
                break;
            case 2:
                computerName = "MindBlazer-Lv2";
                break;
            case 3:
                computerName = "GrnadMaster-Lv3";
                break;
        }
        return playerInput;
    }
}