import java.util.ArrayList;
import java.util.Arrays;

class Knapsack {

     int maximumValue(int limit, ArrayList<Item> items) {
        // populate the base case
        int[][] mat = new int[items.size() + 1][limit + 1];
        for (int r = 0; r <= limit; r++) {
            mat[0][r] = 0;
        }
        for (int c = 0; c <= items.size(); c++) {
            mat[c][0] = 0;
        }

        // main logic
        for (int item = 1; item <= items.size(); item++) {
            for (int capacity = 1; capacity <= limit; capacity++) {
                int maxValWithoutCurrent = mat[item - 1][capacity];    // this is guaranteed to exist
                int maxValWithCurrent = 0;  // init w/ 0
                int weightOfCurrent = items.get(item - 1).getWeight();  // use (item - 1) to account for extra row at the top -- I started the loop w/ 1
                if (capacity >= weightOfCurrent) {  // check if the current item can fit in the knapsack
                    maxValWithCurrent = items.get(item - 1).getValue(); // if so, maxValWithCurrent hold the value of the current item

                    int remainingCapacity = capacity - weightOfCurrent; // remainingCapacity must be >= 0
                    maxValWithCurrent += mat[item - 1][remainingCapacity];  // add the maximum value obtainable w/ the remaining capacity
                }
                mat[item][capacity] = Math.max(maxValWithCurrent, maxValWithoutCurrent);
            }
        }
//        System.out.println(Arrays.deepToString(mat)); // Visualization of the table
        return mat[items.size()][limit];
    }
}


class Item {

    int w, v;

    Item(int wi, int vi) {
        this.w = wi;
        this.v = vi;
    }

    int getWeight() { return w; }
    int getValue() { return v; }
}