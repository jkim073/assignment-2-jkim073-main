package assignment2;

import java.util.Scanner;

public class GameManager {

    private Scanner scanner = new Scanner(System.in);
    private PlayerInputValidation inputValidator = new PlayerInputValidation(scanner);

    public void start() {

        // Print Welcome message and get Player's name
        System.out.println("\n***** Welcome to the Game Manager! *****");
        System.out.print("  Enter your name >> ");
        String playerName = scanner.nextLine();
        String computerName = "computer";


        int gameChoice = chooseGame(playerName);

        if (gameChoice == 1) {
            Game bullsAndCows = new Game();
            bullsAndCows.BullsAndCows(playerName);

        } else { System.out.println("Play Wordle");}

    }

    private int chooseGame(String playerName) {
        System.out.println("\n Choose your game, " + playerName + ":");
        System.out.println("\t -Enter \"1\" to play 'Bulls and Cows'");
        System.out.println("\t -Enter \"2\" to play 'Wordle'");

       int[] validChoices = {1, 2};
        return inputValidator.validatePlayerChoice("  >> ", validChoices);

    }

    public static void main(String[] args) {
        GameManager gm = new GameManager();
        gm.start();
    }
}
