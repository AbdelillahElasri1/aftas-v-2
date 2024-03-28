package ma.youcode.aftasclubapiv2.entities;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * This interface represents the base entity with common fields like ID, creation timestamp,
 * update timestamp, and version. Entities in the application should implement this interface.
 *  @author Mohamed Ossalhe
 *
 * @param <ID> The type of the entity's identifier.
 */
public interface _Entity<ID> extends Serializable {


    /**
     * Gets the unique identifier of the entity.
     *
     * @return The entity's identifier.
     */
    ID getId();


    /**
     * Gets the timestamp when the entity was created.
     *
     * @return The timestamp of creation.
     */
    Timestamp getCreatedAt();


    /**
     * Gets the timestamp when the entity was last updated.
     *
     * @return The timestamp of the last update.
     */
    Timestamp getUpdatedAt();

}
