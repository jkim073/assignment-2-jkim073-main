package assignment2;

import java.util.Map;
import java.util.Random;

public abstract class GameMechanics {

    protected abstract String generateWelcomeMessage(String playerName);

    protected abstract String generateAISecretCode(Random random);

    protected boolean isGameLost(int maxGuesses, int guessCounter) {
        return guessCounter < maxGuesses;
    }

        protected int countBulls(String guess, String code) {
        int bulls = 0;
        for (int i = 0; i < guess.length(); i++) {
            if (guess.charAt(i) == code.charAt(i)) {
                bulls++;
            }
        }
        return bulls;
    }

        protected int countCows(String guess, String code) {
        int cows = 0;
        for (int i = 0; i < guess.length(); i++) {
            char c = guess.charAt(i);
            if (code.indexOf(c) != -1) {
                cows++;
            }
        }
        return cows;
    }
}