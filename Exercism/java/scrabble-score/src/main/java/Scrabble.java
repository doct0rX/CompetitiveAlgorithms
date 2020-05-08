import java.util.HashMap;
import java.util.Map;

class Scrabble {

    String word;
    Map<String, Integer> scoreMap = new HashMap<>();

    Scrabble(String word) {
        this.word = word.toUpperCase();
        String[][] holder = new String[][] {
                new String[]{"A", "E", "I", "O", "U", "L", "N", "R", "S", "T"},
                new String[]{"D", "G"},
                new String[]{"B", "C", "M", "P"},
                new String[]{"F", "H", "V", "W", "Y"},
                new String[]{"K"},
                new String[]{"J", "X"},
                new String[]{"Q", "Z"}
        };
        int[] values = new int[] {1, 2, 3, 4, 5, 8, 10};
        int valCounter = 0;
        for (String[] sArr : holder) {
            for (String s: sArr) {
                scoreMap.put(s, values[valCounter]);
            }
            valCounter++;
        }
    }

    int getScore() {
        int score = 0;
        for (int i = 0; i < word.length(); i++) {
            score += scoreMap.get(String.valueOf(word.charAt(i)));
        }
        return score;
    }

}
