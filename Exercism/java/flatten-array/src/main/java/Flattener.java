import java.util.*;


class Flattener {

    public Flattener() { }

    public static List<?> flatten(List<?> nestedObjectsList) {
        List<Object> res = new ArrayList<Object>();
        if (nestedObjectsList.isEmpty()) { return res; }
        for (Object obj: nestedObjectsList) {
            if (obj instanceof String || obj instanceof Integer || obj instanceof Character) {
                res.add(obj);
            } else if (obj == null) {
//                 do nothing
            } else {
                res.addAll(flatten((List<?>) obj));
            }
        }
        return res;
    }
}