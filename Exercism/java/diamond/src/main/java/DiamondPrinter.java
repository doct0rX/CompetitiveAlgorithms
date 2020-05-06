import java.util.ArrayList;
import java.util.List;

class DiamondPrinter {

    List<String> printToList(char a) {
        List<String> lines = new ArrayList<>();
        int diffFromA = a - 'A';
        lines.add(getPadding(diffFromA) + 'A' + getPadding(diffFromA));
        for (int i = 1; i <= diffFromA; i++) {
            int innerPadding = 2 * i - 1;
            int outerPadding = diffFromA - i;
            lines.add(getPadding(outerPadding) + (char) ('A' + i) +
                    getPadding(innerPadding) + (char) ('A' + i) + getPadding(outerPadding));
        }
        for (int i = lines.size() - 2; i >= 0; i--) {
            lines.add(lines.get(i));
        }
        return lines;
    }

    private String getPadding(int spaceCount) {
        return " ".repeat(spaceCount);
    }
}
