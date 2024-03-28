package ma.youcode.aftasclubapiv2.services.implementations;

import ma.youcode.aftasclubapiv2.dto.requests.LevelRequest;
import ma.youcode.aftasclubapiv2.dto.responses.LevelResponse;
import ma.youcode.aftasclubapiv2.entities.Level;
import ma.youcode.aftasclubapiv2.mapper.LevelMapper;
import ma.youcode.aftasclubapiv2.repositories.LevelRepository;
import ma.youcode.aftasclubapiv2.services.LevelService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LevelServiceImpl extends AbstractServiceImpl<UUID, LevelRequest, LevelResponse, Level, LevelRepository, LevelMapper> implements LevelService
{
}
