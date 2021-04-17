import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MatrixStreams {

    List<List<Integer>> matrix;
    final int rows;
    final int cols;

    public MatrixStreams(List<List<Integer>> matrix) {
        this.matrix = matrix;
        this.rows = matrix.isEmpty() ? 0: matrix.size();
        this.cols = matrix.isEmpty() ? 0: matrix.get(0).size();
    }

    /**
     * Using .boxes() as:
     * otherwise it will be stream of int (which is primitive), so to get stream of objects need to call
     * .boxed() or .mapToObj(). what to choose depends on particular requirements like reducing memory usage (wrapped objects take more space),
     * execution speed (wrapping takes time), etc
     * */

    public Set<MatrixCoordinate> getSaddlePoints() {
        return IntStream.range(0, rows)
                .boxed()
                .flatMap(row -> IntStream.range(0, cols)
                        .boxed()
                        .filter(column -> matrix.get(row).get(column) >= rowMax(row))   // using those 2 filters for rows and cols before mapping to MatrixCoordinate(r, c);
                        .filter(column -> matrix.get(row).get(column) <= columnMin(column))
                        .map(column -> new MatrixCoordinate(row, column))
                        .collect(Collectors.toSet()).stream()
                ).collect(Collectors.toSet());
    }

    Integer columnMin(Integer column) {
        return matrix.stream()
                .map(row -> row.get(column))
                .min(Comparator.naturalOrder()).orElse(0);
    }

    Integer rowMax(Integer row) {
        return Collections.max(matrix.get(row));
    }
}
