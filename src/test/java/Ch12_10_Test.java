import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Ch12_10_Test {
    @Test
    public void laToFrankfurt() {
        // Leave Los Angeles at 3:05p Los Angeles time
        ZonedDateTime laTakeoff = ZonedDateTime.of(2017, 12, 15, 15, 5, 0, 0, ZoneId.of("America/Los_Angeles"));
        ZoneId frankfurtTimeZone = ZoneId.of("CET");
        Duration flightDuration = Duration.ofHours(10).plusMinutes(50);
        ZonedDateTime expectedArrival = laTakeoff.plusHours(10).plusMinutes(50).withZoneSameInstant(frankfurtTimeZone);
        assertEquals(expectedArrival, Ch12_10.calculateArrivalTime(laTakeoff, flightDuration, frankfurtTimeZone));
    }
}
