class IsogramChecker {

    boolean isIsogram(String phr) {
        // there are 2 ways to solve it either by a string and sort it then check every next 2 chars
        // or using hashMap <- and i'll go w/ it

        String phrase = phr.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int length = phrase.length();
        int[] hashMap = new int[26];

        for (int i = 0; i < length; i++) {
            int occurrence = ++hashMap[phrase.charAt(i) - 'a']; // charAt(i) - 'a' + 1 -> to return index value
            if (occurrence > 1) { return false; }
        }
        return true;
    }

    //** another solution: **//
//    boolean isIsogram(String phrase) {
//        phrase = phrase.replace("-", "").replace(" ", "").toLowerCase();
//
//        return (phrase.chars().distinct().count() == phrase.length());
//    }
}
