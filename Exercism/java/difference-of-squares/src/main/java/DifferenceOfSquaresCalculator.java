class DifferenceOfSquaresCalculator {

    int computeSquareOfSumTo(int input) {
        int sum = 0;
        while (input > 0) {
            sum += input--;
        }
        return (int) Math.pow(sum, 2);
    }

    int computeSumOfSquaresTo(int input) {
        int sum = 0;
        while (input > 0) {
            sum += (int) Math.pow(input--, 2);
        }
        return sum;
    }

    int computeDifferenceOfSquares(int input) {
        return computeSquareOfSumTo(input) - computeSumOfSquaresTo(input);
    }
}
