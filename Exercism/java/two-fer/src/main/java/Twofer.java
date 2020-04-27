import java.util.Optional;

public class Twofer {
    public String twofer(String name) {
        try {
            return String.format("One for %s, one for me.", Optional.ofNullable(name).orElse("you"));
        } catch (Exception e) {
            throw new UnsupportedOperationException("Err" + e);
        }
    }
}
