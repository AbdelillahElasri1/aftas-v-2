package ma.youcode.aftasclubapiv2.services.implementations;

import ma.youcode.aftasclubapiv2.dto.requests.FishRequest;
import ma.youcode.aftasclubapiv2.dto.responses.FishResponse;
import ma.youcode.aftasclubapiv2.entities.Fish;
import ma.youcode.aftasclubapiv2.mapper.FishMapper;
import ma.youcode.aftasclubapiv2.repositories.FishRepository;
import ma.youcode.aftasclubapiv2.services.FishService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class FishServiceImpl extends AbstractServiceImpl<UUID, FishRequest, FishResponse, Fish, FishRepository, FishMapper> implements FishService
{
}
