import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class HandshakeCalculator {

    List<Signal> calculateHandshake(int number) {
        List<Signal> hs = new ArrayList<Signal>();
        boolean reverse = false;
        String binaryString = Integer.toBinaryString(number);
        System.out.println(binaryString);
        int binaryInt = Integer.parseInt(binaryString);
        while (binaryInt >= 10000) {
            reverse = !reverse;
            binaryInt -= 10000;
        }
        while (binaryInt >= 1000) {
            hs.add(0, Signal.JUMP);
            binaryInt -= 1000;
        }
        while (binaryInt >= 100) {
            hs.add(0, Signal.CLOSE_YOUR_EYES);
            binaryInt -= 100;
        }
        while (binaryInt >= 10) {
            hs.add(0, Signal.DOUBLE_BLINK);
            binaryInt -= 10;
        }
        while (binaryInt >= 1) {
            hs.add(0, Signal.WINK);
            binaryInt -= 1;
        }
        if (reverse) { Collections.reverse(hs); }

        return hs;
    }
}
