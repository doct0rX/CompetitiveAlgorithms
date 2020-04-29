import java.util.stream.IntStream;

public class Hamming {
    int hammingDistance = 0;
    public Hamming(String leftStrand, String rightStrand) {
        if (leftStrand.length() != rightStrand.length()) {
            if (leftStrand.isEmpty()) {
                throw new IllegalArgumentException("left strand must not be empty.");
            }
            if (rightStrand.isEmpty()) {
                throw new IllegalArgumentException("right strand must not be empty.");
            }
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        } else {
            for (int i = 0; i < leftStrand.length(); i++) {
                if (leftStrand.codePointAt(i) != rightStrand.codePointAt(i)) {
                    hammingDistance += 1;
                }
            }
        }
    }

    public int getHammingDistance() {
        try {
            return hammingDistance;
        } catch (Exception e) {
            throw new UnsupportedOperationException("Err " + e);
        }
    }


    /**
     * stream solution
     */
    int getHammingDistance2(String leftStrand, String rightStrand) {
        if (leftStrand.length() != rightStrand.length()) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
        return IntStream
                .range(0, leftStrand.length())
                .map(i -> leftStrand.charAt(i) != rightStrand.charAt(i) ? 1: 0)
                .sum();
    }
}
