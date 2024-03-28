package ma.youcode.aftasclubapiv2.dto.requests;

public record RankRequest(
        Integer rank,
        Integer score,

        UserRequest user,

        CompetitionRequest competition
) implements _Request {
}
