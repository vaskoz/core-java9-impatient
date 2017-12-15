import java.time.Duration;
import java.time.ZonedDateTime;

public class Ch12_11 {
    public static Duration calculateFlightTime(ZonedDateTime takeoff, ZonedDateTime landing) {
        return Duration.between(takeoff, landing);
    }
}
