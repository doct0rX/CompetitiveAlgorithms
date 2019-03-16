/**
 * https://leetcode.com/contest/weekly-contest-127/problems/clumsy-factorial/
 */

class ClumsyFactorial {

    public int clumsy(int N) {
        // if (N <= 2)
        //     return N;
        // if (N <= 4)
        //     return N + 3;
        // if ((N - 4) % 4 == 0) 
        //     return N + 1;
        // else if ((N - 4) % 4 <= 2)
        //     return N + 2;
        // else
        //     return N - 1;
        int[] magic = new int[]{1, 2, 2, -1, 0, 0, 3, 3};
        return N + ((N > 4)? magic[N % 4] : magic[N + 3]);
    }
}
