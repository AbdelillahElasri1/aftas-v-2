package ma.youcode.aftasclubapiv2.mapper;

import ma.youcode.aftasclubapiv2.dto.requests.FishRequest;
import ma.youcode.aftasclubapiv2.dto.responses.FishResponse;
import ma.youcode.aftasclubapiv2.entities.Fish;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class FishMapper extends AbstractMapper<UUID, FishRequest, FishResponse, Fish> {
}
