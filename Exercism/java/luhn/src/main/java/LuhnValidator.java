import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

class LuhnValidator {

     boolean isValid(String candidate) {
        Pattern p = Pattern.compile("[^0-9 ]", Pattern.CASE_INSENSITIVE);
        Matcher matcher = p.matcher(candidate);
        if (matcher.find()) { return false; }
        String can = candidate.replaceAll("[^0-9]+", "");
        if (can.length() < 2) { return false; }
        int sum = 0;
        int toDouble = 0;
        if (can.length() % 2 != 0) {
            toDouble = 1;
        }
        for (int i = 0; i < can.length(); i++) {
            int n = Integer.parseInt(String.valueOf(can.charAt(i)));
            if (toDouble % 2 == 0) {
                if (n * 2 > 9) {
                    n = n * 2 - 9;
                } else {
                    n *= 2;
                }
            }
            toDouble++;
            sum += n;
        }
        return sum % 10 == 0;
    }

    /**
     * another solution using Streams
     */
    //public boolean isValid(String str) {
    //
    //    String s = str.trim().replaceAll(" ", "");
    //    String[] nums = s.split("");
    //    return s.matches("^\\d{2,}") && total(nums) % 10 == 0;
    //}
    //
    //    private int total(String[] nums) {
    //        int startDigit = (nums.length & 1) == 0 ? 0 : 1;
    //        return IntStream.range(0, nums.length)
    //                .map(i -> (i & 1) == startDigit ? doubleDigit(Integer.parseInt(nums[i])) : Integer.parseInt(nums[i]))
    //                .sum();
    //    }
    //
    //    private int doubleDigit(int x) {
    //        if (x * 2 > 9) return x * 2 - 9;
    //        return x * 2;
    //    }
}
