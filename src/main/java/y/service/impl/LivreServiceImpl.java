package y.service.impl;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import y.domain.Livre;
import y.repository.LivreRepository;
import y.service.LivreService;

/**
 * Service Implementation for managing {@link Livre}.
 */
@Service
@Transactional
public class LivreServiceImpl implements LivreService {

    private final Logger log = LoggerFactory.getLogger(LivreServiceImpl.class);

    private final LivreRepository livreRepository;

    public LivreServiceImpl(LivreRepository livreRepository) {
        this.livreRepository = livreRepository;
    }

    @Override
    public Livre save(Livre livre) {
        log.debug("Request to save Livre : {}", livre);
        return livreRepository.save(livre);
    }

    @Override
    public Optional<Livre> partialUpdate(Livre livre) {
        log.debug("Request to partially update Livre : {}", livre);

        return livreRepository
            .findById(livre.getId())
            .map(existingLivre -> {
                if (livre.getName() != null) {
                    existingLivre.setName(livre.getName());
                }
                if (livre.getAuthor() != null) {
                    existingLivre.setAuthor(livre.getAuthor());
                }
                if (livre.getCategory() != null) {
                    existingLivre.setCategory(livre.getCategory());
                }

                return existingLivre;
            })
            .map(livreRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Livre> findAll(Pageable pageable) {
        log.debug("Request to get all Livres");
        return livreRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Livre> findOne(Long id) {
        log.debug("Request to get Livre : {}", id);
        return livreRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Livre : {}", id);
        livreRepository.deleteById(id);
    }
}
