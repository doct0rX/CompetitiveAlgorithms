import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HandshakeCalculatorBitwiseOp {

    List<Signal> calculateHandshake(int number) {
        List<Signal> handshake = new ArrayList<>();
        for (Signal h: Signal.values()) {
            if (((number >> h.ordinal()) & 1) == 1) {
                handshake.add(h);
            }
        }
        if (((number >> 4) & 1) == 1) { Collections.reverse(handshake); }

        return handshake;
    }
}
