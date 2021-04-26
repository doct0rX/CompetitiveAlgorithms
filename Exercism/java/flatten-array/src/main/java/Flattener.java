import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


class Flattener {

    public Flattener() { }

    public static List<?> flatten(List<?> nestedObjectsList) {
        List<Object> res = new ArrayList<Object>();
        for (Object obj: nestedObjectsList) {
            if (obj instanceof List) {
                res.addAll(flatten((List<?>) obj));
            } else if (obj != null) {
                res.add(obj);
            }
        }
        return res;
    }

    /**
     * steams solution [[Another solution]]
     */
    public static List<Object> flattenSteam(List<Object> input) {
        return input
                .stream()
                .flatMap(e -> e instanceof List ?
                        Flattener.flatten((List<Object>) e).stream() :
                        Stream.of(e))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}