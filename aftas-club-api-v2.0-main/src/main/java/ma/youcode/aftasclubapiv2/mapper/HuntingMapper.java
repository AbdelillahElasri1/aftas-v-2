package ma.youcode.aftasclubapiv2.mapper;

import ma.youcode.aftasclubapiv2.dto.requests.HuntRequest;
import ma.youcode.aftasclubapiv2.dto.responses.HuntResponse;
import ma.youcode.aftasclubapiv2.entities.Hunting;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class HuntingMapper extends AbstractMapper<UUID, HuntRequest, HuntResponse, Hunting> {
}
