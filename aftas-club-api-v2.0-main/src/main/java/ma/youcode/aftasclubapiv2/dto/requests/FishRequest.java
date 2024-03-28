package ma.youcode.aftasclubapiv2.dto.requests;

public record FishRequest(
        String name,
        Integer averageWeight,
        LevelRequest level
) implements _Request {
}
