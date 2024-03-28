package ma.youcode.aftasclubapiv2.services;

import jakarta.validation.Valid;
import ma.youcode.aftasclubapiv2.dto.requests._Request;
import ma.youcode.aftasclubapiv2.dto.responses._Response;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * Generic service interface with common CRUD (Create, Read, Update, Delete) operations.
 *
 * @param <ID>  The type of the unique identifier.
 * @param <Request> The request DTO type.
 * @param <Response> The response DTO type.
 * @author Mohamed Ossalhe
 */
public interface _Service<ID, Request extends _Request, Response extends _Response<ID>> {
    /**
     * Retrieves a list of all entities.
     *
     * @return List of response DTOs representing all entities.
     */
    List<Response> getAll();

    /**
     * Retrieves all entities in a paginated form.
     *
     * @param pageable Pagination information.
     * @return Page of response DTOs.
     */
    Page<Response> getAll(Pageable pageable);

    /**
     * Creates a new entity based on the provided request DTO.
     *
     * @param request DTO containing data for entity creation.
     * @return Optional containing the response DTO of the created entity.
     */
    Optional<Response> create(@Valid Request request);

    /**
     * Updates an existing entity based on the provided response DTO.
     *
     * @param response DTO containing updated data.
     * @return Optional containing the response DTO of the updated entity.
     */
    Optional<Response> update(@Valid Response response);

    /**
     * Retrieves an entity by its unique identifier.
     *
     * @param id Unique identifier of the entity.
     * @return Optional containing the response DTO of the found entity.
     */
    Optional<Response> getById(ID id);

    /**
     * Deletes an entity based on the provided response DTO.
     *
     * @param response DTO containing data for entity deletion.
     * @return Boolean indicating the success of the deletion operation.
     */
    Boolean delete(@Valid Response response);
}
