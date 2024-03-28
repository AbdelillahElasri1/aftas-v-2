package ma.youcode.aftasclubapiv2.web.rest;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ma.youcode.aftasclubapiv2.dto.requests._Request;
import ma.youcode.aftasclubapiv2.dto.responses._Response;
import ma.youcode.aftasclubapiv2.entities._Entity;
import ma.youcode.aftasclubapiv2.exceptions.ResourceNotCreatedException;
import ma.youcode.aftasclubapiv2.mapper._Mapper;
import ma.youcode.aftasclubapiv2.services._Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Getter
@Validated
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class _Controller<ID, Request extends _Request, Response extends _Response<ID>, Service extends _Service<ID, Request, Response>> {

    public Service _service;

    // TODO: fix this issue of multiple beans
    @Autowired
    public void setService(Service service) {
        this._service = service;
    }

    /**
     * Creates a new entity based on the provided request.
     *
     * @param request       The request DTO.
     * @param bindingResult The result of the validation.
     * @return ResponseEntity containing the created entity or a bad request if creation fails.
     */
    @PostMapping
    public ResponseEntity<Response> create(
            @Valid @RequestBody Request request,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors())
            handleValidationError(bindingResult);

        assert _service != null;
        Optional<Response> response = _service.create(request);

        return response.map(ResponseEntity::ok).orElseGet(() ->
                ResponseEntity.badRequest().build());
    }

    /**
     * Retrieves all entities with pagination.
     *
     * @param pageable The pagination information.
     * @return ResponseEntity containing a page of entities.
     */
    @GetMapping("/paged")
    public ResponseEntity<Page<Response>> getAll(Pageable pageable) {
        assert _service != null;
        return ResponseEntity.ok(_service.getAll(pageable));
    }

    /**
     * Retrieves all entities.
     *
     * @return ResponseEntity containing a list of entities.
     */
    @GetMapping
    public ResponseEntity<List<Response>> getAll() {
        assert _service != null;
        return ResponseEntity.ok(_service.getAll());
    }

    /**
     * Retrieves an entity by its identifier.
     *
     * @param id The identifier of the entity.
     * @return ResponseEntity containing the retrieved entity or not found response if the entity does not exist.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Response> getById(@Valid @PathVariable("id") ID id) {
        assert _service != null;
        return _service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Updates an existing entity based on the provided request.
     *
     * @param request       The request DTO.
     * @param bindingResult The result of the validation.
     * @return ResponseEntity containing the updated entity or not found response if the update fails.
     */
    @PatchMapping
    public ResponseEntity<Response> update(
            @Valid @RequestBody Response request,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors())
            handleValidationError(bindingResult);

        assert _service != null;
        Optional<Response> updated = _service.update(request);

        return updated.map(ResponseEntity::ok).orElseGet(() ->
                ResponseEntity.notFound().build());
    }

    /**
     * Deletes an entity based on the provided request.
     *
     * @param request       The request DTO.
     * @param bindingResult The result of the validation.
     * @return ResponseEntity with no content if deletion is successful, or not found response if deletion fails.
     */
    @DeleteMapping
    public ResponseEntity<Void> delete(
            @Valid @RequestBody Response request,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors())
            handleValidationError(bindingResult);

        assert _service != null;
        if (_service.delete(request)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Handles validation errors by throwing a {@link ResourceNotCreatedException}.
     *
     * @param bindingResult The result of the validation.
     */
    protected void handleValidationError(BindingResult bindingResult) {
        throw new ResourceNotCreatedException(bindingResult.toString());
    }
}
