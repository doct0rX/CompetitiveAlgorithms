import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

import org.graalvm.compiler.nodes.calc.IntegerDivRemNode;

class Intervals {


    static int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(merge(intervals)));
    }

    static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        // Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        LinkedList<int[]> merged = new LinkedList<>();
        for (int[] in : intervals) {
            if (merged.isEmpty() || merged.getLast()[1] < in[0]) 
                merged.add(in);
            else
                merged.getLast()[1] = Math.max(merged.getLast()[1], in[1]);
        }

        return merged.toArray(new int[merged.size()][]);
    }
}