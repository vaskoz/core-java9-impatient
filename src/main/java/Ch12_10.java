import java.time.Duration;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Ch12_10 {
    public static ZonedDateTime calculateArrivalTime(ZonedDateTime departureTime,
                                                     Duration flightDuration,
                                                     ZoneId destinationTimeZone) {
        return departureTime.plus(flightDuration).withZoneSameInstant(destinationTimeZone);
    }
}
