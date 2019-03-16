/**
 * https://leetcode.com/contest/weekly-contest-127/problems/minimum-domino-rotations-for-equal-row/
 */

class MinimumDominoRotationsForEqualRow {

    static class Two{
        static Two common = null;
        Integer a, b;
        Two(int a, int b) {
            this.a = a;
            this.b = b;
        }
        
        static void mcommon(Two other) {
            if(common.a != other.a && common.a != other.b)
                common.a = null;
            if(common.b != other.a && common.b != other.b)
                common.b = null;
        }
    }

    public int minDominoRotations(int[] A, int[] B) {
        Two.common = new Two(A[0], B[0]);
        for (int i = 1; i < A.length; i++) {
            Two.mcommon(new Two(A[i], B[i]));
            if (Two.common.a == null && Two.common.b == null)
                return -1;
        }
        //find the common item in each pair (Two)
        int c = Two.common.a == null? Two.common.b: Two.common.a;
        //find its count in both the arrays
        int a_count=0,b_count=0;
        for(int i=0; i<A.length; i++){
            if(A[i] == c)
                a_count++;
            if(B[i] == c)
                b_count++;
        }
        //find the number of rotations required
        return A.length - Math.max(a_count, b_count);
    }
}
