package ma.youcode.aftasclubapiv2.dto.requests;

public record HuntRequest(
        Integer numberOfFish,

        FishRequest fish,

        UserRequest user,

        CompetitionRequest competition
) implements _Request {
}
