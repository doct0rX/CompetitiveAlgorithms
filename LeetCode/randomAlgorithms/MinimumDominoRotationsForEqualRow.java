import java.util.HashMap;
import java.util.Map;


class  MinimumDominoRotationsForEqualRow {

    static int[] tops = new int[] {2,1,2,4,2,2};
    static int[] bottoms = new int[] {5,2,6,2,3,2};
    
    static int[] tops1 = new int[] {3,5,1,2,3};
    static int[] bottoms1 = new int[] {3,6,3,3,4};

    static int [] tops2 = new int[] {1,2,1,1,1,2,2,2};
    static int [] bottoms2 = new int[] {2,1,2,2,2,2,2,2};

    public static void main(String[] args) {
        System.out.println(minDominoRotations(tops, bottoms));
        System.out.println(minDominoRotations(tops1, bottoms1));
        System.out.println(minDominoRotations(tops2, bottoms2));
    }

    public static int minDominoRotations(int[] tops, int[] bottoms) {
        int minRotations = Math.min(numSwaps(commonElement(tops), tops, bottoms) , numSwaps(commonElement(bottoms), tops, bottoms));
        minRotations = Math.min(minRotations, numSwaps(commonElement(bottoms), bottoms, tops));
        minRotations = Math.min(minRotations, numSwaps(commonElement(tops), bottoms, tops));
        return minRotations == Integer.MAX_VALUE? -1: minRotations;
    }

    private static int numSwaps(int commonElement, int[] tops, int[] bottoms) {
        int rotations = 0;
        for (int i = 0; i < tops.length; i++) {
            if (tops[i] != commonElement && bottoms[i] != commonElement) {
                return Integer.MAX_VALUE;
            } else if (commonElement != tops[i] && commonElement == bottoms[i]) {
                rotations++;
            }
        }
        return rotations;
    }

    static int commonElement(int[] arr) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int a: arr) {
            Integer freq = map.get(a);
            map.put(a, freq == null? 1: freq + 1);
        }
        int max = -1;
        int mostFreq = -1;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getValue() > max) {
                mostFreq = e.getKey();
                max = e.getValue();
            }
        }
        return mostFreq;
    }
}