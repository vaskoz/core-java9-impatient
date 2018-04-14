import org.junit.jupiter.api.Test;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Ch12_11_Test {
    @Test
    public void testFlightTime() {
        var frankfurt = ZonedDateTime.of(2017, 12, 15, 14, 5, 0, 0, ZoneId.of("CET"));
        var losAngeles = ZonedDateTime.of(2017, 12, 15, 16, 40, 0, 0, ZoneId.of("America/Los_Angeles"));
        assertEquals("PT11H35M", Ch12_11.calculateFlightTime(frankfurt, losAngeles).toString());
    }
}
