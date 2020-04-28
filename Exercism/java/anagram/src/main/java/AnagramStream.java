import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AnagramStream {

    private String word;

    public AnagramStream(String word) {
        this.word = word;
    }

    public List<String> match(List<String> list) {
        return list.stream()
                .filter(w -> Arrays.equals(this.word.toLowerCase().chars().sorted().toArray(),
                        w.toLowerCase().chars().sorted().toArray())
                        && !w.toLowerCase().equals(this.word.toLowerCase()))
                .collect(Collectors.toList());
    }
}
