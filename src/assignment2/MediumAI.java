package assignment2;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class MediumAI extends AI {
    protected Set<String> generatedCodes;
    protected Random random;
    protected MediumAI() {
        generatedCodes = new HashSet<>();
        random = new Random();
    }
    @Override
    protected String generateCode(Random random) {
        String code;
        do {
            code = super.generateCode(random);
        } while (generatedCodes.contains(code));

        generatedCodes.add(code);
        System.out.println(generatedCodes);
        System.out.println(code);
        return code;
    }

//    public static void main(String[] args) {
//        MediumAI mediumAI = new MediumAI();
//        mediumAI.generateCode(mediumAI.random);
//    }
}

