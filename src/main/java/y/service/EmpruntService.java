package y.service;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import y.domain.Emprunt;
import y.repository.EmpruntRepository;

/**
 * Service Implementation for managing {@link Emprunt}.
 */
@Service
@Transactional
public class EmpruntService {

    private final Logger log = LoggerFactory.getLogger(EmpruntService.class);

    private final EmpruntRepository empruntRepository;

    public EmpruntService(EmpruntRepository empruntRepository) {
        this.empruntRepository = empruntRepository;
    }

    /**
     * Save a emprunt.
     *
     * @param emprunt the entity to save.
     * @return the persisted entity.
     */
    public Emprunt save(Emprunt emprunt) {
        log.debug("Request to save Emprunt : {}", emprunt);
        return empruntRepository.save(emprunt);
    }

    /**
     * Partially update a emprunt.
     *
     * @param emprunt the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<Emprunt> partialUpdate(Emprunt emprunt) {
        log.debug("Request to partially update Emprunt : {}", emprunt);

        return empruntRepository
            .findById(emprunt.getId())
            .map(existingEmprunt -> {
                if (emprunt.getStart() != null) {
                    existingEmprunt.setStart(emprunt.getStart());
                }
                if (emprunt.getEnd() != null) {
                    existingEmprunt.setEnd(emprunt.getEnd());
                }

                return existingEmprunt;
            })
            .map(empruntRepository::save);
    }

    /**
     * Get all the emprunts.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<Emprunt> findAll(Pageable pageable) {
        log.debug("Request to get all Emprunts");
        return empruntRepository.findAll(pageable);
    }

    /**
     * Get one emprunt by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<Emprunt> findOne(Long id) {
        log.debug("Request to get Emprunt : {}", id);
        return empruntRepository.findById(id);
    }

    /**
     * Delete the emprunt by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Emprunt : {}", id);
        empruntRepository.deleteById(id);
    }
}
