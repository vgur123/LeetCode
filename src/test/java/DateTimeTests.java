import org.junit.Test;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class DateTimeTests {

    @Test
    public void zonedTest() {
        ZonedDateTime meetingInNY = ZonedDateTime.of(
                2025, 10, 22, 11, 45, 0, 0,
                ZoneId.of("Europe/Moscow")
        );

        ZonedDateTime meetingInTokyo = meetingInNY.withZoneSameInstant(ZoneId.of("Asia/Tokyo"));

        System.out.println("NY - " + meetingInNY);
        System.out.println("Tokio - " + meetingInTokyo);
    }



    @Test
    public void departureTest() {

        ZonedDateTime departure = ZonedDateTime.of(
                2025, 11, 18, 11, 30, 0, 0, ZoneId.of("Europe/Moscow")
        );
        ZonedDateTime arrival = departure.plusHours(3).withZoneSameInstant(ZoneId.of("Europe/Belgrade"));

        System.out.println("Moscow - " + departure);
        System.out.println("Belgrade - " + arrival);
    }
}
