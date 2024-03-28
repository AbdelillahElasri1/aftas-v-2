package ma.youcode.aftasclubapiv2.dto.requests;

public record LevelRequest(
        String description,
        Integer points
) implements _Request {
}
