package ma.youcode.aftasclubapiv2.mapper;

import ma.youcode.aftasclubapiv2.dto.requests.LevelRequest;
import ma.youcode.aftasclubapiv2.dto.responses.LevelResponse;
import ma.youcode.aftasclubapiv2.entities.Level;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class LevelMapper extends AbstractMapper<UUID, LevelRequest, LevelResponse, Level>{
}
