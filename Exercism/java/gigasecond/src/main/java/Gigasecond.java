import java.time.LocalDate;
import java.time.LocalDateTime;

public class Gigasecond {

    final long GIGASECOND = (long) Math.pow(10, 9);
    LocalDateTime localDateTime;

    public Gigasecond(LocalDate moment) {
        this.localDateTime = moment.atStartOfDay();
    }

    public Gigasecond(LocalDateTime moment) {
        this.localDateTime = moment;
    }

    public LocalDateTime getDateTime() {
        return localDateTime.plusSeconds(GIGASECOND);
    }
}
