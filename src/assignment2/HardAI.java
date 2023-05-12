package assignment2;

import java.util.*;

public class HardAI {

    String result = null;
        public String getAllPossibleCodes() {
                StringBuilder sb = new StringBuilder();
                for (int w = 0; w <= 9; w++) {
                    for (int x = 0; x <= 9; x++) {
                        for (int y = 0; y <= 9; y++) {
                            for (int z = 0; z <= 9; z++) {
                                // make sure 4 digits are unique using HashSet
                                Set<Integer> digitSet = new HashSet<>();
                                digitSet.add(w);
                                digitSet.add(x);
                                digitSet.add(y);
                                digitSet.add(z);

                                if (digitSet.size() == 4) {
                                    sb.append(String.valueOf(w) + String.valueOf(x) + String.valueOf(y) + String.valueOf(z))
                                            .append(",");
                                }
                            }
                        }
                    }
                }
                return sb.toString();
            }
    public List<String> codeList(String input) {
        List<String> list = new ArrayList<>();
        String[] lines = input.split(",");
        for (String line : lines) {
            list.add(line);
        }
        return list;
    }

        public static void main(String[] args) {
            HardAI ai = new HardAI();
            ai.result = ai.getAllPossibleCodes();
            List<String> list = ai.codeList(ai.result);
            int size = ai.codeList(ai.result).size();
            System.out.println(list);
            System.out.println(size);

        }
    }

