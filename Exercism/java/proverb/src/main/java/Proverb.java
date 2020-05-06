import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Proverb {

    /**
     * more about Lambda && method reference
     * - https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html
     * - https://docs.oracle.com/javase/tutorial/java/javaOO/methodreferences.html
     */

    String[] words;

    Proverb(String[] words) {
        this.words = words;
    }

    String recite() {
        return IntStream.range(0, words.length)
                .mapToObj(this::format)
                .collect(Collectors.joining("\n"));
    }

    private String format(int s) {
        return s != words.length - 1 ?
                "For want of a " + words[s] + " the " + words[s + 1] + " was lost."
                : "And all for the want of a " + words[0] + ".";
    }



//**   another solution *//
//    String reciteV0() {
//        if (words.length == 0) { return ""; }
//        String s0 = "For want of a ";
//        String s1 = " the ";
//        String s2 = " was lost.\n";
//        String s3 = ".";
//        String last = "And all for the want of a ";
//        StringBuilder stringBuilder = new StringBuilder();
//        if (words.length > 1) {
//            for (int i = 0; i < words.length - 1; i++) {
//                stringBuilder.append(s0).append(words[i]).append(s1).append(words[i + 1]).append(s2);
//            }
//            stringBuilder.append(last).append(words[0]).append(s3);
//        } else {
//            return last + words[0] + s3;
//        }
//        return stringBuilder.toString();
//    }
}
