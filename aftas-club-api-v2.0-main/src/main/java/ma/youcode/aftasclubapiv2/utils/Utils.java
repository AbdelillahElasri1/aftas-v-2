package ma.youcode.aftasclubapiv2.utils;

import ma.youcode.aftasclubapiv2.exceptions.TimeExpiredException;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Utils {
    public static String generateCode(String location, String date) {
        String locationCode = location.substring(0, 3);
        String dayAndMonth = date.substring(0, 5);
        String year = date.substring(8, 10);
        return locationCode.toLowerCase() + "-" + dayAndMonth + "-" + year;
    }

    public static Long calculateDaysUntilCompetition(LocalDate date) {
        long days = ChronoUnit.DAYS.between(LocalDate.now(), date);
        if (days == 1) throw new TimeExpiredException("Cannot accept members 24h before competition start");
        else if (days == 0) throw new TimeExpiredException("Cannot accept members after competition is started");
        else if (days < 0) throw new TimeExpiredException("Cannot accept members after competition expired " + days + " days ago.");
        return days;
    }
}
