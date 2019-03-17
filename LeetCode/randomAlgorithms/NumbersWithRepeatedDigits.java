/**
 * https://leetcode.com/problems/numbers-with-repeated-digits/
 */

/**
 * Intuition
 * 
 * Count res the Number Without Repeated Digit
 * Then the number with repeated digits = N - res
 * 
 * Similar as
 * 788. Rotated Digits
 * 902. Numbers At Most N Given Digit Set
 * 
 * Explanation:
 *      1. Transform N + 1 to arrayList
 *      2. Count the number with digits < n
 *      3. Count the number with same prefix
 * 
 * For example,
 * if N = 8765, L = [8,7,6,6],
 * the number without repeated digit can the the following format:
 * XXX
 * XX
 * X
 * 1XXX ~ 7XXX
 * 80XX ~ 86XX
 * 870X ~ 875X
 * 8760 ~ 8765
 * 
 * Time Complexity:
 *   the number of permutations A(m,n) is O(1)
 *   We count digit by digit, so it's O(logN)
 */
class NumbersWithRepeatedDigits {
    
    public int numDupDigitsAtMostN(int N) {
        // Transform N + 1 to arrayList
        List<Integer> L = new ArrayList<Integer>();
        for (int x = N + 1; x > 0; x /= 10) {
            L.add(0, x % 10);
        }

        // Count the number with digits < N
        int res = 0, n = L.size();
        for (int i = 1; i < n; ++i) {
            res += 9 * A(9, i - 1);
        }

        // Count the number with same prefix
        Set<Integer> seen = new HashSet<>();
        for (int i = 0; i < n; ++i) {
            for (int j = i > 0 ? 0 : 1; j < L.get(i); ++j) {
                if (!seen.contains(j))
                    res += A(9 - i, n - i - 1);
            }
            if (seen.contains(L.get(i))) break; // break here Because he firstly counts the Number Without Repeated Digit, so 2nd 7 is not allowed here.
            seen.add(L.get(i));
        }
        return N - res;
    }

    int A(int m, int n) {
        return n == 0 ? 1 : A(m, n - 1) * (m - n + 1);
    }
}
