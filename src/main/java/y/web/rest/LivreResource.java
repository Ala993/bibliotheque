package y.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.PaginationUtil;
import tech.jhipster.web.util.ResponseUtil;
import y.domain.Livre;
import y.repository.LivreRepository;
import y.service.LivreService;
import y.web.rest.errors.BadRequestAlertException;

@RestController
@RequestMapping("/api")
public class LivreResource {

    private final Logger log = LoggerFactory.getLogger(LivreResource.class);

    private static final String ENTITY_NAME = "livre";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final LivreService livreService;

    private final LivreRepository livreRepository;

    public LivreResource(LivreService livreService, LivreRepository livreRepository) {
        this.livreService = livreService;
        this.livreRepository = livreRepository;
    }


    @PostMapping("/livres")
    public ResponseEntity<Livre> createLivre(@RequestBody Livre livre) throws URISyntaxException {
        log.debug("REST request to save Livre : {}", livre);
        if (livre.getId() != null) {
            throw new BadRequestAlertException("A new livre cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Livre result = livreService.save(livre);
        return ResponseEntity
            .created(new URI("/api/livres/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }


    @PutMapping("/livres/{id}")
    public ResponseEntity<Livre> updateLivre(@PathVariable(value = "id", required = false) final Long id, @RequestBody Livre livre)
        throws URISyntaxException {
        log.debug("REST request to update Livre : {}, {}", id, livre);
        if (livre.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, livre.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!livreRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Livre result = livreService.save(livre);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, livre.getId().toString()))
            .body(result);
    }


    @PatchMapping(value = "/livres/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<Livre> partialUpdateLivre(@PathVariable(value = "id", required = false) final Long id, @RequestBody Livre livre)
        throws URISyntaxException {
        log.debug("REST request to partial update Livre partially : {}, {}", id, livre);
        if (livre.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, livre.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!livreRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<Livre> result = livreService.partialUpdate(livre);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, livre.getId().toString())
        );
    }

    @GetMapping("/livres")
    public ResponseEntity<List<Livre>> getAllLivres(@org.springdoc.api.annotations.ParameterObject Pageable pageable) {
        log.debug("REST request to get a page of Livres");
        Page<Livre> page = livreService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }


    @GetMapping("/livres/{id}")
    public ResponseEntity<Livre> getLivre(@PathVariable Long id) {
        log.debug("REST request to get Livre : {}", id);
        Optional<Livre> livre = livreService.findOne(id);
        return ResponseUtil.wrapOrNotFound(livre);
    }


    @DeleteMapping("/livres/{id}")
    public ResponseEntity<Void> deleteLivre(@PathVariable Long id) {
        log.debug("REST request to delete Livre : {}", id);
        livreService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString()))
            .build();
    }
}