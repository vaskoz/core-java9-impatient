import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Ch13_1_Test {
    private final ZonedDateTime zdt = ZonedDateTime.of(
            LocalDateTime.of(2018, 6, 2, 12, 0, 0, 0),
            ZoneId.of("Europe/Paris"));

    @Test
    public void franceDateTime() {
        assertEquals("samedi 2 juin 2018 à 12:00:00 heure d’été d’Europe centrale",
                Ch13_1.getFranceDateTime(this.zdt));
    }

    @Test
    public void chinaDateTime() {
        assertEquals("2018年6月2日星期六 中欧夏令时间 下午12:00:00",
                Ch13_1.getChinaDateTime(this.zdt));
    }

    @Test
    public void thailandDateTime() {
        assertEquals("วันเสาร์ที่ 2 มิถุนายน ค.ศ. 2018 12 นาฬิกา 00 นาที 00 วินาที Central European Summer Time",
                Ch13_1.getThailandDateTime(this.zdt));
    }

}
