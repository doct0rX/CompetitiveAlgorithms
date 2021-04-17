import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Matrix {

    List<List<Integer>> pValues;

    Matrix(List<List<Integer>> values) {
        pValues = values;
    }

    Set<MatrixCoordinate> getSaddlePoints() {
        HashSet<MatrixCoordinate> res = new HashSet<MatrixCoordinate>();
        int currentPosValue;
        for (int i = 0; i < pValues.size(); i++) {
            for (int j = 0; j < pValues.get(i).size(); j++) {
                currentPosValue = pValues.get(i).get(j);
                if (checkRows(currentPosValue, i, j) && checkCols(currentPosValue, i, j)) {
                    res.add(new MatrixCoordinate(i + 1, j + 1));
                }
            }
        }
        return res;
    }


    boolean checkRows(int rowVal, int xCoordination, int yCoordination) {
        int totalVals = 0;
        if (pValues.get(xCoordination).size() > 0) {
            for (int i = 0; i < pValues.get(xCoordination).size(); i++) {
                if (rowVal >= pValues.get(xCoordination).get(i)) {
                    ++totalVals;
                }
            }
        }
        return totalVals == pValues.get(xCoordination).size();
    }

    boolean checkCols(int colVal, int xCoordination, int yCoordination) {
        int totalVals = 0;
        if (pValues.size() > 0) {
            for (int i = 0; i < pValues.size(); i++) {
                if (colVal <= pValues.get(i).get(yCoordination)) {
                    ++totalVals;
                }
            }
        }
        return totalVals == pValues.size();
    }
}
