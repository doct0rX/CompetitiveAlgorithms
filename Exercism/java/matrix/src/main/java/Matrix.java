class Matrix {

    private final String matrix;
    String[] matrixArr;

    Matrix(String matrixAsString) {
        this.matrix = matrixAsString;
        this.matrixArr = matrixAsString.split("\n");
    }

    int[] getRow(int rowNumber) {
        int[] res = new int[getColsNum()];
        String[] intsStr = matrixArr[rowNumber - 1].split(" ");
        for (int i = 0; i < getColsNum(); i++) {
            res[i] = Integer.parseInt(intsStr[i]);
        }
        return res;
    }

    int[] getColumn(int columnNumber) {
        int[] res = new int[getRowsNum()];

        for (int i = 0; i < getRowsNum(); i++) {
            String[] cols = matrixArr[i].split(" ");
            res[i] = Integer.parseInt(cols[columnNumber - 1]);
        }
        return res;
    }

    int getRowsNum() {
        return matrixArr.length;
    }

    int getColsNum() {
        return matrixArr[0].split(" ").length;
    }
}
