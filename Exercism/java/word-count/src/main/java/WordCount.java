import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

class WordCount {

    public WordCount() {

    }

    Map<String, Integer> phrase(String words) {
        final Pattern splitWords = Pattern.compile("\\W+");
//        return splitWords.splitAsStream(words.toLowerCase())
//                .collect(Collectors.groupingBy(Function.identity(),
//                        Collectors.collectingAndThen(Collectors.counting(), Long::intValue)));

        String wordsClean = splitWords.matcher(words).replaceAll(" ")
                .trim().toLowerCase().replaceAll(" '", ""). replaceAll("' ", "");
        Map<String, Integer> res = new HashMap<String, Integer>();
        for (String word: wordsClean.split("(\\s+)")) {
            if (res.containsKey(word)) {
                res.replace(word, res.get(word) + 1);
            } else {
                res.put(word, 1);
            }
        }
        return res;
    }
}