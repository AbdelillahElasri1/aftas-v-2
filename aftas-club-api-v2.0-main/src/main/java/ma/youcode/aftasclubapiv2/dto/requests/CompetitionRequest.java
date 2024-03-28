package ma.youcode.aftasclubapiv2.dto.requests;

import java.time.LocalDate;
import java.time.LocalTime;

public record CompetitionRequest(
        LocalDate date,
        LocalTime startTime,
        LocalTime endTime,
        Integer numberOfParticipants,
        String location,
        double amount

) implements _Request {
}
