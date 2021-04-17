import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Matrix {

    List<List<Integer>> values;

    Matrix(List<List<Integer>> values) { this.values = values; }

    Set<MatrixCoordinate> getSaddlePoints() {
        HashSet<MatrixCoordinate> res = new HashSet<MatrixCoordinate>();
        for (int i = 0; i < values.size(); i++) {
            for (int j = 0; j < values.get(i).size(); j++) {
                int currentPosValue = values.get(i).get(j);
                if (checkRows(currentPosValue, i, j) && checkCols(currentPosValue, i, j)) {
                    res.add(new MatrixCoordinate(i + 1, j + 1));
                }
            }
        }
        return res;
    }

    boolean checkRows(int rowVal, int xCoordination, int yCoordination) {
        if (values.get(xCoordination).size() > 0) {
            for (int i = 0; i < values.get(xCoordination).size(); i++) {
                if (rowVal < values.get(xCoordination).get(i)) { return false; }
            }
        }
        return true;
    }

    boolean checkCols(int colVal, int xCoordination, int yCoordination) {
        if (values.size() > 0) {
            for (List<Integer> pValue : values) {
                if (colVal > pValue.get(yCoordination)) { return false; }
            }
        }
        return true;
    }
}
