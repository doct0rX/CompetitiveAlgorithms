class LargestSeriesProductCalculator {

    String strNumber;

    LargestSeriesProductCalculator(String inputNumber) {
        if (!inputNumber.matches("^\\s*\\d*\\s*$")) { throw new IllegalArgumentException("String to search may only contain digits."); }
        this.strNumber = inputNumber;

    }

    long calculateLargestProductForSeriesLength(int numberOfDigits) {
        if (numberOfDigits < 0) { throw new IllegalArgumentException("Series length must be non-negative."); }
        if (numberOfDigits > strNumber.length()) { throw new IllegalArgumentException("Series length must be less than or equal to the length of the string to search."); }
        long highest = 0;
        for (int i = 0; i < strNumber.length() - numberOfDigits + 1; i++) {
            int c = 1;
            for (int j = 0; j < numberOfDigits; j++) {
                c *= Character.getNumericValue(strNumber.charAt(i + j));
            }
            if (c > highest) highest = c;
        }
        return highest;
    }
}
