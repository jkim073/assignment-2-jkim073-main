package assignment2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public abstract class AI {

    protected String generateCode(Random random) {
        StringBuilder Code = new StringBuilder();

        for (int i = 0; i < 4; i++) {
            boolean unique = false;
            while (!unique) {
                int digit = random.nextInt(10);
                unique = true;
                for (int j = 0; j < i; j++) {
                    if (Code.charAt(j) - '0' == digit) {
                        unique = false;
                        break;
                    }
                }
                if (unique) {
                    Code.append(digit);
                }
            }
        }

        return Code.toString();
    }


//    private List<String> possibleGuesses;
//
//    public AI() {
//        possibleGuesses = generatePossibleGuesses();
//    }
//
//    public String makeGuess() {
//        if (possibleGuesses.size() == 1) {
//            return possibleGuesses.get(0);
//        }
//        Random rand = new Random();
//        int index = rand.nextInt(possibleGuesses.size());
//        String guess = possibleGuesses.get(index);
//        possibleGuesses.remove(guess);
//        return guess;
//    }
//
//    private List<String> generatePossibleGuesses() {
//        List<String> guesses = new ArrayList<>();
//        String digits = "0123456789";
//        for (int i = 0; i < digits.length(); i++) {
//            for (int j = 0; j < digits.length(); j++) {
//                if (j == i) {
//                    continue;
//                }
//                for (int k = 0; k < digits.length(); k++) {
//                    if (k == i || k == j) {
//                        continue;
//                    }
//                    for (int l = 0; l < digits.length(); l++) {
//                        if (l == i || l == j || l == k) {
//                            continue;
//                        }
//                        guesses.add("" + digits.charAt(i) + digits.charAt(j) + digits.charAt(k) + digits.charAt(l));
//                    }
//                }
//            }
//        }
//        return guesses;
//    }
}

