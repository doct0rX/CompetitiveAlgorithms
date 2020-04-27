import java.util.Objects;

public class Hamming {
    int hammingDistance = 0;
    public Hamming(String leftStrand, String rightStrand) {
        try {
            if (leftStrand.length() != rightStrand.length()) {
                if (leftStrand.equals("")) {
                    throw new IllegalArgumentException("left strand must not be empty.");
                }
                if (rightStrand.equals("")){
                    throw new IllegalArgumentException("right strand must not be empty.");
                }
                throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
            } else {
                char[] rightChars = rightStrand.toCharArray();
                int cCount = 0;
                for (char c : leftStrand.toCharArray()) {
                    if (c != rightChars[cCount]) {
                        hammingDistance += 1;
                    }
                    cCount += 1;
                }
            }
        } catch (Exception e) {
            throw new UnsupportedOperationException("Err " + e);
        }
        
    }

    public int getHammingDistance() {
        try {
            return hammingDistance;
        } catch (Exception e) {
            throw new UnsupportedOperationException("Err " + e);
        }
    }
}
