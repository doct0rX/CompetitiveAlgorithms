
class IsbnVerifier {

    boolean isValid(String stringToVerify) {
        try {
            String omitDash = stringToVerify.replaceAll("[^0-9X]", "");
            char[] charArr = omitDash.toCharArray();
            int totalValue = 0;
            int v = 10;
            int pos = 0;
            if (charArr.length != 10) {
                return false;
            }
            while (pos <= 9) {
                if (charArr[pos] == 'X' && pos == 9) {
                    totalValue += 10;
                    break;
                } else {
                    totalValue += Character.getNumericValue(charArr[pos]) * v;
                    v--;
                    pos++;
                }
            }
            return totalValue % 11 == 0;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * another solution
     */
//    public boolean isValid(String stringToVerify) {
//        char[] chars = stringToVerify.replaceAll("[^0-9X]", "").toCharArray();
//        if (chars.length != 10) { return false; }
//        int sum = 0;
//        int total = 0;
//
//        for (int i = 0; i < chars.length; i++) {
//            total += (i == 9 && chars[i] == 'X') ? 10 : Character.getNumericValue(chars[i]);
//            sum += total;
//        }
//
//        return sum % 11 == 0;
//    }
}
