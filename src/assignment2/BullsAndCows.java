package assignment2;

import java.util.Random;
import java.util.Scanner;
public class BullsAndCows extends GameMechanics {

    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

    String computerName = null;
    PlayerInputValidation inputValidator = new PlayerInputValidation(scanner);

    AI easyAI = new EasyAI();
    AI mediumAI = new MediumAI();
    AI hardAI = new HardAI();

//    private static final int MAX_GUESSES = 4;
//    private int[] playerSecretCode;
//    private int[] computerSecretCode;
//    private GameMechanics playerGuessTracker;
//    private GameMechanics computerGuessTracker;

    public void play (String playerName) {

        generateWelcomeMessage(playerName);

        String playerSecretCode = getPlayerSecretCode();

        // choose difficulty level (AI)

            int difficultyLevel = chooseDifficulty(playerName);
            AI chosenAI = null;
            // play against chosen AI
        try {
            switch (difficultyLevel) {
                case 1:
                    System.out.println(computerName + " is unleashed!");
                    chosenAI = new EasyAI();
                    break;
                case 2:
                    System.out.println("Get ready to challenge the brilliance of " + computerName + "!");
                    chosenAI = new MediumAI();
                    break;
                case 3:
                    System.out.println(computerName + " awakens, ready to dominate!");
                    chosenAI = new HardAI();
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + difficultyLevel);
            }
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // generate a random computer secret code
        String computerSecretCode = generateAISecretCode(random);
        System.out.println(computerName + " has chosen a secret code. Let's play!!" + computerSecretCode);

        int maxGuesses = 7;
        int guessCounter = 0;

        while (super.isGameLost(maxGuesses, guessCounter)) {

            // player's turn to guess
            System.out.println("Your turn to guess: ");
            String playerGuess = inputValidator.validateFourDigitInput();
            //int[] parsedPlayerGuess = parsePlayerGuess(playerGuess);
            int playerBulls = countBulls(playerGuess, computerSecretCode);
            int playerCows = countCows(playerGuess, computerSecretCode) - playerBulls;
            System.out.println("Result of " + playerName + "'s guess no. " + (guessCounter+1) + ": " +
                    playerBulls + " bulls and " + playerCows + " cows.\n");

            // if the player has 4 bulls, game finishes
            if (playerBulls == 4) {
                System.out.println("Congratulations!" + playerName + " wins!");
                return;
            }

            // Computer's turn
            String computerGuess = chosenAI.generateCode(random);
            System.out.println(computerName + "'s guess is: " + computerGuess);
            int computerBulls = countBulls(computerGuess, playerSecretCode);
            int computerCows = countCows(computerGuess, playerSecretCode) - computerBulls;
            System.out.println("Result of " + computerName + "'s guess no. " + (guessCounter+1) + ": " +
                    computerBulls + " bulls and " + computerCows + " cows.\n");
            guessCounter++;

            // if the computer has 4 bulls, game finishes
            if (computerBulls == 4) {
                System.out.println("Sorry, " + playerName + " you lose and " +
                        computerName + " wins! Wohahahaha");
                return;
            }
        }
        System.out.println("It's a draw! " + computerName + "'s code was " + computerSecretCode);
    }

    @Override
    protected String generateWelcomeMessage(String playerName) {
        //choose 1 random welcome message out of 4
        String[] welcomeMessage = {
                "***** Welcome to the ultimate Bulls and Cows challenge, " + playerName + "! *****\nGet ready for an adrenaline-pumping, mind-bending experience that will put your code-breaking skills to the test.",
                "***** Step into the thrilling world of Bulls and Cows, " + playerName + "! *****\nPrepare to unravel secret codes, decipher patterns, and outsmart your opponents.",
                "***** Greetings, " + playerName + "! *****\nWelcome to the Bulls and Cows arena, where sharp minds collide and strategic thinking reigns supreme.",
                "***** Welcome, fearless challenger " + playerName + "! *****\nGet ready to unleash your mental prowess in the captivating Bulls and Cows universe."
        };
        int index = random.nextInt(welcomeMessage.length);
        System.out.println("\n---------------------------------------------------------");
        return (welcomeMessage[index]);
    }

    private String getPlayerSecretCode() {
        System.out.println("If you are ready, Enter your 4-digit secret code:");
        String playerSecretCode = inputValidator.validateFourDigitInput();
        return playerSecretCode;
    }

    private int[] parsePlayerGuess(String guessString){
        int[] guess = new int[4];
        for (int i = 0; i < 4; i++) {
            guess[i] = Character.getNumericValue(guessString.charAt(i));
        }
        return guess;
    }
    @Override
    public String generateAISecretCode(Random random) {
        return easyAI.generateCode(random);
    }
//    public int[] generateAISecretCode(Random random) {
//        int[] secretCode = new int[4];
//
//        for (int i = 0; i < 4; i++) {
//            boolean unique = false;
//            while (!unique) {
//                int digit = random.nextInt(9) + 1;
//                unique = true;
//                for (int j = 0; j < i; j++) {
//                    if (secretCode[j] == digit) {
//                        unique = false;
//                        break;
//                    }
//                }
//                if (unique) {
//                    secretCode[i] = digit;
//                }
//            }
//        }
//
//        return secretCode;
//    }



    private int chooseDifficulty(String playerName) {
        System.out.println("The stage is set, " + playerName + "!\n It's time to decide which opponent will put your skills to the test. Choose wisely!");

        System.out.println("\t -Enter \"1\" for 'SwiftBot-E' (Easy AI)");
        System.out.println("\t -Enter \"2\" for 'MindBlazer-M' (Medium AI)");
        System.out.println("\t -Enter \"3\" for 'GrandMaster-H' (Hard AI)");

        int[] validChoices = {1, 2, 3};
        int playerInput = inputValidator.validatePlayerChoice("  >> ", validChoices);
        switch (playerInput) {
            case 1:
                computerName = "SwiftBot-E";
                break;
            case 2:
                computerName = "MindBlazer-M";
                break;
            case 3:
                computerName = "GrandMaster-H";
                break;
        }
        return playerInput;
    }
}
