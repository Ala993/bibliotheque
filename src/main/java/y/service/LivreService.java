package y.service;

import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import y.domain.Livre;

/**
 * Service Interface for managing {@link Livre}.
 */
public interface LivreService {
    /**
     * Save a livre.
     *
     * @param livre the entity to save.
     * @return the persisted entity.
     */
    Livre save(Livre livre);

    /**
     * Partially updates a livre.
     *
     * @param livre the entity to update partially.
     * @return the persisted entity.
     */
    Optional<Livre> partialUpdate(Livre livre);

    /**
     * Get all the livres.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<Livre> findAll(Pageable pageable);

    /**
     * Get the "id" livre.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Livre> findOne(Long id);

    /**
     * Delete the "id" livre.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
