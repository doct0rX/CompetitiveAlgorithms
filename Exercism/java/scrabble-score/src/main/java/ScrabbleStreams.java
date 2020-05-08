import java.util.HashMap;
import java.util.Map;

public class ScrabbleStreams {

    /**
     * here setting every char w/ its integer key to the map and points it to integer value;
     */

    String word;
    static final Map<Integer, Integer> lScore = new HashMap<>(26);
    static {
        "AEIOULNRST".chars().forEach(c -> lScore.put(c, 1));
        "DG".chars().forEach(c -> lScore.put(c, 2));
        "BCMP".chars().forEach(c -> lScore.put(c, 3));
        "FHVWY".chars().forEach(c -> lScore.put(c, 4));
        "K".chars().forEach(c -> lScore.put(c, 5));
        "JX".chars().forEach(c -> lScore.put(c, 8));
        "QZ".chars().forEach(c -> lScore.put(c, 10));
    }

    ScrabbleStreams(String word) {
        this.word = word.toUpperCase();
    }

    int getScore() {
        return word.chars().reduce(0, (a, b) -> a + lScore.get(b));
    }
}
