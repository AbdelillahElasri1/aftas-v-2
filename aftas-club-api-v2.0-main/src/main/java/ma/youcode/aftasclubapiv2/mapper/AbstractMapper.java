package ma.youcode.aftasclubapiv2.mapper;

import ma.youcode.aftasclubapiv2.dto.requests._Request;
import ma.youcode.aftasclubapiv2.dto.responses._Response;
import ma.youcode.aftasclubapiv2.entities._Entity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.lang.reflect.ParameterizedType;
import java.util.List;

@Component
public abstract class AbstractMapper<ID, Request extends _Request, Response extends _Response<ID>, Entity extends _Entity<ID>> implements _Mapper<ID, Request, Response, Entity> {

    public ModelMapper mapper;
    public Class<Entity> _entity;
    public Class<Response> _response;

    @Autowired
    public void SetMapper(ModelMapper m) {
        this.mapper = m;
    }

    @Override
    public Entity toEntityFromRequest(Request request) {
        _entity = (Class<Entity>) ((ParameterizedType) getClass().getGenericSuperclass())
                .getActualTypeArguments()[3];
        assert _entity != null;
        return mapper.map(request, _entity);
    }

    @Override
    public Entity toEntityFromResponse(Response response) {
        _entity = (Class<Entity>) ((ParameterizedType) getClass().getGenericSuperclass())
                .getActualTypeArguments()[3];
        assert _entity != null;
        return mapper.map(response, _entity);
    }

    @Override
    public Response toResponse(Entity entity) {
        _response = (Class<Response>) ((ParameterizedType) getClass().getGenericSuperclass())
                .getActualTypeArguments()[2];
        assert _response != null;
        return mapper.map(entity, _response);
    }

    @Override
    public List<Response> toResponse(List<Entity> entities) {
        _response = (Class<Response>) ((ParameterizedType) getClass().getGenericSuperclass())
                .getActualTypeArguments()[2];
        assert _response != null;
        return entities.stream().map(entity -> mapper.map(entity, _response)).toList();
    }

    @Override
    public Page<Response> toResponse(Page<Entity> page) {
        _response = (Class<Response>) ((ParameterizedType) getClass().getGenericSuperclass())
                .getActualTypeArguments()[2];
        assert _response != null;
        return page.map(p -> mapper.map(p, _response));
    }
}
