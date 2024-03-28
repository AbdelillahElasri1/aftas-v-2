package ma.youcode.aftasclubapiv2.services.implementations;

import jakarta.validation.Valid;
import ma.youcode.aftasclubapiv2.dto.requests._Request;
import ma.youcode.aftasclubapiv2.dto.responses._Response;
import ma.youcode.aftasclubapiv2.entities._Entity;
import ma.youcode.aftasclubapiv2.exceptions.ResourceNotCreatedException;
import ma.youcode.aftasclubapiv2.exceptions.ResourceNotFoundException;
import ma.youcode.aftasclubapiv2.mapper._Mapper;
import ma.youcode.aftasclubapiv2.services._Service;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public abstract class AbstractServiceImpl<ID, Request extends _Request, Response extends _Response<ID>, Entity extends _Entity<ID>, Repository extends JpaRepository<Entity, ID>, Mapper extends _Mapper<ID, Request, Response, Entity>> implements _Service<ID, Request, Response> {
    private Mapper _mapper;
    private Repository _repository;

    @Autowired
    public void SetMapper(Mapper mapper) {
        this._mapper = mapper;
    }

    @Autowired
    public void SetRepository(Repository repository) {
        this._repository = repository;
    }

    /**
     * Retrieves a list of all entities.
     *
     * @return List of response DTOs representing all entities.
     */
    public List<Response> getAll() {
        assert _mapper != null;
        assert _repository != null;
        return _mapper.toResponse(_repository.findAll());
    };

    /**
     * Retrieves all entities in a paginated form.
     *
     * @param pageable Pagination information.
     * @return Page of response DTOs.
     */
    public Page<Response> getAll(Pageable pageable) {
        assert _mapper != null;
        assert _repository != null;
        return _mapper.toResponse(_repository.findAll(pageable));
    };

    /**
     * Creates a new entity based on the provided request DTO.
     *
     * @param request DTO containing data for entity creation.
     * @return Optional containing the response DTO of the created entity.
     */
    public Optional<Response> create(@Valid Request request) {
        assert _mapper != null;
        Entity entity = _mapper.toEntityFromRequest(request);
        try {
            assert _repository != null;
            Entity savedEntity = _repository.saveAndFlush(entity);
            return Optional.of(_mapper.toResponse(savedEntity));
        }catch (Exception e) {
            throw new ResourceNotCreatedException(e.getMessage());
        }
    };

    /**
     * Updates an existing entity based on the provided response DTO.
     *
     * @param response DTO containing updated data.
     * @return Optional containing the response DTO of the updated entity.
     */
    public Optional<Response> update(@Valid Response response) {
        assert _mapper != null;
        Entity entityToUpdate = _mapper.toEntityFromResponse(response);
        try {
            assert _repository != null;
            Entity updatedEntity = _repository.saveAndFlush(entityToUpdate);
            return Optional.of(_mapper.toResponse(updatedEntity));
        }catch (Exception e) {
            throw new ResourceNotCreatedException(e.getMessage());
        }
    };

    /**
     * Retrieves an entity by its unique identifier.
     *
     * @param id Unique identifier of the entity.
     * @return Optional containing the response DTO of the found entity.
     */
    public Optional<Response> getById(ID id) {
        assert _mapper != null;
        assert _repository != null;
        Entity entity = _repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No Resource Found with ID: " + id.toString()));
        return Optional.of(_mapper.toResponse(entity));
    };

    /**
     * Deletes an entity based on the provided response DTO.
     *
     * @param response DTO containing data for entity deletion.
     * @return Boolean indicating the success of the deletion operation.
     */
    public Boolean delete(@Valid Response response) {
        assert _mapper != null;
        Entity entityToDelete = _mapper.toEntityFromResponse(response);
        assert _repository != null;
        if (!_repository.existsById(entityToDelete.getId())) {
            return false;
        }
        try {
            _repository.delete(entityToDelete);
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).error("Error while deleting entity", e);
            throw new ResourceNotCreatedException(e.getMessage());
        }
        return true;
    };
}
